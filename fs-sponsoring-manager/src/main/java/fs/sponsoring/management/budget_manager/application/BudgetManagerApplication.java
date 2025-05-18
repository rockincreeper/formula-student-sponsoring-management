package fs.sponsoring.management.budget_manager.application;

import fs.sponsoring.management.budget_manager.application.services.SponsorService;
import fs.sponsoring.management.budget_manager.application.services.SponsoringService;
import fs.sponsoring.management.budget_manager.domain.aggregates.formula_student_team.TeamMember;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.ContactPerson;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.SponsorAggregate;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.address.Address;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.address.Country;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.address.State;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.phone_number.TelephoneAreaCode;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.phone_number.TelephoneNumber;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsoring.SponsoringAggregate;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsoring.SponsoringType;
import fs.sponsoring.management.budget_manager.infrastructure.persistence.InMemoryFormulaStudentTeamRepository;
import fs.sponsoring.management.budget_manager.infrastructure.persistence.InMemorySponsorRepository;
import fs.sponsoring.management.budget_manager.infrastructure.persistence.InMemorySponsoringRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.*;

@SpringBootApplication
@ComponentScan("fs.sponsoring.management.budget_manager")
public class BudgetManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(BudgetManagerApplication.class, args);
    }

    private final SponsoringService sponsoringService;
    private final SponsorService sponsorService;

    private final InMemoryFormulaStudentTeamRepository formulaStudentTeamRepository;
    private final InMemorySponsorRepository sponsorRepository;
    private final InMemorySponsoringRepository sponsoringRepository;

    private boolean isAppRunning;
    private TeamMember loggedInTeamMember;
    private final Scanner scanner = new Scanner(System.in);

    public BudgetManagerApplication(SponsoringService sponsoringService, SponsorService sponsorService, InMemoryFormulaStudentTeamRepository formulaStudentTeamRepository, InMemorySponsorRepository sponsorRepository, InMemorySponsoringRepository sponsoringRepository) {
        this.sponsoringService = sponsoringService;
        this.sponsorService = sponsorService;
        this.formulaStudentTeamRepository = formulaStudentTeamRepository;
        this.sponsorRepository = sponsorRepository;
        this.sponsoringRepository = sponsoringRepository;
        isAppRunning = true;
        runBudgetManager();
    }

    private void runBudgetManager() {
        while (isAppRunning) {
            selectUser();
            selectOperation();
        }
    }

    private void selectUser() {
        System.out.println("Type following integer to log in as this team member:");
        List<TeamMember> teamMembers = formulaStudentTeamRepository.findAllTeamMembers();
        Map<String, TeamMember> teamMemberMap = new HashMap<String, TeamMember>();
        for (int i = 0; i < teamMembers.size(); i++) {
            teamMemberMap.put(Integer.toString(i), teamMembers.get(i));
            System.out.println(i + " for " + teamMembers.get(i).getFirstName() + " " + teamMembers.get(i).getLastName());
        }

        String userInput = scanner.nextLine();
        this.loggedInTeamMember = teamMemberMap.get(userInput);

        System.out.println("Selected user: " + loggedInTeamMember.getFirstName() + " " + loggedInTeamMember.getLastName());
    }

    private void selectOperation() {
        System.out.println("Which operation would you like to perform? Type the following integer to perform the associated operation:");
        System.out.println("0:    create a sponsoring request for a new sponsor");
        System.out.println("1:    convert an existing sponsoring request to a official budget sponsoring");
        String selectedIdForOperation = scanner.nextLine();
        switch (selectedIdForOperation) {
            case "0":
                executeSponsoringRequestOperation();
                break;
            case "1":
                executeSponsoringConversionOperation();
                break;
            default:
                System.out.println("Invalid operation");
        }
    }

    private void executeSponsoringRequestOperation() {
        System.out.println("Please enter following details for the new sponsor:");
        System.out.println("Name:");
        String sponsorName = scanner.nextLine();
        System.out.println();
        System.out.println("Now the address details for the new sponsor:");
        System.out.println("City:");
        String sponsorCity = scanner.nextLine();
        System.out.println("Street:");
        String sponsorStreet = scanner.nextLine();
        System.out.println("House number:");
        int sponsorHouseNumber = Integer.parseInt(scanner.nextLine());
        Address sponsorAddress = sponsorService.createAddress(Country.GERMANY, State.BW, "01234", sponsorCity, sponsorStreet, sponsorHouseNumber);
        System.out.println();
        System.out.println("Now the details for the contact person from the new sponsor:");
        System.out.println("First name:");
        String contactPersonFirstName = scanner.nextLine();
        System.out.println("Last name:");
        String contactPersonLastName = scanner.nextLine();
        System.out.println("Phone number:");
        String contactPersonPhoneNumber = scanner.nextLine();
        TelephoneNumber fullPhoneNumber = sponsorService.createTelephoneNumber(TelephoneAreaCode.GERMANY, contactPersonPhoneNumber);
        ContactPerson contactPerson = sponsorService.createContactPerson(contactPersonFirstName, contactPersonLastName, fullPhoneNumber);
        System.out.println("The sponsor will be created...");
        SponsorAggregate newSponsor = sponsorService.createSponsor(sponsorName, sponsorAddress, contactPerson);
        System.out.println("Now the amount of budget the new sponsor wants to spend:");
        double budgetAmount = Double.parseDouble(scanner.nextLine());
        System.out.println("The sponsoring will be created...");
        sponsoringService.createSponsoringRequest(newSponsor, budgetAmount);
        System.out.println("Sponsoring created!");
    }

    private void executeSponsoringConversionOperation() {
        System.out.println("Which of the following sponsoring request do you want to convert:");
        List<SponsoringAggregate> sponsoringRequests = new ArrayList<SponsoringAggregate>();
        for (SponsoringAggregate sponsoring : sponsoringRepository.findAllSponsoringsOfTeam()) {
            if (sponsoring.getSponsoringType() == SponsoringType.SPONSORING_REQUEST) {
                sponsoringRequests.add(sponsoring);
            }
        }
        for (int i = 0; i < sponsoringRequests.size(); i++) {
            System.out.println("Type " + i + ":    for id " + sponsoringRequests.get(i).getId());
        }
        System.out.println();
        String sponsoringId = scanner.nextLine();
        System.out.println("Converting the sponsoring request to budget sponsoring...");
        sponsoringService.convertToBudgetSponsoring(this.loggedInTeamMember, sponsoringRequests.get(Integer.parseInt(sponsoringId)));
        System.out.println("Sponsoring converted to budget sponsoring!");
        System.out.println(formulaStudentTeamRepository.getTotalFinancialBudget());
    }
}

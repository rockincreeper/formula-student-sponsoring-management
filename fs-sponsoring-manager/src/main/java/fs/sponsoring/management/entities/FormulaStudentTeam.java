package fs.sponsoring.management.entities;

import fs.sponsoring.management.donation_manager.entities.Sponsoring;
import fs.sponsoring.management.donation_manager.entities.sponsor.Sponsor;
import fs.sponsoring.management.donation_manager.entities.team.TeamMember;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class FormulaStudentTeam {
    private final UUID id;
    private String teamName;
    private List<TeamMember> teamMembers;
    private List<Sponsoring> sponsorings;
    private List<Sponsor> sponsors;
    private double totalFinancialBudget;


    public FormulaStudentTeam(UUID id, String teamName, List<TeamMember> teamMembers, List<Sponsoring> sponsorings, List<Sponsor> sponsors, double totalFinancialBudget) {
        checkForCorrectTeamName(teamName);
        this.id = Objects.requireNonNull(id);
        this.teamName = Objects.requireNonNull(teamName);

        if(totalFinancialBudget < 0) {
            throw new IllegalArgumentException("Financial budget related numbers cannot be negative");
        }else{
            this.totalFinancialBudget = totalFinancialBudget;
        }

        assignTeamMembers(teamMembers);

        assignContracts(sponsorings);

        assignSponsors(sponsors);
    }

    private void assignTeamMembers(List<TeamMember> teamMembers) {
        Objects.requireNonNull(teamMembers);
        if(teamMembers.isEmpty()) {
            this.teamMembers = teamMembers;
        }else{
            this.teamMembers = new ArrayList<>(teamMembers);
        }
    }

    private void assignContracts(List<Sponsoring> sponsorings) {
        Objects.requireNonNull(sponsorings);
        if(sponsorings.isEmpty()) {
            this.sponsorings = sponsorings;
        }else{
            this.sponsorings = new ArrayList<Sponsoring>();
        }
    }

    private void assignSponsors(List<Sponsor> sponsors) {
        Objects.requireNonNull(sponsors);
        if(sponsors.isEmpty()) {
            this.sponsors = sponsors;
        }else{
            this.sponsors = new ArrayList<>(sponsors);
        }
    }

    private void checkForCorrectTeamName(String teamName) {
        if(teamName.trim().isEmpty()){
            throw new IllegalArgumentException("Team name cannot be null or empty");
        }
    }

    public List<Sponsoring> getContracts() {
        return sponsorings;
    }

    public void addContract(Sponsoring sponsoring) {
        this.sponsorings.add(sponsoring);
    }

    public List<Sponsor> getSponsors() {
        return sponsors;
    }

   public void addSponsor(Sponsor sponsor) {
        this.sponsors.add(sponsor);
    }

    public List<TeamMember> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(TeamMember teamMember) {
        this.teamMembers.add(teamMember);
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public double getTotalFinancialBudget() {
        return totalFinancialBudget;
    }

    public void setTotalFinancialBudget(double totalFinancialBudget) {
        this.totalFinancialBudget = totalFinancialBudget;
    }
}

package fs.sponsoring.management.budget_manager.application.services;

import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.ContactPerson;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.SponsorAggregate;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.SponsorRepository;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.address.Address;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.address.Country;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.address.State;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.phone_number.TelephoneAreaCode;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.phone_number.TelephoneNumber;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.sponsoring_package.SponsoringPackage;
import fs.sponsoring.management.budget_manager.domain.factories.SponsorFactory;
import fs.sponsoring.management.budget_manager.infrastructure.persistence.InMemoryFormulaStudentTeamRepository;
import fs.sponsoring.management.budget_manager.infrastructure.persistence.InMemorySponsorRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SponsorService {
    private final InMemoryFormulaStudentTeamRepository formulaStudentTeamRepository;
    private final InMemorySponsorRepository sponsorRepository;

    public SponsorService(InMemoryFormulaStudentTeamRepository formulaStudentTeamRepository, InMemorySponsorRepository sponsorRepository) {
        this.formulaStudentTeamRepository = formulaStudentTeamRepository;
        this.sponsorRepository = sponsorRepository;
    }

    public Address createAddress(Country country, State state, String zipCode, String city, String street, int houseNumber) {
        return SponsorFactory.createAddress(country, state, zipCode, city, street, houseNumber);
    }

    public ContactPerson createContactPerson(String firstName, String lastName, TelephoneNumber telephoneNumber) {
        String contactPersonId = UUID.randomUUID().toString();
        return SponsorFactory.createContactPerson(contactPersonId, firstName, lastName, telephoneNumber);
    }

    public SponsorAggregate createSponsor(String name, Address address, ContactPerson contactPerson) {
        String sponsorId = UUID.randomUUID().toString();
        String teamId = formulaStudentTeamRepository.getTeamId();
        SponsoringPackage sponsoringPackage = SponsorFactory.createSponsoringPackage(0);
        SponsorAggregate createdSponsor = SponsorFactory.createSponsor(sponsorId, teamId, name, address, contactPerson, sponsoringPackage);
        sponsorRepository.save(createdSponsor);
        return createdSponsor;
    }

    public TelephoneNumber createTelephoneNumber(TelephoneAreaCode areaCode, String telephoneNumber) {
        return SponsorFactory.createTelephoneNumber(areaCode, telephoneNumber);
    }
}

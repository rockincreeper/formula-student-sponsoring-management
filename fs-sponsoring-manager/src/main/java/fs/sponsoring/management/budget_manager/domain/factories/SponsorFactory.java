package fs.sponsoring.management.budget_manager.domain.factories;

import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.ContactPerson;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.SponsorAggregate;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.address.Address;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.address.Country;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.address.State;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.sponsoring_package.SponsoringPackage;

import java.util.UUID;

public class SponsorFactory {
    public static SponsorAggregate createSponsor(UUID teamId, String name, Address address, ContactPerson contactPerson) {
        if (name == null || address == null || contactPerson == null || teamId == null) {
            throw new IllegalArgumentException("Details for sponsor must not be null");
        }
        if(name.trim().isEmpty()){
            throw new IllegalArgumentException("Name for sponsor must not be empty");
        }
        return new SponsorAggregate(teamId, name, address, contactPerson);
    }

    public static ContactPerson createContactPerson(String firstName, String lastName, String phoneNumber, String emailAddress) {
        if(firstName == null || lastName == null || phoneNumber == null || emailAddress == null) {
            throw new IllegalArgumentException("Details for contact person must not be null");
        }
        if(firstName.trim().isEmpty()||lastName.trim().isEmpty()||phoneNumber.trim().isEmpty()||emailAddress.trim().isEmpty()) {
            throw new IllegalArgumentException("Details for contact person must not be empty");
        }

        return new ContactPerson(firstName, lastName, phoneNumber, emailAddress);
    }

    public static Address createAddress(Country country, State state, String zipCode, String city, String street, int houseNumber){
        if(country == null || state == null || zipCode == null || city == null || street == null) {
            throw new IllegalArgumentException("Details for address must not be null");
        }
        if(zipCode.trim().isEmpty() || city.trim().isEmpty() || street.trim().isEmpty()){
            throw new IllegalArgumentException("Details for address must not be empty");
        }
        if(houseNumber <= 0){
            throw new IllegalArgumentException("HouseNumber must be greater than zero");
        }
        return new Address(country, state, zipCode, city, street, houseNumber);
    }

    public static SponsoringPackage createSponsoringPackage(double sponsoredBudgetAmount){
        if(sponsoredBudgetAmount <= 0){
            throw new IllegalArgumentException("Budget amount must be greater than zero");
        }
        return new SponsoringPackage(sponsoredBudgetAmount);
    }
}

package fs.sponsoring.management.budget_manager.domain.factories;

import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.ContactPerson;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.SponsorAggregate;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.address.Address;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.address.Country;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.address.State;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.phone_number.TelephoneAreaCode;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.phone_number.TelephoneNumber;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.sponsoring_package.SponsoringPackage;

import java.util.UUID;

public class SponsorFactory {
    public static SponsorAggregate createSponsor(String sponsorId, String teamId, String name, Address address, ContactPerson contactPerson, SponsoringPackage sponsoringPackage) {
        checkDetailsForSponsor(sponsorId, teamId, name, address, contactPerson);
        return new SponsorAggregate(sponsorId, teamId, name, address, contactPerson, sponsoringPackage);
    }

    private static void checkDetailsForSponsor(String sponsorId, String teamId, String name, Address address, ContactPerson contactPerson) {
        if (name == null || address == null || contactPerson == null || teamId == null) {
            throw new IllegalArgumentException("Details for sponsor must not be null");
        }
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name for sponsor must not be empty");
        }
    }

    public static Address createAddress(Country country, State state, String zipCode, String city, String street, int houseNumber) {
        if (country == null || state == null || zipCode == null || city == null || street == null) {
            throw new IllegalArgumentException("Details for address must not be null");
        }
        if (zipCode.trim().isEmpty() || city.trim().isEmpty() || street.trim().isEmpty()) {
            throw new IllegalArgumentException("Details for address must not be empty");
        }
        if (houseNumber <= 0) {
            throw new IllegalArgumentException("HouseNumber must be greater than zero");
        }
        return new Address(country, state, zipCode, city, street, houseNumber);
    }

    public static SponsoringPackage createSponsoringPackage(double sponsoredBudgetAmount) {
        if (sponsoredBudgetAmount < 0) {
            throw new IllegalArgumentException("Budget cannot be negative");
        }
        return new SponsoringPackage(sponsoredBudgetAmount);
    }

    public static ContactPerson createContactPerson(String id, String firstName, String lastName, TelephoneNumber telephoneNumber) {
        if (id == null || firstName == null || lastName == null || telephoneNumber == null) {
            throw new IllegalArgumentException("Details for contact person must not be null");
        }
        if (id.trim().isEmpty() || firstName.trim().isEmpty() || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Details for contact person must not be empty");
        }
        return new ContactPerson(id, firstName, lastName, telephoneNumber);
    }

    public static TelephoneNumber createTelephoneNumber(TelephoneAreaCode areaCode, String telephoneNumber) {
        return new TelephoneNumber(areaCode, telephoneNumber);
    }
}

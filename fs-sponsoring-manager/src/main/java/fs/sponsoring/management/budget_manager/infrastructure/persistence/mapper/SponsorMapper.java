package fs.sponsoring.management.budget_manager.infrastructure.persistence.mapper;

import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.ContactPerson;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.SponsorAggregate;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.address.Address;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.phone_number.TelephoneNumber;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.sponsoring_package.SponsoringPackage;
import fs.sponsoring.management.budget_manager.domain.factories.SponsorFactory;
import fs.sponsoring.management.budget_manager.infrastructure.persistence.dto.sponsor.*;

import java.util.Collections;
import java.util.List;

public class SponsorMapper {
    public static SponsorAggregate toDomain(SponsorDto sponsorDto) {
        ContactPerson contactPerson = toDomain(sponsorDto.contactPerson);
        Address sponsorAddress = toDomain(sponsorDto.address);
        SponsoringPackage sponsoringPackageForSponsor = toDomain(sponsorDto.sponsoringPackage);

        return SponsorFactory.createSponsor(sponsorDto.id, sponsorDto.teamId, sponsorDto.name, sponsorAddress, contactPerson, sponsoringPackageForSponsor);
    }

    private static ContactPerson toDomain(ContactPersonDto contactPersonDto) {
        TelephoneNumber phoneNumber = toDomain(contactPersonDto.phoneNumber);
        return SponsorFactory.createContactPerson(contactPersonDto.id, contactPersonDto.firstName, contactPersonDto.lastName, phoneNumber);
    }

    private static TelephoneNumber toDomain(TelephoneNumberDto telephoneNumberDto) {
        return SponsorFactory.createTelephoneNumber(telephoneNumberDto.areaCode, telephoneNumberDto.number);
    }

    private static Address toDomain(AddressDto sponsorAddressDto) {
        return SponsorFactory.createAddress(sponsorAddressDto.country, sponsorAddressDto.state, sponsorAddressDto.zipCode, sponsorAddressDto.city, sponsorAddressDto.street, sponsorAddressDto.houseNumber);
    }

    private static SponsoringPackage toDomain(SponsoringPackageDto sponsorPackageDto) {
        return SponsorFactory.createSponsoringPackage(sponsorPackageDto.sponsoredBudgetAmount);
    }
}

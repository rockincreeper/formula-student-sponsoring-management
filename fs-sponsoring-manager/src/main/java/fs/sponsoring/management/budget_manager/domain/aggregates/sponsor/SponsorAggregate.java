package fs.sponsoring.management.budget_manager.domain.aggregates.sponsor;

import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.sponsoring_package.SponsoringPackage;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.address.Address;

import java.util.UUID;

public class SponsorAggregate {
    private final UUID id;
    private final UUID teamId;
    private final String name;
    private Address address;
    private ContactPerson contactPerson;
    private SponsoringPackage sponsoringPackage;

    public SponsorAggregate(UUID teamId, String name, Address address, ContactPerson contactPerson) {
        this.id = UUID.randomUUID();
        this.teamId = teamId;
        this.name = name;
        this.address = address;
        this.contactPerson = contactPerson;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ContactPerson getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(ContactPerson contactPerson) {
        this.contactPerson = contactPerson;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public SponsoringPackage getSponsoringPackage() {
        return sponsoringPackage;
    }

    public void updateSponsoringPackage(SponsoringPackage sponsoringPackage) {
        this.sponsoringPackage = sponsoringPackage;
    }

    public UUID getTeamId() {
        return teamId;
    }
}
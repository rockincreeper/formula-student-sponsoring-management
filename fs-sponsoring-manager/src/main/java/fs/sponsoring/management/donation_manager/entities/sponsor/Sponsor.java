package fs.sponsoring.management.donation_manager.entities.sponsor;

import fs.sponsoring.management.donation_manager.value_objects.Address;

import java.util.Objects;
import java.util.UUID;

public class Sponsor {
    private UUID id;
    private String name;
    private String description;
    private Address address;
    private ContactPerson contactPerson;

    public Sponsor(UUID id, String name, String description, Address address, ContactPerson contactPerson) {
        Objects.requireNonNull(id);
        if (name.isEmpty() || address == null || contactPerson == null) {
            throw new IllegalArgumentException("Details for Sponsor must not be null or empty");
        }

        this.id = id;
        this.name = name;
        if (description.isEmpty()) {
            this.description = "No description provided";
        } else {
            this.description = description;
        }
        this.address = address;
        this.contactPerson = contactPerson;
    }

    public UUID getId() {
        return id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
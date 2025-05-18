package fs.sponsoring.management.budget_manager.domain.aggregates.sponsor;

import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.phone_number.TelephoneNumber;

import java.util.UUID;

public class ContactPerson {
    private final String id;
    private final String firstName;
    private final String lastName;
    private TelephoneNumber phoneNumber;

    public ContactPerson(String id, String firstName, String lastName, TelephoneNumber phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public TelephoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(TelephoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

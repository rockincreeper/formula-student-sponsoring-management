package fs.sponsoring.management.budget_manager.domain.aggregates.sponsor;

import java.util.UUID;

public class ContactPerson {
    private final UUID id;
    private final String firstName;
    private final String lastName;
    private String phoneNumber;
    private String emailAddress;

    public ContactPerson(String firstName, String lastName, String phoneNumber, String emailAddress) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public UUID getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

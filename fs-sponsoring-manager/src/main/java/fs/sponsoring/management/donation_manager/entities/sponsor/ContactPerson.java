package fs.sponsoring.management.donation_manager.entities.sponsor;

import java.util.Objects;
import java.util.UUID;

public class ContactPerson {
    private UUID id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    public ContactPerson(UUID id, String firstName, String lastName, String phone, String email) {
        Objects.requireNonNull(id);
        if (firstName == null || lastName == null || phone == null || email == null) {
            throw new IllegalArgumentException("Contact person is not valid");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

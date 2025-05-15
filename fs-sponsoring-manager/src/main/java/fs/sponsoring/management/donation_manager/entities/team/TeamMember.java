package fs.sponsoring.management.donation_manager.entities.team;

import java.util.Objects;
import java.util.UUID;

public class TeamMember {
    private UUID id;
    private String firstName;
    private String lastName;
    private Role teamRole;

    public TeamMember(UUID id, String firstName, String lastName, String teamEmail, String privateEmail, String phoneNumber, Role teamRole) {
        Objects.requireNonNull(id);
        if(firstName == null || lastName == null || teamEmail == null || privateEmail == null || phoneNumber == null){
            throw new NullPointerException("Cannot create a TeamMember with null parameters");
        }
        if (firstName.isBlank() || lastName.isBlank() || teamEmail.isBlank() || privateEmail.isBlank() || phoneNumber.isBlank() ) {
            throw new IllegalArgumentException("Cannot create a TeamMember with empty fields");
        }

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.teamRole = teamRole;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Role getTeamRole() {
        return teamRole;
    }

    public void setTeamRole(Role teamRole) {
        this.teamRole = teamRole;
    }
}

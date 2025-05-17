package fs.sponsoring.management.budget_manager.domain.aggregates.formula_student_team;

import java.util.Objects;
import java.util.UUID;

public class TeamMember {
    private final UUID id;
    private final String firstName;
    private final String lastName;
    private TeamRole teamRole;


    public TeamMember(UUID id, String firstName, String lastName, String teamEmail, String privateEmail, String phoneNumber, TeamRole teamRole) {
        Objects.requireNonNull(id);
        if (firstName == null || lastName == null || teamEmail == null || privateEmail == null || phoneNumber == null) {
            throw new NullPointerException("Cannot create a TeamMember with null parameters");
        }
        if (firstName.isBlank() || lastName.isBlank() || teamEmail.isBlank() || privateEmail.isBlank() || phoneNumber.isBlank()) {
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

    public String getLastName() {
        return lastName;
    }

    public TeamRole getTeamRole() {
        return teamRole;
    }

    public void setTeamRole(TeamRole teamRole) {
        this.teamRole = teamRole;
    }

    public UUID getId() {
        return id;
    }
}

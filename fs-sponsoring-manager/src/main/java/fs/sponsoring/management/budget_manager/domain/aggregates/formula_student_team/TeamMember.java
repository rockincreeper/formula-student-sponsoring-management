package fs.sponsoring.management.budget_manager.domain.aggregates.formula_student_team;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.UUID;

public class TeamMember {
    private final String id;
    private final String firstName;
    private final String lastName;
    private TeamRole teamRole;

    public TeamMember(String id, String firstName, String lastName, TeamRole teamRole) {
        Objects.requireNonNull(id);
        if (firstName == null || lastName == null) {
            throw new NullPointerException("Cannot create a TeamMember with null parameters");
        }
        if (firstName.isBlank() || lastName.isBlank()) {
            throw new IllegalArgumentException("Cannot create a TeamMember with empty fields");
        }

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.teamRole = teamRole;
    }

    public TeamMember(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public String getId() {
        return id;
    }
}

package fs.sponsoring.management.budget_manager.infrastructure.persistence.dto.formula_student_team;

import fs.sponsoring.management.budget_manager.domain.aggregates.formula_student_team.TeamRole;

public class TeamMemberDto {
    public String id;
    public String firstName;
    public String lastName;
    public TeamRole teamRole;
}

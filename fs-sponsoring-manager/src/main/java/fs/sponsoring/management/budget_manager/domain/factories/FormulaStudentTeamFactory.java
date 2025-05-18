package fs.sponsoring.management.budget_manager.domain.factories;

import fs.sponsoring.management.budget_manager.domain.aggregates.formula_student_team.FormulaStudentTeamAggregate;
import fs.sponsoring.management.budget_manager.domain.aggregates.formula_student_team.TeamMember;
import fs.sponsoring.management.budget_manager.domain.aggregates.formula_student_team.TeamRole;

import java.util.List;
import java.util.UUID;


public class FormulaStudentTeamFactory {

    public static FormulaStudentTeamAggregate createFormulaStudentTeam(String teamId, String teamName, List<TeamMember> teamMembers, double totalFinancialBudget) {
        if (teamName.trim().isEmpty()) {
            throw new IllegalArgumentException("Team name cannot be empty");
        }
        if (totalFinancialBudget < 0) {
            throw new IllegalArgumentException("Total financial budget cannot be negative");
        }
        if (teamMembers == null || teamMembers.isEmpty()) {
            throw new IllegalArgumentException("Team members cannot be empty");
        }
        UUID id = UUID.randomUUID();
        return new FormulaStudentTeamAggregate(id.toString(), teamName, teamMembers, totalFinancialBudget);
    }

    public static TeamMember createTeamMember(String memberId, String firstName, String lastName, TeamRole teamRole) {
        return new TeamMember(memberId, firstName, lastName, teamRole);
    }
}

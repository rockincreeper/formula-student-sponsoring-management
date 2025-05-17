package fs.sponsoring.management.budget_manager.domain.factories;

import fs.sponsoring.management.budget_manager.domain.aggregates.formula_student_team.FormulaStudentTeamAggregate;
import fs.sponsoring.management.budget_manager.domain.aggregates.formula_student_team.TeamMember;

import java.util.List;


public class FormulaStudentTeamFactory {
    public static FormulaStudentTeamAggregate createFormulaStudentTeam(String teamName, List<TeamMember> teamMembers, double totalFinancialBudget) {
        if (teamName.trim().isEmpty()) {
            throw new IllegalArgumentException("Team name cannot be empty");
        }
        if(totalFinancialBudget <= 0) {
            throw new IllegalArgumentException("Total financial budget cannot be negative");
        }
        if(teamMembers == null || teamMembers.isEmpty()) {
            throw new IllegalArgumentException("Team members cannot be empty");
        }
        return new FormulaStudentTeamAggregate(teamName, teamMembers, totalFinancialBudget);
    }
}

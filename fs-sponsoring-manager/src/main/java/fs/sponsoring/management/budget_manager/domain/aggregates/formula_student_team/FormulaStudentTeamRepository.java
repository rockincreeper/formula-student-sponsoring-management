package fs.sponsoring.management.budget_manager.domain.aggregates.formula_student_team;

import java.util.List;

public interface FormulaStudentTeamRepository {
    String getTeamName();

    String getTeamId();

    List<TeamMember> findAllTeamMembers();

    double addBudget(double budget);

    double getTotalFinancialBudget();

    TeamMember findTeamMemberById(String teamMemberId);

    FormulaStudentTeamAggregate save(FormulaStudentTeamAggregate aggregate);
}

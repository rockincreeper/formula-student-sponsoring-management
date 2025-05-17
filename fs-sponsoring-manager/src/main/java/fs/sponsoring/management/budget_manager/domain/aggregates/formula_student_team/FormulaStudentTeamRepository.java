package fs.sponsoring.management.budget_manager.domain.aggregates.formula_student_team;

import java.util.List;

public interface FormulaStudentTeamRepository {
    String getTeamName();

    List<TeamMember> findAllTeamMember();

    double getTotalFinancialBudget();

    TeamMember findTeamMemberById(String teamMemberId);

    FormulaStudentTeamAggregate save(FormulaStudentTeamAggregate aggregate);
}

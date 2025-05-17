package fs.sponsoring.management.budget_manager.infrastructure.persistence.team;

import fs.sponsoring.management.budget_manager.domain.aggregates.formula_student_team.FormulaStudentTeamAggregate;
import fs.sponsoring.management.budget_manager.domain.aggregates.formula_student_team.FormulaStudentTeamRepository;
import fs.sponsoring.management.budget_manager.domain.aggregates.formula_student_team.TeamMember;
import fs.sponsoring.management.budget_manager.domain.aggregates.formula_student_team.TeamRole;

import java.util.List;

public class InMemoryFormulaStudentTeamRepository implements FormulaStudentTeamRepository {
    private String id;
    private TeamRole teamRole;

    @Override
    public String getTeamName() {
        return "";
    }

    @Override
    public List<TeamMember> findAllTeamMember() {
        return List.of();
    }

    @Override
    public double getTotalFinancialBudget() {
        return 0;
    }

    @Override
    public TeamMember findTeamMemberById(String teamMemberId) {
        return null;
    }

    @Override
    public FormulaStudentTeamAggregate save(FormulaStudentTeamAggregate aggregate) {
        return null;
    }
}

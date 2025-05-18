package fs.sponsoring.management.budget_manager.infrastructure.persistence.dto.formula_student_team;

import java.util.List;

public class FormulaStudentTeamDto {
    public String id;
    public String teamName;
    public List<TeamMemberDto> teamMembers;
    public double totalFinancialBudget;
}

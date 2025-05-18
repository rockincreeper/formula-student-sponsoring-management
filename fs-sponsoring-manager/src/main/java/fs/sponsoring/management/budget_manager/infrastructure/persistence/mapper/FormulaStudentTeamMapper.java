package fs.sponsoring.management.budget_manager.infrastructure.persistence.mapper;

import fs.sponsoring.management.budget_manager.domain.aggregates.formula_student_team.FormulaStudentTeamAggregate;
import fs.sponsoring.management.budget_manager.domain.aggregates.formula_student_team.TeamMember;
import fs.sponsoring.management.budget_manager.domain.factories.FormulaStudentTeamFactory;
import fs.sponsoring.management.budget_manager.infrastructure.persistence.dto.formula_student_team.FormulaStudentTeamDto;
import fs.sponsoring.management.budget_manager.infrastructure.persistence.dto.formula_student_team.TeamMemberDto;

import java.util.List;
import java.util.stream.Collectors;

public class FormulaStudentTeamMapper {
    public static FormulaStudentTeamAggregate toDomain(FormulaStudentTeamDto formulaStudentTeamDto) {
        List<TeamMember> teamMembers = formulaStudentTeamDto.teamMembers.stream().map(FormulaStudentTeamMapper::toDomain).collect(Collectors.toList());

        return FormulaStudentTeamFactory.createFormulaStudentTeam(formulaStudentTeamDto.id, formulaStudentTeamDto.teamName, teamMembers, formulaStudentTeamDto.totalFinancialBudget);
    }

    private static TeamMember toDomain(TeamMemberDto teamMemberDto) {
        return FormulaStudentTeamFactory.createTeamMember(teamMemberDto.id, teamMemberDto.firstName, teamMemberDto.lastName, teamMemberDto.teamRole);
    }
}

package fs.sponsoring.management.budget_manager.infrastructure.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import fs.sponsoring.management.budget_manager.domain.aggregates.formula_student_team.FormulaStudentTeamAggregate;
import fs.sponsoring.management.budget_manager.domain.aggregates.formula_student_team.FormulaStudentTeamRepository;
import fs.sponsoring.management.budget_manager.domain.aggregates.formula_student_team.TeamMember;
import fs.sponsoring.management.budget_manager.infrastructure.persistence.dto.formula_student_team.FormulaStudentTeamDto;
import fs.sponsoring.management.budget_manager.infrastructure.persistence.mapper.FormulaStudentTeamMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InMemoryFormulaStudentTeamRepository implements FormulaStudentTeamRepository {
    private final String pathToFormulaStudentTeamFile = "src/main/resources/fs-team.json";
    private final ObjectMapper mapperForFormulaStudentTeam = new ObjectMapper();


    private final Map<String, TeamMember> teamMemberStorage = new HashMap<>();
    private FormulaStudentTeamAggregate formulaStudentTeamStorage;

    public InMemoryFormulaStudentTeamRepository() {
        loadFormulaStudentTeamFromJson();
    }

    private void loadFormulaStudentTeamFromJson() {
        try {
            FormulaStudentTeamDto formulaStudentTeamDto = mapperForFormulaStudentTeam.readValue(new File(pathToFormulaStudentTeamFile), FormulaStudentTeamDto.class);
            this.formulaStudentTeamStorage = FormulaStudentTeamMapper.toDomain(formulaStudentTeamDto);
            for (TeamMember teamMember : formulaStudentTeamStorage.getTeamMembers()) {
                teamMemberStorage.put(teamMember.getId(), teamMember);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load formula student team", e);
        }
    }

    @Override
    public String getTeamName() {
        return this.formulaStudentTeamStorage.getTeamName();
    }

    @Override
    public String getTeamId() {
        return this.formulaStudentTeamStorage.getId();
    }

    @Override
    public List<TeamMember> findAllTeamMembers() {
        return this.formulaStudentTeamStorage.getTeamMembers();
    }

    @Override
    public double getTotalFinancialBudget() {
        return this.formulaStudentTeamStorage.getTotalFinancialBudget();
    }

    @Override
    public double addBudget(double budget){
        this.formulaStudentTeamStorage.addToTotalFinancialBudget(budget);
        return this.formulaStudentTeamStorage.getTotalFinancialBudget();
    }

    @Override
    public TeamMember findTeamMemberById(String teamMemberId) {
        return this.teamMemberStorage.get(teamMemberId);
    }

    @Override
    public FormulaStudentTeamAggregate save(FormulaStudentTeamAggregate aggregate) {
        return null;
    }
}

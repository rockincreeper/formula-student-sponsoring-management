package fs.sponsoring.management.budget_manager.domain.aggregates.formula_student_team;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class FormulaStudentTeamAggregate {
    private final String id;
    private final String teamName;
    private List<TeamMember> teamMembers;
    private double totalFinancialBudget;

    public FormulaStudentTeamAggregate(String id, String teamName, List<TeamMember> teamMembers, double totalFinancialBudget) {
        this.id = id;
        this.teamName = Objects.requireNonNull(teamName);
        this.totalFinancialBudget = totalFinancialBudget;
        this.teamMembers = new ArrayList<>(teamMembers);
    }

    public String getId() {
        return id;
    }

    public List<TeamMember> getTeamMembers() {
        return teamMembers;
    }

    public void addTeamMember(TeamMember teamMember) {
        this.teamMembers.add(teamMember);
    }

    public String getTeamName() {
        return teamName;
    }

    public double getTotalFinancialBudget() {
        return totalFinancialBudget;
    }

    public void addToTotalFinancialBudget(double totalFinancialBudget) {
        this.totalFinancialBudget = totalFinancialBudget;
    }
}

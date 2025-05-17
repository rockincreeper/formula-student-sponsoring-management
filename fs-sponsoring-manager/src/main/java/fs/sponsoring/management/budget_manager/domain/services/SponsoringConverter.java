package fs.sponsoring.management.budget_manager.domain.services;

import fs.sponsoring.management.budget_manager.domain.aggregates.formula_student_team.TeamMember;
import fs.sponsoring.management.budget_manager.domain.aggregates.formula_student_team.TeamRole;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsoring.SponsoringAggregate;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsoring.SponsoringType;
import fs.sponsoring.management.budget_manager.exceptions.WrongSponsoringTypeException;

public class SponsoringConverter {
    public static void convertToBudgetSponsoring(TeamMember associatedTeamMember, SponsoringAggregate sponsoringToBeConverted) {
        if (associatedTeamMember.getTeamRole() != TeamRole.TEAM_CAPTAIN) {
            throw new UnsupportedOperationException("The team member is unauthorized to perform this operation");
        }
        if (sponsoringToBeConverted.getSponsoringType() != SponsoringType.SPONSORING_REQUEST){
            throw new WrongSponsoringTypeException("The sponsoring has the wrong type for conversion");
        }
        sponsoringToBeConverted.setSponsoringType(SponsoringType.BUDGET_SPONSORING);
    }
}

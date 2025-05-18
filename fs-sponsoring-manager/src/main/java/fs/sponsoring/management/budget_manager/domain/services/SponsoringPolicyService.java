package fs.sponsoring.management.budget_manager.domain.services;

import fs.sponsoring.management.budget_manager.domain.aggregates.formula_student_team.TeamMember;
import fs.sponsoring.management.budget_manager.domain.aggregates.formula_student_team.TeamRole;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsoring.SponsoringAggregate;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsoring.SponsoringType;

public class SponsoringPolicyService {
    public static boolean isUpgradeable(TeamMember associatedTeamMember, SponsoringAggregate sponsoringToBeConverted) {
        return SponsoringPolicyService.isAuthorized(associatedTeamMember) && SponsoringPolicyService.hasCorrectSponsoringType(sponsoringToBeConverted);
    }

    private static boolean isAuthorized(TeamMember associatedTeamMember) {
        return associatedTeamMember.getTeamRole() == TeamRole.TEAM_CAPTAIN;
    }

    private static boolean hasCorrectSponsoringType(SponsoringAggregate sponsoringToBeConverted) {
        return sponsoringToBeConverted.getSponsoringType() == SponsoringType.SPONSORING_REQUEST;
    }
}

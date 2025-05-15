package fs.sponsoring.management.donation_manager.entities;

import fs.sponsoring.management.donation_manager.entities.sponsor.Sponsor;
import fs.sponsoring.management.donation_manager.entities.team.Role;
import fs.sponsoring.management.donation_manager.entities.team.TeamMember;
import fs.sponsoring.management.donation_manager.exceptions.UnauthorizedRoleException;

import java.sql.Date;
import java.util.Objects;

public final class Sponsoring {
    private final String sponsoringTitle;

    private final Sponsor sponsor;
    private final TeamMember teamCaptain;
    private final Date creationDate;
    private final double budgetFromSponsor;

    public Sponsoring(String formulaStudentName, Sponsor sponsor, double budgetFromSponsor, TeamMember teamCaptain, Date creationDate) {
        if (!(isTeamCaptain(teamCaptain))) {
            throw new UnauthorizedRoleException("The sponsoring creator has no permission to be associated with this contract");
        }

        if(budgetFromSponsor <= 0) {
            throw new IllegalArgumentException("The budget fromSponsor must be greater than zero");
        }

        if(formulaStudentName == null || formulaStudentName.isEmpty()) {
            throw new IllegalArgumentException("The name of the associated Formula Student Team must not be null or empty");
        }

        this.sponsor = Objects.requireNonNull(sponsor);
        this.teamCaptain = Objects.requireNonNull(teamCaptain);
        this.creationDate = Objects.requireNonNull(creationDate);
        this.budgetFromSponsor = budgetFromSponsor;

        this.sponsoringTitle = "Contract between \"" + formulaStudentName + "\" and " + sponsor.getName() + " from " + creationDate;
    }

    private boolean isTeamCaptain(TeamMember teamCaptain) {
        return teamCaptain.getTeamRole() == Role.TEAM_CAPTAIN;
    }

    public Sponsor getSponsor() {
        return sponsor;
    }

    public double getBudgetFromSponsor() {
        return budgetFromSponsor;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getSponsoringTitle() {
        return sponsoringTitle;
    }

    public TeamMember getTeamCaptain() {
        return teamCaptain;
    }
}

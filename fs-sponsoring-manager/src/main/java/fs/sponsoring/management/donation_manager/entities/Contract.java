package fs.sponsoring.management.donation_manager.entities;

import fs.sponsoring.management.donation_manager.entities.sponsor.Sponsor;
import fs.sponsoring.management.donation_manager.entities.team.Role;
import fs.sponsoring.management.donation_manager.entities.team.TeamMember;
import fs.sponsoring.management.donation_manager.exceptions.UnauthorizedRoleException;
import fs.sponsoring.management.donation_manager.value_objects.team.SponsoringLevel;
import org.jetbrains.annotations.NotNull;

import java.sql.Date;
import java.util.Objects;
import java.util.UUID;

public class Contract {
    private UUID id;
    private String contractTitle;
    private Sponsor sponsor;
    private SponsoringLevel sponsoringLevel;
    private double budgetFromSponsor;
    private TeamMember contractCreator;
    private Date creationDate;

    public Contract(UUID id, String contractTitle, Sponsor sponsor, double budgetFromSponsor, TeamMember contractCreator, Date creationDate) {
        Objects.requireNonNull(id);
        if (contractTitle == null || sponsor == null || contractCreator == null || creationDate == null) {
            throw new NullPointerException("Cannot create a contract with null parameters");
        }

        if (contractTitle.isBlank() || budgetFromSponsor < 0 ) {
            throw new IllegalArgumentException("Invalid details for the contract");
        }

        if(!(isTeamCaptain(contractCreator))) {
            throw new UnauthorizedRoleException("The contract creator has no permission to be associated with this contract");
        }
    }

    private boolean isTeamCaptain(TeamMember teamCaptain) {
        return teamCaptain.getTeamRole() == Role.TEAM_CAPTAIN;
    }

    public double getBudgetFromSponsor() {
        return budgetFromSponsor;
    }

    public void setBudgetFromSponsor(double budgetFromSponsor) {
        this.budgetFromSponsor = budgetFromSponsor;
    }

    public TeamMember getContractCreator() {
        return contractCreator;
    }

    public void setContractCreator(TeamMember contractCreator) {
        this.contractCreator = contractCreator;
    }

    public String getContractTitle() {
        return contractTitle;
    }

    public void setContractTitle(String contractTitle) {
        this.contractTitle = contractTitle;
    }

    public Sponsor getSponsor() {
        return sponsor;
    }

    public void setSponsor(Sponsor sponsor) {
        this.sponsor = sponsor;
    }

    public SponsoringLevel getSponsoringLevel() {
        return sponsoringLevel;
    }

    public void setSponsoringLevel(SponsoringLevel sponsoringLevel) {
        this.sponsoringLevel = sponsoringLevel;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}

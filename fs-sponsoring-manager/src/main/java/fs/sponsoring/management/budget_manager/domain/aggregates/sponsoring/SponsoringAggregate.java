package fs.sponsoring.management.budget_manager.domain.aggregates.sponsoring;

import fs.sponsoring.management.budget_manager.exceptions.WrongSponsoringTypeException;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public final class SponsoringAggregate {
    private final String id;
    private final String teamId;
    private final String sponsorId;
    private final LocalDate creationDate;
    private SponsoringType sponsoringType;
    private double budgetForSponsoring;

    public SponsoringAggregate(String sponsoringId, String teamId, String sponsorId, double budgetForSponsoring) {
        this.id = sponsoringId;
        this.teamId = Objects.requireNonNull(teamId);
        this.sponsorId = Objects.requireNonNull(sponsorId);
        this.creationDate = LocalDate.now();
        this.budgetForSponsoring = budgetForSponsoring;
        this.sponsoringType = SponsoringType.SPONSORING_REQUEST;
    }

    public double getBudgetForSponsoring() {
        return budgetForSponsoring;
    }

    public void updateBudgetForSponsoring(double budgetForSponsoring) {
        if (budgetForSponsoring <= 0) {
            throw new IllegalArgumentException("The budget for sponsoring must be greater than zero");
        }
        if (this.sponsoringType == SponsoringType.SPONSORING_REQUEST) {
            this.budgetForSponsoring = budgetForSponsoring;
        }else{
            throw new WrongSponsoringTypeException("Cannot update the budget for official sponsoring");
        }
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public String getId() {
        return id;
    }

    public String getSponsorId() {
        return sponsorId;
    }

    public SponsoringType getSponsoringType() {
        return sponsoringType;
    }

    public void setSponsoringType(SponsoringType sponsoringType) {
        this.sponsoringType = sponsoringType;
    }

    public String getTeamId() {
        return teamId;
    }
}

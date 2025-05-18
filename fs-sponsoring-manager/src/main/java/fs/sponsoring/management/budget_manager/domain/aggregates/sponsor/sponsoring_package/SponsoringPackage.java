package fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.sponsoring_package;

public final class SponsoringPackage {
    private final double sponsoredBudgetAmount;
    private final SponsoringBadge earnedSponsoringBadge;

    public SponsoringPackage(double sponsoredBudgetAmount) {
        if (sponsoredBudgetAmount < 0) {
            throw new IllegalArgumentException("Sponsored budget amount cannot be negative");
        }
        this.sponsoredBudgetAmount = sponsoredBudgetAmount;
        this.earnedSponsoringBadge = selectSponsoringBadge(sponsoredBudgetAmount);
    }

    private SponsoringBadge selectSponsoringBadge(double sponsoredBudgetAmount) {
        if (sponsoredBudgetAmount > 1000) {
            return SponsoringBadge.SPONSOR;
        } else if (sponsoredBudgetAmount < 0) {
            return SponsoringBadge.SUPPORTER;
        } else {
            return SponsoringBadge.NONE;
        }
    }

    public SponsoringBadge getEarnedSponsoringBadge() {
        return earnedSponsoringBadge;
    }

    public SponsoringPackage addBudgetAmount(double budgetAmount) {
        return new SponsoringPackage(this.sponsoredBudgetAmount + budgetAmount);
    }

    public double getSponsoredBudgetAmount() {
        return sponsoredBudgetAmount;
    }
}

package fs.sponsoring.management.donation_manager.value_objects.sponsor;

public final class SponsorPackage {
    private final double sponsoredBudgetAmount;
    private final SponsoringBadge earnedSponsoringBadge;

    public SponsorPackage(double sponsoredBudgetAmount) {
        if (sponsoredBudgetAmount < 0) {
            throw new IllegalArgumentException("Sponsored budget amount cannot be negative");
        }
        this.sponsoredBudgetAmount = sponsoredBudgetAmount;
        this.earnedSponsoringBadge = selectSponsoringBadge(sponsoredBudgetAmount);
    }

    private SponsoringBadge selectSponsoringBadge(double sponsoredBudgetAmount) {
        return sponsoredBudgetAmount > 1000 ? SponsoringBadge.SPONSOR : SponsoringBadge.SUPPORTER;
    }

    public SponsoringBadge getEarnedSponsoringBadge() {
        return earnedSponsoringBadge;
    }

    public SponsorPackage addBudgetAmount(double budgetAmount) {
        return new SponsorPackage(this.sponsoredBudgetAmount + budgetAmount);
    }

    public double getSponsoredBudgetAmount() {
        return sponsoredBudgetAmount;
    }
}

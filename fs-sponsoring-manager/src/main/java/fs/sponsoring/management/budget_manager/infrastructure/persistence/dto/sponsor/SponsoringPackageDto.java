package fs.sponsoring.management.budget_manager.infrastructure.persistence.dto.sponsor;

import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.sponsoring_package.SponsoringBadge;

public class SponsoringPackageDto {
    public double sponsoredBudgetAmount;
    public SponsoringBadge earnedSponsoringBadge;
}

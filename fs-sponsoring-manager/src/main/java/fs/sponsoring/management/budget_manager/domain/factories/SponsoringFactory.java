package fs.sponsoring.management.budget_manager.domain.factories;

import fs.sponsoring.management.budget_manager.domain.aggregates.sponsoring.SponsoringAggregate;

import java.util.UUID;

public class SponsoringFactory {
    public static SponsoringAggregate createSponsoringAggregate(String sponsoringId, String teamId, String sponsorId, double budgetForSponsoring) {
        if(budgetForSponsoring <= 0){
            throw new IllegalArgumentException("The budget for sponsoring is invalid");
        }
        return new SponsoringAggregate(sponsoringId, teamId, sponsorId, budgetForSponsoring);
    }
}

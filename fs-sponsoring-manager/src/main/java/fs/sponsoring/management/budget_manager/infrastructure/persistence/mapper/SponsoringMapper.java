package fs.sponsoring.management.budget_manager.infrastructure.persistence.mapper;

import fs.sponsoring.management.budget_manager.domain.aggregates.sponsoring.SponsoringAggregate;
import fs.sponsoring.management.budget_manager.domain.factories.SponsoringFactory;
import fs.sponsoring.management.budget_manager.infrastructure.persistence.dto.sponsoring.SponsoringDto;

public class SponsoringMapper {
    public static SponsoringAggregate toDomain(SponsoringDto sponsoringDto) {
        return SponsoringFactory.createSponsoringAggregate(sponsoringDto.sponsorId, sponsoringDto.teamId, sponsoringDto.sponsorId, sponsoringDto.budgetForSponsoring);
    }
}

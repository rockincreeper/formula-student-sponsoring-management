package fs.sponsoring.management.budget_manager.domain.aggregates.sponsor;

import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.sponsoring_package.SponsoringPackage;

import java.util.List;

public interface SponsorRepository {
    List<SponsorAggregate> findAll();

    SponsorAggregate getSponsorById(String id);

    ContactPerson getContactPersonBySponsorId(String id);

    SponsoringPackage getSponsoringPackageBySponsorId(String id);

    SponsorAggregate save(SponsorAggregate sponsorAggregate);
}

package fs.sponsoring.management.budget_manager.domain.aggregates.sponsoring;

import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.sponsoring_package.SponsoringPackage;

import java.util.List;

public interface SponsoringRepository {
    List<SponsoringAggregate> findAllSponsoringsOfTeam();

    List<SponsoringAggregate> findAllSponsoringsForSponsor(String sponsorId);

    SponsoringPackage findForSponsorById(String sponsorId);

    void save(SponsoringAggregate sponsoringAggregate);
}

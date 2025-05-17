package fs.sponsoring.management.budget_manager.domain.aggregates.sponsoring;

import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.sponsoring_package.SponsoringPackage;

import java.util.List;

public interface SponsoringRepository {
    List<SponsoringAggregate> findAllSponsoringsForFormulaStudentTeam(String teamId);

    List<SponsoringAggregate> findAllSponsoringsForSponsor(String sponsorId);

    SponsoringPackage findForSponsorById(String sponsorId);

    SponsoringAggregate save(SponsoringAggregate sponsoringAggregate);
}

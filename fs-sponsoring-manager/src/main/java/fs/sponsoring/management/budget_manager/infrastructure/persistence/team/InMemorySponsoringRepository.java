package fs.sponsoring.management.budget_manager.infrastructure.persistence.team;

import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.sponsoring_package.SponsoringPackage;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsoring.SponsoringAggregate;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsoring.SponsoringRepository;

import java.util.List;

public class InMemorySponsoringRepository implements SponsoringRepository {


    @Override
    public List<SponsoringAggregate> findAllSponsoringsForFormulaStudentTeam(String teamId) {
        return List.of();
    }

    @Override
    public List<SponsoringAggregate> findAllSponsoringsForSponsor(String sponsorId) {
        return List.of();
    }

    @Override
    public SponsoringPackage findForSponsorById(String sponsorId) {
        return null;
    }

    @Override
    public SponsoringAggregate save(SponsoringAggregate sponsoringAggregate) {
        return null;
    }
}

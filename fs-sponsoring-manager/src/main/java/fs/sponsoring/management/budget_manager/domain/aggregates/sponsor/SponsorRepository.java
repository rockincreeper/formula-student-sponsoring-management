package fs.sponsoring.management.budget_manager.domain.aggregates.sponsor;

import java.util.List;

public interface SponsorRepository {
    List<SponsorAggregate> getAllSponsorsForFormulaStudentTeam(String teamId);

    SponsorAggregate getSponsorById(String id);

    ContactPerson getContactPersonForSponsorById(String id);

    SponsorAggregate save(SponsorAggregate sponsorAggregate);
}

package fs.sponsoring.management.budget_manager.application.services;

import fs.sponsoring.management.budget_manager.domain.aggregates.formula_student_team.TeamMember;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.SponsorAggregate;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsoring.SponsoringAggregate;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsoring.SponsoringRepository;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsoring.SponsoringType;
import fs.sponsoring.management.budget_manager.domain.factories.SponsoringFactory;
import fs.sponsoring.management.budget_manager.domain.services.SponsoringPolicyService;
import fs.sponsoring.management.budget_manager.infrastructure.persistence.InMemoryFormulaStudentTeamRepository;
import fs.sponsoring.management.budget_manager.infrastructure.persistence.InMemorySponsorRepository;
import fs.sponsoring.management.budget_manager.infrastructure.persistence.InMemorySponsoringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SponsoringService {
    private final InMemoryFormulaStudentTeamRepository formulaStudentTeamRepository;
    private final InMemorySponsoringRepository sponsoringRepository;

    public SponsoringService(InMemoryFormulaStudentTeamRepository formulaStudentTeamRepository, InMemorySponsoringRepository sponsoringRepository, InMemorySponsorRepository sponsorRepository) {
        this.formulaStudentTeamRepository = formulaStudentTeamRepository;
        this.sponsoringRepository = sponsoringRepository;
    }

    public SponsoringAggregate createSponsoringRequest(SponsorAggregate associatedSponsor, double budgetForSponsoring) {
        String sponsoringId = UUID.randomUUID().toString();
        String teamId = this.formulaStudentTeamRepository.getTeamId();
        String associatedSponsorId = associatedSponsor.getId();
        SponsoringAggregate createdSponsoring = SponsoringFactory.createSponsoringAggregate(sponsoringId, teamId, associatedSponsorId, budgetForSponsoring);
        this.sponsoringRepository.save(createdSponsoring);
        return createdSponsoring;
    }

    public void convertToBudgetSponsoring(TeamMember associatedTeamMember, SponsoringAggregate associatedSponsoring) {
        if (SponsoringPolicyService.isUpgradeable(associatedTeamMember, associatedSponsoring)) {
            associatedSponsoring.setSponsoringType(SponsoringType.BUDGET_SPONSORING);
        }
        formulaStudentTeamRepository.addBudget(associatedSponsoring.getBudgetForSponsoring());
        sponsoringRepository.save(associatedSponsoring);
    }
}

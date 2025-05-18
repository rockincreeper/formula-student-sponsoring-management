package fs.sponsoring.management.budget_manager.infrastructure.persistence.dto.sponsoring;

import fs.sponsoring.management.budget_manager.domain.aggregates.sponsoring.SponsoringType;

import java.time.LocalDate;

public class SponsoringDto {
    public String id;
    public String teamId;
    public String sponsorId;
    public LocalDate creationDate;
    public SponsoringType sponsoringType;
    public double budgetForSponsoring;
}

package fs.sponsoring.management.budget_manager.infrastructure.persistence.dto.sponsor;

import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.ContactPerson;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.address.Address;

public class SponsorDto {
    public String id;
    public String teamId;
    public String name;
    public AddressDto address;
    public ContactPersonDto contactPerson;
    public SponsoringPackageDto sponsoringPackage;
}

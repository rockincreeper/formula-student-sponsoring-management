package fs.sponsoring.management.budget_manager.infrastructure.persistence.dto.sponsor;

import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.address.Country;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.address.State;

public class AddressDto {
    public Country country;
    public State state;
    public String zipCode;
    public String city;
    public String street;
    public int houseNumber;
}

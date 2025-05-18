package fs.sponsoring.management.budget_manager.infrastructure.persistence.dto.sponsor;

import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.phone_number.TelephoneNumber;

public class ContactPersonDto {
    public String id;
    public String firstName;
    public String lastName;
    public TelephoneNumberDto phoneNumber;
}

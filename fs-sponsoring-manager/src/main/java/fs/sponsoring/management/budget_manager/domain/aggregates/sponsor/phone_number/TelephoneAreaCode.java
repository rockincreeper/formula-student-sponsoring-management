package fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.phone_number;

public enum TelephoneAreaCode {
    GERMANY("+49");

    public final String telephoneAreaCode;

    private TelephoneAreaCode(String telephoneAreaCode) {
        this.telephoneAreaCode = telephoneAreaCode;
    }
}

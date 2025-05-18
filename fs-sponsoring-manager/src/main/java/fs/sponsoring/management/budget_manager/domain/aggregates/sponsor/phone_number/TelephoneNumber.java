package fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.phone_number;

public final class TelephoneNumber {
    private final TelephoneAreaCode areaCode;
    private final String number;

    public TelephoneNumber(TelephoneAreaCode areaCode, String number) {
        this.areaCode = areaCode;
        this.number = number;
    }

    public TelephoneNumber setTelephoneAreaCode(TelephoneAreaCode areaCode) {
        return new TelephoneNumber(areaCode, number);
    }

    public TelephoneAreaCode getAreaCode() {
        return areaCode;
    }

    public TelephoneNumber setNumber(String number) {
        return new TelephoneNumber(areaCode, number);
    }

    public String getNumber() {
        return number;
    }
}

package fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.address;

import java.util.Objects;

public final class Address {
    private final Country country;
    private final State state;
    private final String zipCode;
    private final String city;
    private final String street;
    private final int houseNumber;

    public Address(Country country, State state, String zipCode, String city, String street, int houseNumber) {
        this.country = country;
        this.state = state;
        this.zipCode = zipCode;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    public String getCity() {
        return city;
    }

    public Country getCountry() {
        return country;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public State getState() {
        return state;
    }

    public String getStreet() {
        return street;
    }

    public String getZipCode() {
        return zipCode;
    }
}

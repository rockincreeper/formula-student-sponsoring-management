package fs.sponsoring.management.donation_manager.value_objects;

import java.util.Objects;

public final class Address {
    private final Country country;
    private final State state;
    private final String zipCode;
    private final String city;
    private final String street;
    private final int houseNumber;

    public Address(Country country, State state, String zipCode, String city, String street, int houseNumber) {
        this.country = Objects.requireNonNull(country, "Country cannot be null");
        this.state = Objects.requireNonNull(state, "State cannot be null");
        if (zipCode == null || zipCode.trim().isEmpty() || zipCode.length() != 5) {
            throw new IllegalArgumentException("Zip code is not valid in Germany");
        }
        this.zipCode = zipCode;
        if (city == null || city.trim().isEmpty()) {
            throw new IllegalArgumentException("City cannot be null");
        }
        this.city = city;
        if (street == null || street.trim().isEmpty()) {
            throw new IllegalArgumentException("Street cannot be null");
        }
        this.street = street;
        if (houseNumber < 1) {
            throw new IllegalArgumentException("House number cannot be less than 1");
        }
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

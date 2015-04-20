package home.model;

/**
 *
 * Country information extracted from REST API.
 * Just global information about country
 *  */
public class Country {

    private String type;

    private String country;

    private Long locationId;

    private boolean inEurope;

    private String countryCode;

    private boolean coreCountry;


    public Country() {
    }

    public Country(String type, String country, Long locationId,
                   boolean inEurope, String countryCode, boolean coreCountry) {
        this.type = type;
        this.country = country;
        this.locationId = locationId;
        this.inEurope = inEurope;
        this.countryCode = countryCode;
        this.coreCountry = coreCountry;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public boolean isInEurope() {
        return inEurope;
    }

    public void setInEurope(boolean inEurope) {
        this.inEurope = inEurope;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public boolean isCoreCountry() {
        return coreCountry;
    }

    public void setCoreCountry(boolean coreCountry) {
        this.coreCountry = coreCountry;
    }

    @Override
    public String toString() {
        return
                "type='" + type + '\'' +
                ", country='" + country + '\'' +
                ", locationId=" + locationId +
                ", inEurope=" + inEurope +
                ", countryCode='" + countryCode + '\'' +
                ", coreCountry=" + coreCountry ;
    }
}

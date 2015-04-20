package home.model;

/**
 *
 * City information extracted from REST API.
 *
 *  */
public class City {

    private String _type;

    private Long _id;

    private String key;

    private String name;

    private String fullName;

    private String iata_airport_code;

    private Country country;

    private GeoPositionKey geoPositionKey;

    private Double distance;



    public City() {
    }


    public City(String _type, Long _id, String key, String name,
                String fullName, String iata_airport_code,
                Country country, GeoPositionKey geoPositionKey,
                Double distance) {
        this._type = _type;
        this._id = _id;
        this.key = key;
        this.name = name;
        this.fullName = fullName;
        this.iata_airport_code = iata_airport_code;
        this.country = country;
        this.geoPositionKey = geoPositionKey;
        this.distance = distance;
    }

    public String get_type() {
        return _type;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getIata_airport_code() {
        return iata_airport_code;
    }

    public void setIata_airport_code(String iata_airport_code) {
        this.iata_airport_code = iata_airport_code;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public GeoPositionKey getGeoPositionKey() {
        return geoPositionKey;
    }

    public void setGeoPositionKey(GeoPositionKey geoPositionKey) {
        this.geoPositionKey = geoPositionKey;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "City{" +
                "_type='" + _type + '\'' +
                ", _id=" + _id +
                ", key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", iata_airport_code='" + iata_airport_code + '\'' +
                ", " + country +
                ", geoPositionKey=" + geoPositionKey +
                ", distance=" + distance +
                '}';
    }
}


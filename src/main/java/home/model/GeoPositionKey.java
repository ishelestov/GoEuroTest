package home.model;

/**
 * Geographic position presented by 2 params:
 * latitude, longitude - params that describe geographic position
 */
public class GeoPositionKey {

    private Double latitude;
    private Double longitude;

    public GeoPositionKey() {
    }

    public GeoPositionKey(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GeoPositionKey)) return false;

        GeoPositionKey that = (GeoPositionKey) o;

        if (!latitude.equals(that.latitude)) return false;
        if (!longitude.equals(that.longitude)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = latitude.hashCode();
        result = 31 * result + longitude.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "GeoPositionKey{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}

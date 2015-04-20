package home.service;

import home.model.City;
import home.model.Country;
import home.model.GeoPositionKey;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of CityService
 */
public class CityServiceImplement implements CityService {
    private City city;
    private List<City> cityList;

    /**
     * Make new City by input params
     * @param _type
     * @param _id
     * @param key
     * @param name
     * @param fullName
     * @param iata_airport_code
     * @param country
     * @param geoPositionKey
     * @param distance
     * @return
     */
    @Override
    public City makeCityObj(String _type, Long _id, String key, String name,
                            String fullName, String iata_airport_code,
                            Country country, GeoPositionKey geoPositionKey,
                            Double distance) {

        city = new City(_type, _id, key, name, fullName,
                            iata_airport_code, country,
                            geoPositionKey, distance);
        return city;
    }

    /**
     * Add input City to List of Cities
     * @param city
     */
    @Override
    public void addCityToList(City city) {
        cityList.add(city);
    }

    /**
     *
     * @return List of Cities
     */
    @Override
    public List<City> getCityList() {
        return cityList;
    }

    public CityServiceImplement() {
        this.cityList = new ArrayList<City>();
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "CityServiceImplement{" +
                "city=" + city +
                '}';
    }
}

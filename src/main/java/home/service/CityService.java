package home.service;

import home.model.City;
import home.model.Country;
import home.model.GeoPositionKey;

import java.util.List;

/**
 * Interface to work with City model
 */
public interface CityService {
    City makeCityObj(String _type, Long _id, String key, String name,
                     String fullName, String iata_airport_code,
                     Country country, GeoPositionKey geoPositionKey,
                      Double distance);

    void addCityToList(City city);

    List<City> getCityList();
}

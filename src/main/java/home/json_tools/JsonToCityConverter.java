package home.json_tools;


import home.exception.EmptyJsonArrayException;
import home.model.City;
import home.model.Country;
import home.model.GeoPositionKey;
import home.service.CityServiceImplement;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

/**
 * Class that get JSON array and make from it List of Cities
 */
public class JsonToCityConverter {
    /**
     * Parse JSON array and get needed params from there
     * Make new City and put to it all received info
     * Add every City to List od Cities
     * @param jsonArray - input array with info
     * @return ready List of Cities
     * @throws EmptyJsonArrayException
     */
    public List<City> convertJsonArrrayToList(JSONArray jsonArray) throws EmptyJsonArrayException {
        if (jsonArray == null){
            throw new EmptyJsonArrayException(
                    "JSON array is empty. Can't convert empty array");
        }

        CityServiceImplement cityServiceImplement = new CityServiceImplement();

        for (int i = 0; i < jsonArray.size(); i++){
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            String _type = (String) jsonObject.get("type");

            Long _id = (Long) jsonObject.get("_id");

            String key = (String) jsonObject.get("key");

            String name = (String) jsonObject.get("name");

            String fullName = (String) jsonObject.get("fullName");

            String iata_airport_code = (String) jsonObject.get("iata_airport_code");

            Country country = new Country();

            country.setCoreCountry((Boolean) jsonObject.get("coreCountry"));

            country.setCountry((String) jsonObject.get("country"));

            country.setCountryCode((String) jsonObject.get("countryCode"));

            country.setInEurope((Boolean) jsonObject.get("inEurope"));

            country.setLocationId((Long) jsonObject.get("locationId"));

            country.setType((String) jsonObject.get("type"));

            JSONObject jsonGeo = (JSONObject) jsonObject.get("geo_position");

            GeoPositionKey geoPositionKey = new GeoPositionKey();

            geoPositionKey.setLatitude((Double) jsonGeo.get("latitude"));

            geoPositionKey.setLongitude((Double) jsonGeo.get("longitude"));

            Double distance = (Double) jsonObject.get("distance");

            City city = cityServiceImplement.makeCityObj( _type,  _id,  key,  name,
                    fullName,  iata_airport_code,
                    country,  geoPositionKey,
                    distance);

            cityServiceImplement.addCityToList(city);

        }
        return cityServiceImplement.getCityList();

    }

}

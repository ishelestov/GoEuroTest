package home.csv;

import home.exception.EmptyJsonArrayException;
import home.json_tools.JsonDownloader;
import home.json_tools.JsonToCityConverter;
import home.model.City;
import home.model.GeoPositionKey;
import org.json.simple.JSONArray;

import java.io.*;
import java.util.List;

/**
 * Write information from List<City> to csv file
 */
public class CsvWritter {
    //Delimer in csv file between fields of City object
    static final String CSV_SEPARATOR = ",";

    public CsvWritter() {
    }

    /**
     * Make csv file if it is not exists, open OutputStream and write info to file
     * @param path - absolute path of csv file
     * @param cityList - input data for writing to csv file
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     */
    public void writeToCsv(String path, List<City> cityList) throws FileNotFoundException, UnsupportedEncodingException {
        //Check for not null arguments
        if (!validateInputArgs(path,cityList)){
            return;
        }
        try {
            File file = new File(path);
            boolean exists = file.exists();
            if(!exists){
                file.createNewFile();
            }

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(path, exists), "UTF-8"));

            for (City city : cityList) {
                bw.append(city.get_type() + CSV_SEPARATOR);
                bw.append(String.valueOf(city.get_id()) + CSV_SEPARATOR);
                bw.append(city.getName() + CSV_SEPARATOR);
                bw.append(city.getCountry().getType() + CSV_SEPARATOR);

                GeoPositionKey geoPosition = city.getGeoPositionKey();
                if (geoPosition != null) {
                    bw.append(String.valueOf(geoPosition.getLatitude()) + CSV_SEPARATOR);
                    bw.append(String.valueOf(geoPosition.getLongitude()) + ";\n");
                }

            }
            bw.append("\n");
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param path - absolute path to csv file
     * @param cityList - input data
     * @return true - if any arguments is not null. Else return false
     */
    private boolean validateInputArgs(String path, List<City> cityList){
        if (path == null){
            System.err.println("Path to csv file is empty");
            return false;
        }
        if (cityList == null || cityList.isEmpty()){
            System.err.println("List of cities to write is empty");
            return false;
        }
        return true;
    }

    /**
     * Make JSON array for every cityName and export data to csv file.
     * @param cityNames -  Array of String names of cities
     * @throws home.exception.EmptyJsonArrayException
     */
    public void convertAllDataToCsv(String[] cityNames, String path) throws EmptyJsonArrayException {
        JSONArray jsonArray = null;
        List<City> cities = null;
        // Check exist of csv file
        // If exist - delete
        File file = new File(path);
        if (file.exists()){
            file.delete();
        }
        for (String city:cityNames){
            //Make json array using cityName after trim of spaces
            JsonDownloader downloader = new JsonDownloader();
            jsonArray = downloader.makeUriAndRunDownloader(city.trim());
            //Make List of Cities from JSON array
            JsonToCityConverter converter = new JsonToCityConverter();
            cities = converter.convertJsonArrrayToList(jsonArray);
            //Write data to csv file
            try {
               writeToCsv(path, cities);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}

package home;

import home.csv.CsvWritter;
import home.exception.EmptyJsonArrayException;
import home.exception.InputArgumentCityNameException;
import home.validator.InputArgumentsValidator;

/**
 * Entry point for application
 * Run application
 *
 * args - array of String names of cities. Input from command line
 *
 */
public class Run
{

    // CSV out file path
    static final String PATH = "data.csv";

    public static void main( String[] args )  {
        try {
            InputArgumentsValidator validator = new InputArgumentsValidator();
            String[] cityNames = validator.getCityNameFromArguments(args);
            CsvWritter csvWritter  = new CsvWritter();
            csvWritter.convertAllDataToCsv(cityNames, PATH);
        } catch (InputArgumentCityNameException e) {
            e.printStackTrace();
        } catch (EmptyJsonArrayException e) {
            e.printStackTrace();
        }
    }


}

package home.validator;

import home.exception.InputArgumentCityNameException;


public class InputArgumentsValidator {

    public InputArgumentsValidator() {
    }

    /**
     * Get arguments from command line and check them for null;
     * @param arguments - Array of String arguments
     * @return  Array of String with names of cities
     * @throws home.exception.InputArgumentCityNameException
     */
    public  String[] getCityNameFromArguments(String[] arguments) throws InputArgumentCityNameException {
        if (arguments.length==0){
            throw new InputArgumentCityNameException(
                    "You have not entered any argument.");
        }else {
            return arguments;
        }


    }
}

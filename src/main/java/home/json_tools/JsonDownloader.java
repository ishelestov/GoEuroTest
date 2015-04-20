package home.json_tools;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * This class is used to get a JSON array from a given uri.
 */
public class JsonDownloader {

    static final String APPLICATION_JSON = "application/json";
    static final String TEST_API_ENDPOINT = "https://api.goeuro.com/GoEuroAPI/rest/api/v2/position/suggest/en/";

    public JsonDownloader() {
    }

    /**
     * Make HHTP request and response to get JSON array by uri
     * @param uri - input param to get JSON array
     * @return JSON array with info about cities
     * @throws IOException
     * @throws ParseException
     */
    public JSONArray uriToJsonArray(URI uri) throws  IOException, ParseException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(uri);
        HttpResponse response = client.execute(request);
        String value = response.getEntity().getContentType().getValue();

        if (value.contains(APPLICATION_JSON)) {
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));
            Object obj = new JSONParser().parse(new BufferedReader(rd));
            if (obj instanceof JSONArray) {
                return (JSONArray) obj;
            }
        }

        return null;
    }

    /**
     * Make URI and use it to get JSON array
     * @param cityName concat to api_endpoint and puts to uri
     * @return array of JSON objects
     */
    public JSONArray makeUriAndRunDownloader(String cityName){
        URI uri = null;
        try {
            uri  = new URI(TEST_API_ENDPOINT + cityName);
            JSONArray jsonArray = uriToJsonArray(uri);

            return  jsonArray;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

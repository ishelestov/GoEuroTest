package home;

import home.json_tools.JsonDownloader;
import junit.framework.TestCase;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class SimpleTest  extends TestCase {

    static final String TEST_API_ENDPOINT = "https://api.goeuro.com/GoEuroAPI/rest/api/v2/position/suggest/en/";

    @Test
    public void testCorrectCity() throws  IOException, ParseException, URISyntaxException {
        URI uri = new URI(TEST_API_ENDPOINT + "Kyiv");
        JsonDownloader downloader = new JsonDownloader();
        JSONArray array = downloader.uriToJsonArray(uri);
        Assert.assertNotNull(array);
        Assert.assertFalse(array.isEmpty());
    }

    @Test
    public void testUnCorrectCity() throws URISyntaxException, IOException, ParseException {
        URI uri = new URI(TEST_API_ENDPOINT + "UnRealCity");
        JsonDownloader downloader = new JsonDownloader();
        JSONArray array = downloader.uriToJsonArray(uri);
        Assert.assertNotNull(array);
        Assert.assertTrue(array.isEmpty());
    }
}

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Weather
{
    private String zip;
    private JsonElement results;

    public Weather(String kw)
    {
        try
        {
            zip = URLEncoder.encode(kw, "utf-8");
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
    }

    public void getZip()
    {
        String urlString = "https://api.aerisapi.com/observations/" + zip + "?client_id=wQhXMMnxoRV4HNKoRLZrL&client_secret=rUOW0GEyf5bT9JhUzro2WQAuUpj3A7nFHgVCRGEK";

        try
        {
            // Make URL object from urlString
            URL url = new URL(urlString);

            // Open stream readers for incoming data
            InputStream is = url.openStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            // Parse into JSON
            JsonParser parser = new JsonParser();
            results = parser.parse(br);

        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public String getWeather()
    {
        String title = results.getAsJsonObject()
                .get("temperature").getAsString();
                //.get("city").getAsString()
                //.get("state").getAsString();

        System.out.println(title);
        return title;
    }
}

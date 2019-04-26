
import java.util.Scanner;

public class WeatherTest extends Weather
{

    public WeatherTest(String kw)
    {
        super(kw);
    }

    public static void main(String[] args)
    {
        // Prompt user for keyword
        Scanner in = new Scanner(System.in);
        System.out.print("Enter zip: ");

        String keyword = in.next();
        //String zip = Weather(keyword);
        // Fetch weather
        Weather n = new Weather(keyword);
        n.getWeather();

        // Display weather
        System.out.println(n.getWeather());

    }
}

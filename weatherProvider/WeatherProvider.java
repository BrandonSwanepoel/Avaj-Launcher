package weatherProvider;

import java.util.Random;

import aircraft.Coordinates;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[] weather = { "SUN", "RAIN", "FOG", "SNOW" };

    private WeatherProvider() {
    }

    public static WeatherProvider getProvider() {
       return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        return weather[new Random().nextInt(weather.length)];
    }

}
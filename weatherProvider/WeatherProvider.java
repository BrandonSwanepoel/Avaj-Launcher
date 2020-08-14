package weatherProvider;

import aircraft.Coordinates;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[] weather = { "RAIN", "FOG", "SUN", "SNOW" };
    int previous;

    private WeatherProvider() {
    }

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
         int i = coordinates.getHeight()+ ( coordinates.getLongitude() + coordinates.getLatitude());
        return weather[i%4];
    }
}
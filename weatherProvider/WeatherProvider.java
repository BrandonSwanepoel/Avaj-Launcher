package weatherProvider;

import aircraft.Coordinates;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = null;
    private static String[] weather = { "RAIN", "FOG", "SUN", "SNOW" };

    private WeatherProvider() {}

    public static WeatherProvider getProvider() {
        if (weatherProvider == null) {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int i = coordinates.getHeight() + coordinates.getLongitude() + coordinates.getLatitude();
        return weather[i % 4];
    }
}
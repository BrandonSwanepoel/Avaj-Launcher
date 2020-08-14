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
        int a = 25214903;
        int c = 11;
        int r = a * previous + c;
        if(r < 0){
            r = 1;
        }
        previous = r;
       
        int i = coordinates.getHeight() + coordinates.getLongitude() + coordinates.getLatitude()+ r;
        return weather[i%4];
    }
}
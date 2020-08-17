package weatherProvider;

import aircraft.Coordinates;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = null;
    private static String[] weather = { "RAIN", "FOG", "SUN", "SNOW" };
    int random;


    private WeatherProvider() {}

    public static WeatherProvider getProvider() {
        if (weatherProvider == null) {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        if(random == 0){
            random = 1;
        }else if(random == 1){
            random = 2;
        }else if(random == 2){
            random =3;
        }else if(random == 3){
            random =1;
        }
        int i = coordinates.getHeight() + coordinates.getLongitude() + coordinates.getLatitude()*random;
        return weather[i % 4];
    }
}
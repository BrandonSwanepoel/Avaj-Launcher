package aircraft;

import tower.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower = new WeatherTower();
    String weather = null;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        int lat = coordinates.getLatitude();
        int height = coordinates.getHeight();
        weather = weatherTower.getWeather(coordinates);
        weatherTower.weatherMessage(this);

        switch (weather) {

            case "RAIN":
                coordinates.setLatitude(lat + 5);
                break;
            case "FOG":
                coordinates.setLatitude(lat + 1);
                break;
            case "SUN":
                coordinates.setLatitude(lat + 10);
                coordinates.setHeight(height + 2);
                break;
            case "SNOW":
                coordinates.setHeight(height - 7);
                break;
            default:
                System.out.println("Houston we have a problem here");
        }
        if (coordinates.getHeight() <= 0) {
            weatherTower.unregister(this);
        }

    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
    }

    @Override
    public String getType() {
        return "JetPlane";
    }

    @Override
    public String getWeather() {
        return this.weather;
    }

}
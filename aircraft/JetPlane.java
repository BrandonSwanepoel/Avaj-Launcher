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
        weather = weatherTower.getWeather(coordinates);
        updateCoordinates(this,weather,weatherTower);
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
        return weather;
    }

}
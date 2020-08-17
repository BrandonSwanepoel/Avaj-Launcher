package aircraft;

import tower.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower = new WeatherTower();
    String weather;

    Helicopter(String name, Coordinates coordinates) {
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
        return "Helicopter";
    }

    @Override
    public String getWeather() {
        return this.weather;
    }

}
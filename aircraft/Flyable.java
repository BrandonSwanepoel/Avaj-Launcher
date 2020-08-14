package aircraft;

import tower.WeatherTower;

public interface Flyable {
    public void updateConditions();
    public void registerTower(WeatherTower weatherTower);
    public Coordinates getCoordinates();
    public String getName();
    public String getId();
    public String getType();
    public String getWeather();
}
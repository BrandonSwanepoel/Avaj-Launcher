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
        int lon = coordinates.getLongitude();
        int height = coordinates.getHeight();
        weather = weatherTower.getWeather(coordinates);
        weatherTower.weatherMessage(this);

        switch (weather) {
            case "RAIN":
                coordinates.setLongitude(lon + 5);
                break;
            case "FOG":
                coordinates.setLongitude(lon + 1);
                break;
            case "SUN":
                coordinates.setLongitude(lon + 10);
                coordinates.setHeight(height + 2);
                break;
            case "SNOW":
                coordinates.setHeight(height - 12);
                break;

            default:
                System.out.println("Houston we have a problem here");
        }
        if (this.coordinates.getHeight() <= 0) {
            weatherTower.unregister(this);
        }

    }

    @Override
    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getId() {
        try {
            return String.valueOf(this.id);
        } catch (Exception e) {
            System.out.println("There was an error when converting integer to String");
            System.exit(0);
            return null;
        }
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
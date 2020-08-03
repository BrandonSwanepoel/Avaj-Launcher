package aircraft;

import tower.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower = new WeatherTower();

    protected Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);

    }

    @Override
    public void updateConditions() {
        switch (weatherTower.getWeather(this.coordinates)) {
            case "SUN":
                new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
                System.out.println("Baloon#" + this.name + '(' + this.id + ") It's sizzling ");
                break;
            case "RAIN":
                new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
                System.out.println("Baloon#" + this.name + '(' + this.id + ") The Baloon is getting very Wet");
                break;
            case "FOG":
                new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
                System.out.println("Baloon#" + this.name + '(' + this.id + ") uuuuh I can't see the Baloon..");
                break;
            case "SNOW":
                new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
                System.out.println("Baloon#" + this.name + '(' + this.id + ") Baloon?? You mean Snowbal");
                break;
            default:
                System.out.println("Houston we have a problem here");
        }
        if (this.coordinates.getHeight() <= 0) {
            System.out.println("Baloon#" + this.name + "(" + this.id + ")" + " landing.");
            this.weatherTower.unregister(this);
            System.out.println("Tower says: Baloon#" + this.name + "(" + this.id + ") unregistered from weather tower.");
            System.out.println("Baloon#" + this.name + "(" + this.id + ") Longitude = "+coordinates.getLongitude() +" and Latitude = "+coordinates.getLatitude());
        }

    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
        System.out.println("Tower says: Baloon#" + this.name + '(' + this.id + ") registered to weather tower.");

    }

}
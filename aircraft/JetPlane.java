package aircraft;

import tower.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower = new WeatherTower();
    protected JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        switch (weatherTower.getWeather(this.coordinates)) {
            case "SUN":
                new Coordinates(coordinates.getLongitude(), coordinates.getLatitude()+ 10, coordinates.getHeight() + 2);
                System.out.println("JetPlan#"+this.name+'('+this.id+") It's sizzling ");
                break;
            case "RAIN":
                new Coordinates(coordinates.getLongitude(), coordinates.getLatitude()+5, coordinates.getHeight() );
                System.out.println("JetPlan#"+this.name+'('+this.id+") It's raining 'Men' jk");
                break;
            case "FOG":
                new Coordinates(coordinates.getLongitude(), coordinates.getLatitude()+1, coordinates.getHeight());
                System.out.println("JetPlan#"+this.name+'('+this.id+") uuuuh I can't see..");
break;
            case "SNOW":
                new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);
                System.out.println("JetPlan#"+this.name+'('+this.id+") There is enough snow to make a Snowman");
break;
            default:
                System.out.println("Houston we have a problem here");
        }
        if (this.coordinates.getHeight() <= 0) {
            System.out.println("JetPlane#" + this.name + "(" + this.id + ")" + " landing.");
            this.weatherTower.unregister(this);
            System.out.println(
                    "Tower says: JetPlane#" + this.name + "(" + this.id + ") unregistered from weather tower.");
            System.out.println("JetPlane#" + this.name + "(" + this.id + ") Longitude = "+coordinates.getLongitude() +" and Latitude = "+coordinates.getLatitude());

        }

    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
        System.out.println("Tower says: JetPlan#"+this.name+'('+this.id+") registered to the weather tower.");
    }
    
}
package aircraft;

import tower.WeatherTower;

public class Aircraft {

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        if (coordinates.getHeight() > 0) {
            this.id = nextId();
        }

    }

    private long nextId() {
        return ++idCounter;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    public String getName() {

        return this.name;
    }

    public String getId() {
        try {
            return String.valueOf(this.id);
        } catch (Exception e) {
            System.out.println("There was an error when converting integer to String");
            System.exit(0);
            return null;
        }
    }

    public void updateCoordinates(Flyable flyable, String weather, WeatherTower weatherTower) {
        String aircraftType = flyable.getType();
        String aircraftName = flyable.getName();
        String aircraftId = flyable.getId();

        if (weather == "RAIN") {
            rain(aircraftType);
            System.out.println(aircraftType + "#" + aircraftName + '(' + aircraftId + ") It's raining... 'Men' jk");
        } else if (weather == "FOG") {
            fog(aircraftType);
            System.out.println(
                    aircraftType + "#" + aircraftName + '(' + aircraftId + ") I can't see...The Fog is too thick");
        } else if (weather == "SUN") {
            sun(aircraftType);
            System.out.println(aircraftType + "#" + aircraftName + '(' + aircraftId + ") It's hot hot hot up here ");
        } else if (weather == "SNOW") {
            snow(aircraftType);
            System.out.println(
                    aircraftType + "#" + aircraftName + '(' + aircraftId + ") There is enough snow to build a Snowman");
        } else {
            System.out.println("Houston we have a problem here");
        }
        if (coordinates.getHeight() <= 0) {
            weatherTower.unregister(flyable);
        }

    }

    private void sun(String type) {

        if (type == "Baloon") {
            coordinates.setLongitude(coordinates.getLongitude() + 2);
            coordinates.setHeight(coordinates.getHeight() + 4);
        } else if (type == "Helicopter") {
            coordinates.setLongitude(coordinates.getLongitude() + 10);
            coordinates.setHeight(coordinates.getHeight() + 2);
        } else if (type == "JetPlane") {
            coordinates.setLatitude(coordinates.getLatitude() + 10);
            coordinates.setHeight(coordinates.getHeight() + 2);
        }
    }

    private void rain(String type) {
        if (type == "Baloon") {
            coordinates.setHeight(coordinates.getHeight() - 5);
        } else if (type == "Helicopter") {
            coordinates.setLongitude(coordinates.getLongitude() + 5);
        } else if (type == "JetPlane") {
            coordinates.setLatitude(coordinates.getLatitude() + 5);
        }
    }

    private void fog(String type) {
        if (type == "Baloon") {
            coordinates.setHeight(coordinates.getHeight() - 3);
        } else if (type == "Helicopter") {
            coordinates.setLongitude(coordinates.getLongitude() + 1);
        } else if (type == "JetPlane") {
            coordinates.setLatitude(coordinates.getLatitude() + 1);
        }
    }

    private void snow(String type) {
        if (type == "Baloon") {
            coordinates.setHeight(coordinates.getHeight() - 15);
        } else if (type == "Helicopter") {
            coordinates.setHeight(coordinates.getHeight() - 12);
        } else if (type == "JetPlane") {
            coordinates.setHeight(coordinates.getHeight() - 7);
        }
    }

    protected long id = 0;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter;
}
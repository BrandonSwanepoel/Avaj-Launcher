package aircraft;

public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        try{
        switch (type) {
            case "Helicopter":
                return new Helicopter(name, new Coordinates(longitude,latitude,height));
            case "JetPlane":
                return new JetPlane(name, new Coordinates(longitude,latitude,height));
            case "Baloon":
                return new Baloon(name, new Coordinates(longitude,latitude,height));
            default:
                System.out.println("It's a bird ,it's a plane. No I don't know what that thing is...");
        }
    }catch(Exception e){
        System.out.println(e);
        System.exit(0);
    }
        return null;
    }

}
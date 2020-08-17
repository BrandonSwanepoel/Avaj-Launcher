package tower;

import java.util.ArrayList;
import aircraft.Flyable;

public class Tower {

    private ArrayList<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable) {
        if (flyable.getCoordinates().getHeight() > 0) {
            observers.add(flyable);
            System.out.println("Tower says: " + flyable.getType() + "#" + flyable.getName() + '(' + flyable.getId()
                    + ") registered to the weather tower.");
        }
    }

    public void unregister(Flyable flyable) {
        System.out.println(flyable.getType() + "#" + flyable.getName() + "(" + flyable.getId() + ")" + " landing.");
        System.out.println("Tower says: " + flyable.getType() + "#" + flyable.getName() + "(" + flyable.getId()
                + ") unregistered from weather tower.");
        System.out.println(flyable.getType() + "#" + flyable.getName() + "(" + flyable.getId()
                + ") Coordinates(Longitude = " + flyable.getCoordinates().getLongitude() + " and Latitude = "
                + flyable.getCoordinates().getLatitude() + ")");
    }

    protected void conditionsChanged() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).updateConditions();

            if (observers.get(i).getCoordinates().getHeight() <= 0) {
                observers.remove(i);
                i--;
            }
        }
    }
}
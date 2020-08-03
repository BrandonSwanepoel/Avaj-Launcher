package tower;

import java.util.ArrayList;

import aircraft.Flyable;

public class Tower {

    private ArrayList<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable) {
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        var itr = observers.iterator();
        while (itr.hasNext()) {
            if (itr.next() == flyable) {
                itr.remove();
            }
        }
    }

    protected void conditionsChanged() {
        var itr = observers.iterator();
        while (itr.hasNext()) {
            itr.next().updateConditions();
        }
    }
}
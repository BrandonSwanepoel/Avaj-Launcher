package aircraft;

public class Aircraft {

    protected Aircraft(String name, Coordinates coordinates){
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextId();

    }
    private long nextId(){
        return ++idCounter;
    }
    protected long id = 0;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter;
}
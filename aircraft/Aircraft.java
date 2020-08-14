package aircraft;

public class Aircraft {

    protected Aircraft(String name, Coordinates coordinates){
        this.name = name;
        this.coordinates = coordinates;
        if(coordinates.getHeight() > 0){
            this.id = nextId();

        }

    }
    private long nextId(){
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

    protected long id = 0;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter;
}
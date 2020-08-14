package aircraft;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int longitude, int latitude, int height) {
        setLongitude(longitude);
        setLatitude(latitude);
        setHeight(height);
    }

    public int getLongitude() {
        return this.longitude;
    }

    public int getLatitude() {
        return this.latitude;
    }

    public int getHeight() {
        return this.height;
    }

    public void setLongitude(int lon) {
        this.longitude = lon;
    }

    public void setLatitude(int lat) {
        this.latitude = lat;
    }

    public void setHeight(int height) {
        this.height = height > 100 ? 100 : height;
    }

}
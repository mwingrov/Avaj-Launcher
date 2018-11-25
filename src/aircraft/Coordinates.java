package aircraft;

public class Coordinates {

    private int longitude;
    private int latitude;
    private int height;

    public Coordinates(int longitude, int latitude, int height){
        this.latitude = checkValues(latitude);
        this.longitude = checkValues(longitude);
        this.height = checkValues(height);
        getHeight();
        getLatitude();
        getLongitude();
    }

    public int getHeight() {
        return height;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    private int checkValues(int value) {
        if (value > 100)
            value = 100;
        else if (value < 0)
            value = 0;
        return value;
    }

}

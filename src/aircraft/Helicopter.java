package aircraft;

import flyable.Flyable;
import tower.WeatherTower;

import static model.build.Main.writr;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower newWeatherTower;

    public Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);
        this.name = name;
        this.coordinates = coordinates;
    }
    public void updateConditions(){
        int copyHeight = this.coordinates.getHeight();
        int copyLong = this.coordinates.getLongitude();
        int copyLat = this.coordinates.getLatitude();
        String weather = this.newWeatherTower.getWeather(this.coordinates);
    }

    public void registerTower(WeatherTower weatherTower){
        writr.writetofile("Tower says: " + "Helicopter#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
        this.newWeatherTower = weatherTower;
        weatherTower.register(this);
    }

}

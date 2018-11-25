package aircraft;

import flyable.Flyable;
import tower.WeatherTower;

import static model.build.Main.writr;

public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower newWeatherTower;

    public JetPlane(String name, Coordinates coordinates){
        super(name, coordinates);
        this.name = name;
        this.coordinates = coordinates;
        updateConditions();
    }

    public void updateConditions(){
        int copyHeight = this.coordinates.getHeight();
        int copyLong = this.coordinates.getLongitude();
        int copyLat = this.coordinates.getLatitude();
        String weather = this.newWeatherTower.getWeather(this.coordinates);
    }

    public void registerTower(WeatherTower weatherTower){
        writr.writetofile("Tower says: " + "JetPlane#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
        this.newWeatherTower = weatherTower;
        weatherTower.register(this);
    }

}

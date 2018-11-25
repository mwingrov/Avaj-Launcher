package aircraft;

import flyable.Flyable;
import tower.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
    public Baloon(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions(){
    }

    public void registerTower(WeatherTower weatherTower){
    }
}

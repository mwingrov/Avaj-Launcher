package aircraft;

import flyable.Flyable;
import tower.WeatherTower;

class Baloon extends Aircraft implements Flyable {
    Baloon(String name, Coordinates coordinates){
        super(name, coordinates);
        this.name = name;
        this.coordinates = coordinates;
        updateConditions();
    }

    public void updateConditions(){
    }

    public static void registerTower(WeatherTower weatherTower){
    }
}

package aircraft;

import flyable.Flyable;
import tower.WeatherTower;

class Helicopter extends Aircraft implements Flyable {
    Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);
        this.name = name;
        this.coordinates = coordinates;
    }
    public void updateConditions(){
    }

    public void registerTower(WeatherTower weatherTower){
    }

}

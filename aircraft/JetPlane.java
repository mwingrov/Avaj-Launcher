package aircraft;

import flyable.Flyable;
import tower.WeatherTower;

class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates){
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

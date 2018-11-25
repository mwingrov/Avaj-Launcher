package aircraft;

import flyable.Flyable;
import tower.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates){
        super(name, coordinates);
        this.name = name;
        this.coordinates = coordinates;
        updateConditions();
    }

    public void updateConditions(){
    }

    public void registerTower(WeatherTower weatherTower){
    }

}

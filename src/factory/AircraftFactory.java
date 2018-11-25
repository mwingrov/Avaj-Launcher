package factory;

import aircraft.Baloon;
import aircraft.Coordinates;
import aircraft.Helicopter;
import aircraft.JetPlane;
import flyable.Flyable;

public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height){
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        Helicopter helicopter;
        Baloon baloon;
        JetPlane jetPlane;
        if (type.equals("helicopter")){
            helicopter = new Helicopter(name, coordinates);
            return helicopter;
        }
        else if (type.equals("baloon")){
            baloon = new Baloon(name, coordinates);
            return baloon;
        }
        else if (type.equals("JetPlane")){
            jetPlane = new JetPlane(name, coordinates);
            return jetPlane;
        }
        else
            return null;
    }
}

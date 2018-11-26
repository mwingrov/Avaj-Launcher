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
        int height = this.coordinates.getHeight();
        int longitude = this.coordinates.getLongitude();
        int latitude = this.coordinates.getLatitude();
        String weather = this.newWeatherTower.getWeather(this.coordinates);
        switch (weather)
        {
            case "RAIN":
                this.coordinates = new Coordinates(longitude + 5, latitude, height);
                writr.writetofile("Helicopter#" + this.name + "(" + this.id + "): Now i don't have to wash for at week!");
                break;
            case "SNOW":
                this.coordinates = new Coordinates(longitude, latitude, height - 12);
                writr.writetofile("Helicopter#" + this.name + "(" + this.id + "): Oh my fucking God!!! Sooo much snow!!!");
                break;
            case "FOG":
                this.coordinates = new Coordinates(longitude + 1, latitude, height);
                writr.writetofile("Helicopter#" + this.name + "(" + this.id + "): WTF?! Sooo much Fog!!! I can't see..Oh my fucking God!!!");
                break;
            case "SUN":
                this.coordinates = new Coordinates(longitude, latitude + 10, height + 2);
                writr.writetofile("Helicopter#" + this.name + "(" + this.id + "): Sunshine my only sunshine you make me happy when skies are Blue. :)");
                break;
            default:
                writr.writetofile("unknown weather: ");
                break;
        }
        if (coordinates.getHeight() <= 0)
            unregisterTower(this.newWeatherTower);
    }

    public void registerTower(WeatherTower weatherTower){
        writr.writetofile("Tower says: " + "Helicopter#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
        this.newWeatherTower = weatherTower;
        weatherTower.register(this);
    }

    public void unregisterTower(WeatherTower weatherTower)
    {
        writr.writetofile("Tower says: " + "Helicopter#" + this.name + "(" + this.id + ")" + " unregisteres from weather tower and lands.");
        this.newWeatherTower = weatherTower;
        weatherTower.unregister(this);
    }


}

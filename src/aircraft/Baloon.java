package aircraft;

import flyable.Flyable;
import tower.WeatherTower;

import static com.sun.org.glassfish.external.probe.provider.StatsProviderManager.unregister;
import static model.build.Main.writr;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower newWeatherTower;

    public Baloon(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions(){
        int height = this.coordinates.getHeight();
        int longitude = this.coordinates.getLongitude();
        int latitude = this.coordinates.getLatitude();
        String weather = this.newWeatherTower.getWeather(this.coordinates);
        switch (weather)
        {
            case "RAIN":
                this.coordinates = new Coordinates(longitude, latitude, height - 5);
                writr.writetofile("Baloon#" + this.name + "(" + this.id + "): Ahhh, it has been long since I had a good wash, pour on me thou Rain!");
                break;
            case "SNOW":
                this.coordinates = new Coordinates(longitude, latitude, height - 15);
                writr.writetofile("Baloon#" + this.name + "(" + this.id + "): Oh my fucken God can it stop snowing already!");
                break;
            case "FOG":
                this.coordinates = new Coordinates(longitude, latitude, height - 3);
                writr.writetofile("Baloon#" + this.name + "(" + this.id + "): I can't see, I can't see..Oh my a Crash is coming! Damn you Fog.");
                break;
            case "SUN":
                this.coordinates = new Coordinates(longitude, latitude, height + 4);
                writr.writetofile("Baloon#" + this.name + "(" + this.id + "): Finally some Sun, Ulra violets bouncing on me. :)");
                break;
            default:
                writr.writetofile("unknown weather: ");
                break;
        }
        if (coordinates.getHeight() <= 0)
            unregisterTower(this.newWeatherTower);
    }

    public void registerTower(WeatherTower weatherTower){
        writr.writetofile("Tower says: " + "Baloon#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
        this.newWeatherTower = weatherTower;
        weatherTower.register(this);
    }

    public void unregisterTower(WeatherTower weatherTower)
    {
        writr.writetofile("Tower says: " + "Baloon#" + this.name + "(" + this.id + ")" + " unregisteres from weather tower and lands.");
        this.newWeatherTower = weatherTower;
        weatherTower.unregister(this);
    }
}

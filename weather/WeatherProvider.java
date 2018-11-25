package weather;

import aircraft.Coordinates;

public class WeatherProvider {

    private static WeatherProvider weatherProvider = null;
    private static String[] weather = {"FOG", "RAIN", "SUN", "SNOW"};

    WeatherProvider(){
        getProvider();
    }

    public static WeatherProvider getProvider(){
        return weatherProvider;
    }

    public static String[] getCurrentWeather(Coordinates coordinates){

        return weather;
    }

}

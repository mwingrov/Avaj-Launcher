package weather;

import aircraft.Coordinates;

import java.util.Random;

public class WeatherProvider {

    private static WeatherProvider weatherProvider = null;
    private static String[] weather = {"FOG", "RAIN", "SUN", "SNOW"};

    WeatherProvider(){
        getProvider();
    }

    public static WeatherProvider getProvider(){
        if (weatherProvider.equals(null))
            weatherProvider = new WeatherProvider();
        return weatherProvider;
    }

    public static String getCurrentWeather(Coordinates coordinates){

        int generateWeather = new Random().nextInt(weather.length);
        String weatherBehavior = (weather[generateWeather]);
        return weatherBehavior;
    }

}

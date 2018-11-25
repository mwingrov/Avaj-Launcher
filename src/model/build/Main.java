package model.build;

import factory.AircraftFactory;
import flyable.Flyable;
import tower.WeatherTower;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static WeatherTower weatherTower;
    private static List<Flyable> flyables = new ArrayList<Flyable>();
    private static WriteToFile writr = new WriteToFile();
    public static void main(String args[])
    {

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();
            if (line != null)
            {
                weatherTower = new WeatherTower();
                int simulations = Integer.parseInt(line.split(" ")[0]);
                System.out.println(simulations + " Simulations to do");
                if (simulations < 0)
                {
                    System.out.println("Invalid simulations count " + simulations);
                    System.exit(1);
                }
                while ((line = reader.readLine()) != null)
                {
                    //System.out.println(line);
                    Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0], line.split(" ")[1],
                            Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]),
                            Integer.parseInt(line.split(" ")[4]));

                    if (flyable != null)
                    {
                        flyables.add(flyable);
                    }
                }
                for (Flyable flyable : flyables) {
                    flyable.registerTower(weatherTower);
                }
                for (int i = 1; i <= simulations; i++) {
                    weatherTower.changeWeather();
                }
            }
            reader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File " + args[0] + " Does not exist");
        } catch (IOException e) {
            System.out.println("There was an error while reading the file " + args[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid simulation file");
        } catch (NullPointerException e) {
            System.out.println("null");
        } catch (NumberFormatException e) {
            System.out.println("not a valid number entered in file");
        } finally {
            writr.closeFile();
        }
    }
}

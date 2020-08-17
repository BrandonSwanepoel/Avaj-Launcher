import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import ErrorChecking.ErrorChecking;
import aircraft.AircraftFactory;
import aircraft.Flyable;
import tower.WeatherTower;

public class Main {

  public static void main(String[] args) {
    int simulations = 0;
    WeatherTower weatherTower = new WeatherTower();
    try {
      File file = new File("sources.txt");
      if (file != null) {
        Scanner fileReader = new Scanner(file);
        simulations = ErrorChecking.checkIfSimulationIsNumber(fileReader);
        
        while (fileReader.hasNextLine()) {
          String data = fileReader.nextLine();
          if (data != null) {
            String[] arr = data.split(" ");

            ErrorChecking.checkTheNameOfTheAircraft(arr, fileReader);
            ErrorChecking.checkIfFileAttributesArePositive(arr, fileReader);
            ErrorChecking.checkIfAmountOfAttributesAreFive(arr, fileReader);

            Flyable aircraft = AircraftFactory.newAircraft(arr[0], arr[1], Integer.parseInt(arr[2]),
                Integer.parseInt(arr[3]), Integer.parseInt(arr[4]));
            if (aircraft != null) {
              aircraft.registerTower(weatherTower);
            }

          }
        }
        for (int i = 1; i <= simulations; i++) {
          System.out.println("");
          System.out.println("Simulation " + i);

          weatherTower.changeWeather();
        }
        fileReader.close();
      }
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

  }
}

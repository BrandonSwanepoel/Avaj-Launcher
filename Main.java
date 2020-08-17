import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import aircraft.AircraftFactory;
import aircraft.Flyable;
import errorChecking.ErrorChecking;
import tower.Tower;
import tower.WeatherTower;
import tower.*;
public class Main {

  public static void main(String[] args) {
    PrintStream fileStream = null;
    try {
      fileStream = new PrintStream("simulation.txt");
      System.setOut(fileStream);
    } catch (FileNotFoundException e1) {
      System.out.println("There was an error while trying to write to simulation.txt");
      e1.printStackTrace();
    }

    int simulations = 0;
    WeatherTower weatherTower = new WeatherTower();
    Tower tower = new Tower();
    try {
      File file = new File(args[0]);
      if (file != null) {
        Scanner fileReader = new Scanner(file);
        simulations = ErrorChecking.checkIfSimulationIsNumber(fileReader);
        ErrorChecking.checkIfSimulationIsNotNegativeOrZero(simulations, fileReader);

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
        fileStream.close();
      }
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

  }
}

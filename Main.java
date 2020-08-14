import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import aircraft.AircraftFactory;
import aircraft.Flyable;
import tower.WeatherTower;

public class Main {

  public static void main(String[] args) {
    int simulations = 0;
    WeatherTower weatherTower = new WeatherTower();
    try {
      File file = new File(args[0]);
      if (file != null) {
        Scanner fileReader = new Scanner(file);
        try {
          // Check if first line is a number

          simulations = Integer.parseInt(fileReader.nextLine());

          // Check if simulation is a positive number

          if (simulations < 0) {
            System.out.print("\nThe simulations amount is negative\nPlease fix it...\n");
            fileReader.close();
            System.exit(0);
          }
        } catch (NumberFormatException e) {
          System.out
              .print("\nThe Amount of simulations is missing or is not in the correct format...\nPlease fix it...\n");
          fileReader.close();
          System.exit(0);

        }
        while (fileReader.hasNextLine()) {

          String data = fileReader.nextLine();
          if (data != null) {
            String[] arr = data.split(" ");

            // Check if the Aircraft has the correct info in the source file

            // Check if name starts with the aircraft type
            if (arr[0].charAt(0) != arr[1].charAt(0)) {
              System.out.println(
                  "The Aircrafts Name does not start with the first letter of the Aircraft type\nPlease fix it...\n");
              fileReader.close();
              System.exit(0);
            }
            // check if the lon,lat and height is not negative numbers
            for (int i = 2; i < arr.length; i++) {
              int elementInInteger = 0;
              try {
                elementInInteger = Integer.parseInt(arr[i]);

                if (elementInInteger < 0) {
                  switch (i) {
                    case 2:
                      System.out.print(
                          "\nThe Longitude is a negative number for " + arr[0] + "#" + arr[1] + "\nPlease fix it...\n");
                      break;
                    case 3:
                      System.out.print(
                          "\nThe Latitude is a negative number for " + arr[0] + "#" + arr[1] + "\nPlease fix it...\n");
                      break;
                    case 4:
                      System.out.print(
                          "\nThe Height is a negative number for " + arr[0] + "#" + arr[1] + "\nPlease fix it...\n");
                      break;
                  }
                  fileReader.close();
                  System.exit(0);
                }

              } catch (NumberFormatException e) {
                System.out.print("\nThe Format of your text file is incorrect\nPlease fix it...\n");
                fileReader.close();
                System.exit(0);

              }
            }
            if (arr.length != 5) {
              System.out.print("\nThe Format of your text file is incorrect\nPlease fix it...\n");
              fileReader.close();
              System.exit(0);
            } else {

              Flyable aircraft = AircraftFactory.newAircraft(arr[0], arr[1], Integer.parseInt(arr[2]),
                  Integer.parseInt(arr[3]), Integer.parseInt(arr[4]));
              if (aircraft != null) {

                aircraft.registerTower(weatherTower);
              }
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

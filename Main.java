import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import aircraft.AircraftFactory;
import aircraft.Flyable;
import decryption_MD5.Decryption;
import tower.WeatherTower;

public class Main {

  public static void main(String[] args) {
    Decryption decryption = new Decryption();
    int simulations = 0;
    WeatherTower weatherTower = new WeatherTower();
    try {
      File file = new File(args[0]);
      if (file != null) {
        Scanner fileReader = new Scanner(file);
        // Check if file is a MD5 file and decrypt it

        if (!fileReader.nextLine().matches("[0-9]+")) {
          decryption.decrypt(new Scanner(file));
          file = new File("MD5_decrypted.txt");
          fileReader.close();
          fileReader = new Scanner(file);
        } else {
          fileReader.close();
          fileReader = new Scanner(file);
        }
        try {
          // Check if first line is a number

          simulations = Integer.parseInt(fileReader.nextLine());

          if (simulations < 0) {
            System.out.print("\nThe simulations amount is negative\nPlease fix it...\n");
            fileReader.close();
            System.exit(0);
          }
        } catch (NumberFormatException e) {
          System.out.print("\nThe Amount of simulations is missing...\n");
          fileReader.close();
          System.exit(0);

        }
        while (fileReader.hasNextLine()) {

          String data = fileReader.nextLine();
          if (data != null) {
            String[] arr = data.split(" ");
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

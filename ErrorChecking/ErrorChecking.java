package ErrorChecking;

import java.util.Scanner;

public class ErrorChecking {
    public static int checkIfSimulationIsNumber(Scanner fileReader) {
        int simulations = 0;
        try {
            simulations = Integer.parseInt(fileReader.nextLine());

            if (simulations < 0) {
                System.out.print("\nThe simulations amount is negative\nPlease fix it...\n");
                fileReader.close();
                System.exit(0);
            } else if (simulations == 0) {
                System.out.print("\nThe simulations amount is ZERO\nPlease fix it...\n");
                fileReader.close();
                System.exit(0);
            }
            return simulations;

        } catch (NumberFormatException e) {
            System.out.print(
                    "\nThe Amount of simulations is missing or is not in the correct format...\nPlease fix it...\n");
            fileReader.close();
            System.exit(0);
        }
        return 0;
    }

    public static void checkIfFileAttributesArePositive(String[] arr, Scanner fileReader) {
        for (int i = 2; i < arr.length; i++) {
            int elementInInteger = 0;
            try {
                elementInInteger = Integer.parseInt(arr[i]);

                if (elementInInteger < 0) {
                    switch (i) {
                        case 2:
                            System.out.print("\nThe Longitude is a negative number for " + arr[0] + "#" + arr[1]
                                    + "\nPlease fix it...\n");
                            break;
                        case 3:
                            System.out.print("\nThe Latitude is a negative number for " + arr[0] + "#" + arr[1]
                                    + "\nPlease fix it...\n");
                            break;
                        case 4:
                            System.out.print("\nThe Height is a negative number for " + arr[0] + "#" + arr[1]
                                    + "\nPlease fix it...\n");
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
    }

    public static void checkIfAmountOfAttributesAreFive(String[] arr, Scanner fileReader) {
        if (arr.length != 5) {
            System.out.print("\nThe Format of your text file is incorrect. There isn't 5 aircraft attributes\nPlease fix it...\n");
            fileReader.close();
            System.exit(0);
        }
    }
    public static void checkTheNameOfTheAircraft(String[] arr,Scanner fileReader){
        if (arr[0].charAt(0) != arr[1].charAt(0)) {
            System.out.println(
                "The Aircrafts Name does not start with the first letter of the Aircraft type\nPlease fix it...\n");
            fileReader.close();
            System.exit(0);
          }
    }
}
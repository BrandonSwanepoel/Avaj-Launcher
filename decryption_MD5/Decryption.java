package decryption_MD5;

import java.io.PrintWriter;
import java.util.Scanner;

public class Decryption {
  final String secretKey = "ssshhhhhhhhhhh!!!!";

  public void decrypt(Scanner myReader) {

    PrintWriter writer;
    try {
      writer = new PrintWriter("MD5_decrypted.txt", "UTF-8");

      while (myReader.hasNextLine()) {
        String decryptedString = AES.decrypt(myReader.nextLine(), secretKey);
        writer.println(decryptedString);
      }

      writer.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
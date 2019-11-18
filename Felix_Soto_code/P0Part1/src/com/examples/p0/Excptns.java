package com.examples.p0;
import java.io.IOException;
import java.util.Scanner;

public class Excptns {

  /**
   * Read double input from System's Standard input
   * @return Double value
   */
  public static Double doubleInput() throws IOException {
    @SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
    Double temp = null;
    do {
      try {
        temp = Double.parseDouble(sc.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Please enter an integer or real value.");
        continue;
      }
      break;
    } while (true);
    return temp;
  }

  /**
   * Read integer input from System's Standard input
   * @return Integer value
   */
  public static Integer integerInput() throws IOException {
    @SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
    Integer temp = null;
    do {
      try {
        temp = Integer.parseInt(sc.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Please enter an integer value.");
        continue;
      }
      break;
    } while (true);
    return temp;
  }

  /**
   * Read string input from System's Standard input
   * @return String value
   */
  public static String stringInput() throws IOException {
    @SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
    String temp = null;
    temp = sc.nextLine();
    return temp;
  }


}

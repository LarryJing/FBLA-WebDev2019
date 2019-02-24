// Chapter 5 Question 23

import java.util.Scanner;

public class DogsHumanAge
{
  public static void main(String[] args)
  {
    Scanner kb = new Scanner(System.in);
    System.out.print("Enter your dog's age (years): ");
    int dogYears = kb.nextInt();
    System.out.println(dogYears + " dog years roughly corresponds to " +
       convertToHumanAge(dogYears) + " human years.");
    kb.close();
  }

  private static int convertToHumanAge(int dogYears)
  {
    return 13 + (int)(16.0 / 3.0 * (dogYears - 1) + 0.5);
  }
}


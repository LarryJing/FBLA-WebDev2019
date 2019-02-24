// Chapter 7 Question 6

import java.util.Scanner;

public class Population
{
  private static final int startYear = 2014;
  private static final double growthRate = 1.005; // 0.5 percent growth
                                                   //    per year
  private static final double population2014 = 123.8;

  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    System.out.print("Target population (in million): ");
    double target = input.nextDouble();
    input.close();

    int year = startYear;
    double population = population2014;

    while (population < target)
    {
      population *= growthRate;
      year++;
    }

    System.out.println("The population will reach " + target
         + " million in " + year);
  }
}

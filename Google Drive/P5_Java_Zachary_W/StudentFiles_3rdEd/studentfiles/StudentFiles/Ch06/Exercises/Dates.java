// Chapter 6 Question 14

import java.util.Scanner;

public class Dates
{
  /**
   *  returns true if month1/day1/year1 is later than
   *  month2/day2/year2; otherwise returns false
   */
  public static boolean isLater(int month1, int day1, int year1,
                                int month2, int day2, int year2)
  {

    ___________________________________
    ...
  }

  public static void main(String[] args)
  {
    Scanner kb = new Scanner(System.in);

    System.out.print("Enter the first date  (month day year): ");
    int month1 = kb.nextInt();
    int day1 = kb.nextInt();
    int year1 = kb.nextInt();

    System.out.print("Enter the second date (month day year): ");
    int month2 = kb.nextInt();
    int day2 = kb.nextInt();
    int year2 = kb.nextInt();

    kb.close();

    System.out.println();  // blank line

    String msg = month1 + "/" + day1 + "/" + year1;
    if (isLater(month1, day1, year1, month2, day2, year2))
      msg += " IS ";
    else
      msg += " is NOT ";
    msg += "later than " + month2 + "/" + day2 + "/" + year2;
    System.out.println(msg);
  }
}


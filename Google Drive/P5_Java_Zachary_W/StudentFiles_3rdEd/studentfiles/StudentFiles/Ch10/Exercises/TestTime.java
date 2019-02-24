// Chapter 10 Question 13

import java.util.Scanner;

public class TestTime
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);

    System.out.println("Time 1" );
    System.out.print("Enter hours: " );
    int h1 = keyboard.nextInt();
    System.out.print("Enter mins: " );
    int m1 = keyboard.nextInt();
    Time t1 = new Time(h1, m1);

    System.out.println("Time 2" );
    System.out.print("Enter hours: " );
    int h2 = keyboard.nextInt();
    System.out.print("Enter mins: " );
    int m2 = keyboard.nextInt();
    Time t2 = new Time(h2, m2);

    System.out.println(t1 + " <= " + t2 + "? " + t1.lessThan(t2));
    System.out.println(t2.elapsedSince(t1) + " minutes elapsed from t1 to t2.");
    keyboard.close();
  }
}

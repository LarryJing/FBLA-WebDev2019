// Chapter 7 Question 13

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AverageScore
{
  public static void main(String[] args)
  {
    Scanner input = null;

    try
    {
      input = new Scanner(new File("scores.dat"));
    }
    catch (FileNotFoundException e)
    {
      System.out.println("***  Can't open scores.dat ***");
      System.exit(1);
    }

    _________________________________________________
    ...

  }
}

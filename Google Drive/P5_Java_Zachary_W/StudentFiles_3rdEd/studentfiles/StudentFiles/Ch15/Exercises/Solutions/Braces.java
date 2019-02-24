// Chapter 15 Question 4

import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Braces
{
  public static void main(String[] args) throws IOException
  {
    Scanner kboard = new Scanner(System.in);

    String fileName;

    if (args.length < 1)
    {
      System.out.print("Enter file name: ");
      fileName = kboard.nextLine();
    }
    else
      fileName = args[0];

    BufferedReader inputFile = new BufferedReader(new FileReader(fileName));

    int count = 0;
    int k;

    while ((k = inputFile.read()) != -1 && count >= 0)
    {
      char ch = (char)k;
      if (ch == '{')
        count++;
      else if (ch == '}')
        count--;
    }

    inputFile.close();

    if (count == 0)
      System.out.println(fileName + ": OK");
    else
      System.out.println(fileName + "braces do not match");

    kboard.close();
  }
}


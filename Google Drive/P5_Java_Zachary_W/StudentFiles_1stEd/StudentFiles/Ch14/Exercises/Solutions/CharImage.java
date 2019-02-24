// Question 14-7

import java.util.Scanner;
import java.io.*;

public class CharImage
{
  private int rows, cols;
  private char pixels[][];

  public CharImage(String fileName)
  {
    File file = new File(fileName);
    Scanner input = null;
    try
    {
      input = new Scanner(file);
    }
    catch (FileNotFoundException ex)
    {
      System.out.println("*** Can't open " + fileName + " ***");
      System.exit(1);
    }
    rows = input.nextInt();
    cols = input.nextInt();
    input.nextLine();  // consume the tail of the first line

    pixels = new char[rows][cols];

    for (int r = 0; r < rows; r++)
    {
      String line = input.nextLine();
      for (int c = 0; c < cols; c++)
      {
        pixels[r][c] = line.charAt(c);
      }
    }
  }

  public int numRows()
  {
    return rows;
  }

  public int numCols()
  {
    return cols;
  }

  public void display()
  {
    System.out.println();
    System.out.println(rows + " by " + cols + ":");
    System.out.println();

    for (int r = 0; r < rows; r++)
    {
      for (int c = 0; c < cols; c++)
      {
        System.out.print(pixels[r][c]);
      }
      System.out.println();
    }
  }

  public static void main(String[] args)
  {
    Scanner kboard = new Scanner(System.in);
    String fileName;

    if (args.length < 1)
    {
      System.out.print("Enter image file name: ");
      fileName = kboard.next();
    }
    else
      fileName = args[0];

    CharImage img = new CharImage(fileName);
    img.display();
  }
}


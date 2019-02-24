// Chapter 15 Question 5

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileCompare
{
  public static void main(String[] args)
  {
    if (args.length < 2)
    {
      System.out.println("Usage:\n\tC> java FileCompare file1 file2");
      System.exit(1);
    }

    String fileName1 = args[0], fileName2 = args[1];

    BufferedReader file1 = null;
    try
    {
      file1 = new BufferedReader(new FileReader(fileName1));
    }
    catch (FileNotFoundException ex)
    {
      System.out.println("*** Can't open " + fileName1 + " ***");
      System.exit(1);
    }

    BufferedReader file2 = null;
    try
    {
      file2 = new BufferedReader(new FileReader(fileName2));
    }
    catch (FileNotFoundException ex)
    {
      System.out.println("*** Can't open " + fileName2 + " ***");
      System.exit(1);
    }

    int ch1 = 0, ch2 = 0;
    int count = -1;
    try
    {
      do
      {
        ch1 = file1.read();
        ch2 = file2.read();
        count++;
      } while (ch1 != -1 && ch2 != -1 && ch1 == ch2);
    }
    catch (IOException ex)
    {
      System.out.println("*** Read error ***");
      System.exit(1);
    }

    if (ch1 == ch2)
      System.out.println("Files compare OK");
    else
      System.out.printf("Mismatch at position %d:\n%20s -- %04x\n%20s -- %04x\n",
         count, fileName1, ch1, fileName2, ch2);
    try
    {
      file1.close();
      file2.close();
    }
    catch (IOException ex)
    {
      System.out.println("*** Can't close files ***");
      System.exit(1);
    }
  }
}


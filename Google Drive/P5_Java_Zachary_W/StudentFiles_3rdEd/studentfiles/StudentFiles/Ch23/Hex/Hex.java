/**
 * This program tests whether black has won in a
 * game of Hex position
 */

import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

public class Hex
{
  public static HexBoard read(String fileName)
  {
    Scanner inputFile = null;
    try
    {
      inputFile =
               new Scanner(new FileReader(fileName));
    }
    catch (IOException ex)
    {
      System.out.println("*** Cannot open " + fileName + " ***");
      System.exit(1);
    }

    int rows = inputFile.nextInt();
    int cols = inputFile.nextInt();
    inputFile.nextLine(); // consume the rest of the line

    HexBoard board = new HexBoard(rows, cols);

    for (int r = 0; r < rows; r++)
    {
      String str = inputFile.nextLine();
      for (int c = 0; c < cols && c < str.length(); c++)
      {
        char ch = str.charAt(c);
        if (ch == 'B')
          board.setBlack(r, c);
        else if (ch == 'W')
          board.setWhite(r, c);
      }
    }
    inputFile.close();
    return board;
  }

  public static void main(String[] args)
  {
    Scanner kb = new Scanner(System.in);
    String fileName;
    
    if (args.length > 0)
      fileName = args[0];
    else
    {
      System.out.print("File name: ");
      fileName = kb.nextLine().trim();
    }

    HexBoard board = read(fileName);
    System.out.println("\nBoard from file:\n");
    System.out.println(board + "\n");

    // Test blackHasWon:

    System.out.println("blackHasWon = " + board.blackHasWon() + "\n");
    System.out.println("Board after test (unchanged):\n");
    System.out.println(board + "\n");

    // Test areaFill:

    System.out.println("Area fill test");
    System.out.println("Pick a black hexagon");
    System.out.print("row: ");
    int r = kb.nextInt();
    System.out.print("col: ");
    int c = kb.nextInt();
    System.out.println();
    board.areaFill(r, c);
    System.out.println(board + "\n");
    kb.close();
  }
}

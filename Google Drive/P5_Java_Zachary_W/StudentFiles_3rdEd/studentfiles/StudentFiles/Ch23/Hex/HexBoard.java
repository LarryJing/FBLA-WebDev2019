/**
 * Area fill functions for the game of Hex
 */

public class HexBoard extends CharMatrix
{
  public HexBoard(int rows, int cols)
  {
    _____________________________________________
    ...
  }

  public boolean isBlack(int r, int c)
  {
    _____________________________________________
    ...
  }

  public boolean isWhite(int r, int c)
  {
    _____________________________________________
    ...
  }

  public  boolean isGray(int r, int c)
  {
    _____________________________________________
    ...
  }

  public void setBlack(int r, int c)
  {
    _____________________________________________
    ...
  }

  public void setWhite(int r, int c)
  {
    _____________________________________________
    ...
  }

  public void setGray(int r, int c)
  {
    _____________________________________________
    ...
  }

  /**
   * Returns true if there is a contiguous chain of black stones
   * that starts in col 0 and ends in the last column of the board;
   * otherwise returns false.
   */
  public boolean blackHasWon()
  {
    _____________________________________________
    ...
  }

  /**
   * Fills the contiguous area that contains r,c with gray color.
   * Does nothing if r, c is out of bounds or is not black.
   */
  public void areaFill(int r, int c)
  {
    _____________________________________________
    ...
  }

  public String toString()
  {
    String s = "";

    for (int r = 0; r < numRows(); r++)
    {
      for (int c = 0; c < numCols(); c++)
      {
        if (isBlack(r, c))
          s += 'B';
        else if (isWhite(r, c))
          s += 'W';
        else if (isGray(r, c))
          s += 'X';
        else
          s += '.';
      }
      s += '\n';
    }
    return s;
  }

  //****************************************************************

  private boolean isInBounds(int row, int col)
  {
    _____________________________________________
    ...
  }
}

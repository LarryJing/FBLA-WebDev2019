/**
 * Represents a panel for one cell in the Puzzle program.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import javax.swing.JPanel;

public class PuzzleCell extends JPanel
{
  private int pieceNumber;
  private boolean picked;

  public PuzzleCell(int k)
  {
    pieceNumber = k;
    picked = false;
  }

  public int getPieceNumber()
  {
    return pieceNumber;
  }

  public void setPieceNumber(int k)
  {
    pieceNumber = k;
  }

  public void setPicked(boolean state)
  {
    picked = state;
  }

  public void paintComponent(Graphics g)
  {
    ___________________________________
    ...
  }

  private void drawPuzzle(Graphics g)
  {
    int width = 3 * getWidth() + 3;   // width of the picture
    int height = 3 * getHeight() + 3; // height of the picture

    int x, y, row, col, k = 1;

    g.setColor(Color.blue);
    g.setFont(new Font("Serif", Font.PLAIN, height / 12));
    for (row = 0; row < 3; row++)
    {
      for (col = 0; col < 3; col++)
      {
        x = width/6 + col * width / 3;
        y = height/6 + row * height / 3;
        g.drawString(String.valueOf(k), x, y);
        k++;
      }
    }
    g.setColor(Color.red);
    g.drawOval(width / 9, height / 9, 7 * width / 9, 7 * height / 9);
  }
}

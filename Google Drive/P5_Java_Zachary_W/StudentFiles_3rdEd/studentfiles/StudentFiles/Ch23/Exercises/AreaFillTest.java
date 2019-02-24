// Chapter 23 Question 11

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Cursor;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AreaFillTest extends JPanel
    implements MouseListener
{
  private String[] picture =
    {
      "....................",
      "....xxxxx..xxx......",
      "....x...x..x..x.xx..",
      "...x....xxx....x..x.",
      "....x.............x.",
      ".....xx...........x.",
      ".......x.....xxx..x.",
      ".......x.....x..x.x.",
      ".....xxx.....xx..xx.",
      "....x..........x....",
      "...x...........xx...",
      "....xxx..........x..",
      "......x..........x..",
      ".....x....xxxx...x..",
      "....x....x...x..x...",
      "...x......xx..x.x...",
      "..x...x....x...x....",
      "...x.x.x..x.........",
      "....x...xx..........",
      "....................",
    };

  private Color[][] plane;

  public AreaFillTest()
  {
    int rows = picture.length;
    int cols = picture[0].length();
    plane = new Color[rows][cols];
    for (int r = 0; r < rows; r++)
    {
      for (int c = 0; c < cols; c++)
      {
        if (picture[r].charAt(c) != '.')
          plane[r][c] = Color.WHITE;
        else
          plane[r][c] = Color.BLACK;
      }
    }

    setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
    addMouseListener(this);
  }

  public void paintComponent(Graphics g)
  {
    int rows = plane.length;
    int cols = plane[0].length;
    int w = getWidth() / cols;
    int h = getHeight() / rows;
    for (int r = 0; r < rows; r++)
    {
      for (int c = 0; c < cols; c++)
      {
        int x = w * c;
        int y = h * r;
        g.setColor(plane[r][c]);
        g.fillRect(x, y, w-2, h-2);
      }
    }
  }

  // MouseListener implementation:
  public void mousePressed(MouseEvent e)
  {
    int x = e.getX();
    int y = e.getY();
    int rows = plane.length;
    int cols = plane[0].length;
    int w = getWidth() / cols;
    int h = getHeight() / rows;
    int row = y / h;
    int col = x / w;
    if (row >= rows || col >= cols)
      return;

    Color fillColor = Color.BLUE;
    if (fillColor.equals(plane[row][col]))
      fillColor = Color.BLACK;

    AreaFill.fillPool(plane, row, col, fillColor);
    repaint();
  }

  // Not used:
  public void mouseClicked(MouseEvent e) { }
  public void mouseReleased(MouseEvent e) { }
  public void mouseEntered(MouseEvent e) { }
  public void mouseExited(MouseEvent e) { }

  public static void main(String[] args)
  {
    JFrame window = new JFrame("Area fill");
    window.setBounds(100, 100, 320, 300);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.getContentPane().add(new AreaFillTest());
    window.setVisible(true);
  }
}

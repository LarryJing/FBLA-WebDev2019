import java.awt.*;
import javax.swing.*;

/**
 *  This program draws an ornament of nested triangles
 */

public class Ornament extends JPanel
{
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);  // Call JPanel's paintComponent method
                              //   to paint the background
    drawTriangles(g, 100, 80, 64);
  }

  /**
   *  Draws an ornament made of triangles in Graphics g
   *  with the base midpoint at (x, y) and base half-length r
   */
  public void drawTriangles(Graphics g, int x, int y, int r)
  {
    g.drawLine( ... );
    ...
  }

  public static void main(String[] args)
  {
    JFrame w = new JFrame("Triangles");
    w.setBounds(300, 300, 200, 120);
    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Ornament panel = new Ornament();
    panel.setBackground(Color.WHITE);
    Container c = w.getContentPane();
    c.add(panel);
    w.setResizable(false);
    w.setVisible(true);
  }
}

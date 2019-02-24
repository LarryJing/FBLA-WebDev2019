// Question 2-14

import java.awt.*;
import javax.swing.*;

public class HelloApplet2 extends JApplet
{
  public void init()
  {
    Container c = getContentPane();
    c.setBackground(Color.WHITE);
  }

  public void paint(Graphics g)
  {
    super.paint(g);    // Call JApplet's paint method
                       //  to paint the background
    g.setColor(Color.BLUE);
    g.fillRect(25, 40, 150, 45);  // draw a rectangle 150 by 45
    g.setColor(Color.WHITE);
    g.drawString("Hello, Applet!", 60, 65);
  }
}

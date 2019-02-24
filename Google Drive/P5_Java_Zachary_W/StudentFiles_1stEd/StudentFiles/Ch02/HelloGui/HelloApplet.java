// This applet shows a string of text inside a box.

import java.awt.*;
import javax.swing.*;

public class HelloApplet extends JApplet
{
  public void init()
  {
    Container c = getContentPane();
    c.setBackground(Color.WHITE);
  }

  public void paint(Graphics g)
  {
    super.paint(g);    // call JApplet's paint method
                       //  to paint the background
    g.setColor(Color.RED);
    g.drawRect(25, 40, 150, 45);  // draw a rectangle 150 by 45
    g.setColor(Color.BLUE);
    g.drawString("Hello, Applet!", 60, 65);
  }
}

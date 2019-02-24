// Chapter 2 Question 16

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HelloGraphics2 extends JPanel
{
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);  // Call JPanel's paintComponent method
                              //  to paint the background
    g.setColor(Color.BLUE);

    // Draw a 150 by 45 rectangle with the upper-left
    // corner at x = 20, y = 40:
    g.fillRect(20, 40, 150, 45);

    g.setColor(Color.WHITE);

    // Draw a string of text starting at x = 55, y = 65:
    g.drawString("Hello, Graphics!", 55, 65);
  }

  public static void main(String[] args)
  {
    JFrame window = new JFrame("Graphics Demo");
    // Set this window's location and size:
    // upper-left corner at 300, 300; width 200, height 150
    window.setBounds(300, 300, 200, 150);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    HelloGraphics2 panel = new HelloGraphics2();
    panel.setBackground(Color.WHITE);  // the default color is light gray
    Container c = window.getContentPane();
    c.add(panel);

    window.setVisible(true);
  }
}

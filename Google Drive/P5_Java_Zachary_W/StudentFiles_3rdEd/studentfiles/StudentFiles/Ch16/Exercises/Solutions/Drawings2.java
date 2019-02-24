// Chapter 16 Question 2

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawings2 extends JPanel
{
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);

    // (a)
    int x0 = 40;
    int y0 = 40;
    g.setColor(Color.BLACK);
    g.drawRect(x0 - 15, y0, 30, 20);
    g.drawOval(x0 - 10, y0 - 20, 20, 20);

    // (g)
    x0 += 60;
    g.setColor(Color.BLACK);
    g.drawArc(x0 - 20, y0 - 20, 40, 40, 90, 270);
    g.drawLine(x0, y0, x0, y0 - 20);
    g.drawLine(x0, y0, x0 + 20, y0);
  }

  public static void main(String[] args)
  {
    JFrame window = new JFrame("Drawings");
    window.setBounds(100, 100, 300, 200);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel canvas = new Drawings2();
    canvas.setBackground(Color.WHITE);
    window.getContentPane().add(canvas);
    window.setVisible(true);
  }
}


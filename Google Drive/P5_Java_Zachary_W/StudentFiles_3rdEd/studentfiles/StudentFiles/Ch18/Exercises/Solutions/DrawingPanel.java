// Chapter 18 Question 2

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel
    implements MouseListener
{
  private Color color;

  public DrawingPanel()
  {
    addMouseListener(this);
    color = Color.GREEN;
  }

  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);

    int w = getWidth();
    int h = getHeight();

    g.setColor(color);
    g.fillOval(w/4, h/4, w/2, h/2);
  }

  public void mousePressed(MouseEvent e)
  {
    color = Color.RED;
    repaint();
  }

  public void mouseReleased(MouseEvent e)
  {
    color = Color.GREEN;
    repaint();
  }

  // Not used:
  public void mouseClicked(MouseEvent e) {}
  public void mouseEntered(MouseEvent e) {}
  public void mouseExited(MouseEvent e) {}

  //**************************************************************

  public static void main(String[] args)
  {
    JFrame window = new JFrame("Drawing panel test");
    window.setBounds(100, 100, 180, 200);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = window.getContentPane();
    c.add(new DrawingPanel(), BorderLayout.CENTER);
    window.setVisible(true);
  }
}

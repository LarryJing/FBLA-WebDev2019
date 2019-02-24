// Chapter 18 Question 1

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

public class FourSeasons extends JFrame
    implements MouseListener
{
  private Color colors[] =
     {Color.WHITE, Color.GREEN, Color.GREEN.darker(), Color.YELLOW.darker()};
  private int colorIndex = 0;
  private Container pane;

  public FourSeasons()
  {
    super("Four Seasons");
    pane = getContentPane();
    pane.setBackground(colors[colorIndex]);
    pane.addMouseListener(this);
  }

  public void mousePressed(MouseEvent e)
  {
    colorIndex = (colorIndex + 1) % colors.length;
    pane.setBackground(colors[colorIndex]);
  }

  // Not used:
  public void mouseClicked(MouseEvent e) { }
  public void mouseReleased(MouseEvent e) { }
  public void mouseEntered(MouseEvent e) { }
  public void mouseExited(MouseEvent e) { }

  //**************************************************************

  public static void main(String[] args)
  {
    FourSeasons window = new FourSeasons();
    window.setBounds(100, 100, 200, 200);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    window.setVisible(true);
  }
}


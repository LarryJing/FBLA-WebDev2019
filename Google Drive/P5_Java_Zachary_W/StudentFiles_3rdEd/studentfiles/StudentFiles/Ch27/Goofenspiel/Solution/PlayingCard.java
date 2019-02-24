/**
 * Represents a displayable playing card
 */

import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class PlayingCard extends JPanel
{
  private final ImageIcon picture;
  private final int rank;
  private boolean active;

  public PlayingCard(String iconName, int rank, MouseListener controller)
  {
    setPreferredSize(new Dimension(75,100));
    picture = new ImageIcon(iconName);
    this.rank = rank;
    active = true;
    if (controller != null)
      addMouseListener(controller);
  }

  public void setActive(boolean flag)
  {
    active = flag;
  }

  public boolean isActive()
  {
    return active;
  }

  public int getRank()
  {
    return rank;
  }

  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    if (active)
      picture.paintIcon(this, g, 0, 0);
  }
}
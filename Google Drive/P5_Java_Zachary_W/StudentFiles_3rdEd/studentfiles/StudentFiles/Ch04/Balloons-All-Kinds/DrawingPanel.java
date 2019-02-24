import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.JColorChooser;
import java.util.ArrayList;

/*
 * Represents the canvas in BalloonDraw.
 */
public class DrawingPanel extends JPanel
  implements MouseListener, MouseMotionListener, KeyListener
{
  private ArrayList<Balloon> balloons;
  private Balloon activeBalloon;
  private Color color;

  private boolean picked, stretching;

  private int offsetX, offsetY;
  private double offsetR;

  // Constructor:
  public DrawingPanel()
  {
    setBackground(Color.WHITE);

    addMouseListener(this);
    addMouseMotionListener(this);
    addKeyListener(this);

    balloons = new ArrayList<Balloon>();
    activeBalloon = null;
    picked = false;
    stretching = false;

    color = Color.BLUE;
  }

  // Called from controlPanel when the "Pick color" button is clicked.
  public void pickColor()
  {
    Color pickedColor = JColorChooser.showDialog(this,
                                      "Pick a color", color);
    if (pickedColor != null)
      color = pickedColor;
  }

  // Returns the current color.
  public Color getColor()
  {
    return color;
  }

  // Called from controlPanel when the "Add balloon" button is clicked.
  // Places a new balloon with a random radius and the current color
  // at the center of the drawing panel.
  public void addBalloon(int shape)
  {
    int w = getWidth();
    int h = getHeight();
    int radius = 10 + (int)(Math.random() * w / 2);
    switch (shape)
    {
      case 1: activeBalloon = new RoundBalloon(w/2, h/2, radius, color); break;
      case 2: activeBalloon = new OvalBalloon(w/2, h/2, radius, color); break;
      case 3: activeBalloon = new SquareBalloon(w/2, h/2, radius, color); break;
      case 4: activeBalloon = new FancyBalloon(w/2, h/2, radius, color); break;
      default: activeBalloon = new RoundBalloon(w/2, h/2, radius, color); break;
    }
    balloons.add(activeBalloon);
    repaint();
  }

  // Repaints this panel. If activeBalloon is set, paints it on top.
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);

    for (Balloon b : balloons)
    {
      if (!picked || b != activeBalloon)
        b.draw(g, true);
    }
    if (picked && activeBalloon != null)
      activeBalloon.draw(g, false);
  }

  // Called when the mouse is clicked on the drawing panel.
  // If inside a balloon, makes it "active", remembers the offsets
  // of the click from the center.
  // If on the border of a balloon, makes it "active", remembers the
  // distance of the click from the center.
  public void mousePressed(MouseEvent e)
  {
    int x = e.getX();
    int y = e.getY();

    picked = false;
    for (int k = balloons.size() - 1; k >= 0 && !picked; k--)
    {
      Balloon b = balloons.get(k);
      if (b.isInside(x, y))
      {
        picked = true;
        offsetX = x - b.getX();
        offsetY = y - b.getY();
        stretching = false;
        activeBalloon = b;
      }
      else if (b.isOnBorder(x, y))
      {
        picked = true;
        offsetR = b.distance(x, y) -
                             b.getRadius();
        stretching = true;
        activeBalloon = b;
      }
    }
    if (picked)
      repaint();
  }

  // "Drops" the picked balloon, if any.
  public void mouseReleased(MouseEvent e)
  {
    if (picked)
      repaint();
    picked = false;
    stretching = false;
  }

  public void mouseDragged(MouseEvent e)
  {
    if (activeBalloon == null || !picked)
      return;

    int x = e.getX();
    int y = e.getY();

    if (stretching)
    {
      // newDistance - newRadius = offsetR ==>
      //                     newRadius = newDistance - offsetR
      activeBalloon.setRadius((int)(Math.round(activeBalloon.distance(x, y)
                                                    - offsetR)));
    }
    else
    {
      // x - newCenterX = offsetX ==> newCenterX = x - offsetX
      // y - newCenterY = offsetY ==> newCenterY = y - offsetY
      activeBalloon.move(x - offsetX, y - offsetY);
    }

    repaint();
  }

  // Cursor keys move the active balloon.
  // Cursor keys with ctrl down stretch the active balloon.
  public void keyPressed (KeyEvent e)
  {
    if (activeBalloon == null)
      return;

    int dx = 0, dy = 0, dr = 0;

    switch(e.getKeyCode())
    {
      case KeyEvent.VK_UP:
      case KeyEvent.VK_KP_UP:
        dy = -1;
        dr = 1;
        break;

      case KeyEvent.VK_DOWN:
      case KeyEvent.VK_KP_DOWN:
        dy = 1;
        dr = -1;
        break;

      case KeyEvent.VK_LEFT:
      case KeyEvent.VK_KP_LEFT:
        dx = -1;
        dr = -1;
        break;

      case KeyEvent.VK_RIGHT:
      case KeyEvent.VK_KP_RIGHT:
        dx = 1;
        dr = 1;
        break;
    }

    if (dx != 0 || dy != 0 || dr != 0)
    {
      if (e.isControlDown())
        activeBalloon.setRadius(activeBalloon.getRadius() + dr);
      else
        activeBalloon.move(activeBalloon.getX() + dx,
                           activeBalloon.getY() + dy);
      repaint();
    }
  }

  // Not used:
  public void mouseEntered(MouseEvent e) {}
  public void mouseExited(MouseEvent e) {}
  public void mouseClicked(MouseEvent e) {}
  public void mouseMoved(MouseEvent e) {}
  public void keyTyped(KeyEvent e) {}
  public void keyReleased(KeyEvent e) {}
}

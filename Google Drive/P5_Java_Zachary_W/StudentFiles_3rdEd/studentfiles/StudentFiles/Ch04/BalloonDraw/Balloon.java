/**
 * Represents a balloon in the BalloonDraw program.
 * Author: Willy Bolly
 * Ver 1.0 Created 12/31/17
 */

import java.awt.Color;
import java.awt.Graphics;

public class Balloon
{
  private int xCenter, yCenter, radius;
  private Color color;

  /**
   * Constructs a balloon with the center at (0, 0),
   * radius 50, and blue color
   */
  public Balloon()
  {
    xCenter = 0;
    yCenter = 0;
    radius = 50;
    color = Color.BLUE;
  }

  /**
   * Constructs a balloon with a given center, radius and color
   * @param x x-coordinate of the center
   * @param y y-coordinate of the center
   * @param r radius of the balloon
   * @param c color of the balloon
   */
  public Balloon(int x, int y, int r, Color c)
  {
    xCenter = x;
    yCenter = y;
    radius = r;
    color = c;
  }

  /**
   * Returns the x-coordinate of the center.
   */
  public int getX()
  {
    return xCenter;
  }

  /**
   * Returns the y-coordinate of the center.
   */
  public int getY()
  {
    return yCenter;
  }

  /**
   * Returns the radius of this balloon.
   */
  public int getRadius()
  {
    return radius;
  }

  /**
   * Returns the color of this balloon.
   */
  public Color getColor()
  {
    return color;
  }

  /**
   * Returns the distance from a given point to the
   * center of this balloon.
   * @param x, y coordinates of the point
   */
  public double distance(int x, int y)
  {
    double dx = x - xCenter;
    double dy = y - yCenter;
    return Math.sqrt(dx*dx + dy*dy);
  }

  /**
   * Moves the center of this balloon to (x, y)
   * @param x x-coordinate of the new center
   * @param y y-coordinate of the new center
   */
  public void move(int x, int y)
  {
    xCenter = x;
    yCenter = y;
  }

  /**
   * Sets the radius of this balloon to r
   * @param r new radius
   */
  public void setRadius(int r)
  {
    radius = r;
  }

  /**
   * Returns true if a given point is strictly inside this balloon;
   * otherwise returns false
   * @param x, y coordinates of the point
   */
  public boolean isInside(int x, int y)
  {
    return distance(x, y) < 0.9 * radius;
  }

  /**
   * Returns true if a given point is on the border of this balloon;
   * otherwise returns false
   * @param x, y coordinates of the point
   */
  public boolean isOnBorder(int x, int y)
  {
    double d = distance(x, y);
    return d >= 0.9 * radius && d <= 1.1 * radius;
  }

  /**
   * Draws a solid circle if makeItFilled is true and
   * outline only if makeItFilled is false
   * @param g graphics context
   * @param makeItFilled draws a solid circle if true
   */
  public void draw(Graphics g, boolean makeItFilled)
  {
    g.setColor(color);
    if (makeItFilled)
      g.fillOval(xCenter - radius,
                 yCenter - radius, 2*radius, 2*radius);
    else
      g.drawOval(xCenter - radius,
                 yCenter - radius, 2*radius, 2*radius);
  }
}
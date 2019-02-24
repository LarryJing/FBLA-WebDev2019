// Chapter 5 Question 17

import java.awt.Color;

/** Represents a inflatable balloon
 */
public class InflatableBalloon extends Balloon
{
  public InflatableBalloon()
  {
    super(); // optional line
  }

 public InflatableBalloon(int x, int y, int r, Color c)
  {
    super(x, y, r, c);
  }

  public void inflate(int percentage)
  {
    int r = getRadius();
    double rCubed = Math.pow(r, 3); // or (double)r * r * r;
    rCubed *= 0.01 * (100 + percentage);
    r = (int)(Math.pow(rCubed, 1.0/3.0) + 0.5);
    setRadius(r);
  }
}
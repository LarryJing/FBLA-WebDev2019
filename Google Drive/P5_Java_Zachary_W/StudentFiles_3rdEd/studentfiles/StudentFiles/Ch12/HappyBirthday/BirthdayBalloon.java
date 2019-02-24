import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

public class BirthdayBalloon extends RoundBalloon
{
  private final Font ageFont = new Font(Font.SANS_SERIF, Font.PLAIN, 20);
  private int age;
  
  public BirthdayBalloon()
  {
    age = 16;
  }

  public BirthdayBalloon(int x, int y, int r, Color c)
  {
    super(x, y, r, c);
    this.age = 16;
  }

  public BirthdayBalloon(int x, int y, int r, Color c, int age)
  {
    super(x, y, r, c);
    this.age = age;
  }

  public void draw(Graphics g, boolean makeItFilled)
  {
    g.setFont(ageFont);
    super.draw(g, makeItFilled);
    g.setColor(Color.BLACK);
    g.drawString("" + age, getX() - 10, getY());
  }
}

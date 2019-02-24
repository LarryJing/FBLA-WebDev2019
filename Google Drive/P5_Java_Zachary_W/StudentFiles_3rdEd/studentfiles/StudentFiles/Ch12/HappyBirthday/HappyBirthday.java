import java.awt.Graphics;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HappyBirthday extends JPanel
{
  private Balloon[] balloons;

  public HappyBirthday(int age)
  {
    balloons = new Balloon[3];
    balloons[0] = new BirthdayBalloon(100, 50, 30, Color.RED, age);
    balloons[1] = new RoundBalloon(130, 70, 20, Color.BLUE);
    balloons[2] = new RoundBalloon(65, 75, 20, Color.YELLOW);
  }  

  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);  // Call JPanel's paintComponent method
                              //  to paint the background
    for (Balloon b : balloons)
      b.draw(g, true);
  }

  public static void main(String[] args)
  {
    JFrame window = new JFrame("Happy Birthday");
    // Set this window's location and size:
    // upper-left corner at 300, 300; width 200, height 150
    window.setBounds(300, 300, 200, 150);

    HappyBirthday panel = new HappyBirthday(16);
    panel.setBackground(Color.WHITE);  // the default color is light gray
    Container c = window.getContentPane();
    c.add(panel);

    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setVisible(true);
  }
}


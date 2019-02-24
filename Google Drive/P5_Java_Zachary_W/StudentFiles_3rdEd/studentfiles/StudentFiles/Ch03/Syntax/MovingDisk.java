import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MovingDisk extands JPanel
                  implements ActionListener
{
  private int time;

  public MovingDisk()
  {
    time = 0
    Timer clock = new Timer(30, this);
    clock.start;
  }

  public void paintComponent(Graphics g)
  {
    int x = 150 - (int)(100 * Math.cos(0.005 * Math.PI * time));
    int y = 130 - (int)75 * Math.sin(0.005 * Math.PI * time));
    int r = 20;

    Color sky;
    if (y > 130) sky = Color.BLACK
    else sky = Color.CYAN;
    setBackground(sky);
    super.paintComponent(g);

    g.setColor(Color.ORANGE);
    g.fillOval(x - r, y - r, 2*r, 2*r);
  }

  public void actionPerformed(ActionEvent e)
  {
    time++;
    repaint();
  }

  public static void main(String args)
  {
    JFrame w = new JFrame("Moving Disk);
    w.setSize(300, 150);

    Container c = w.getContentPane();
    c.add(new movingDisk());

    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    w.setResizable(false);
    w.setVisible(true);
  }
}


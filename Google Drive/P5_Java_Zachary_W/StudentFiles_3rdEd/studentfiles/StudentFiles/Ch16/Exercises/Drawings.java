import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawings extends JPanel
{
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    int w = getWidth();
    int h = getHeight();
    g.setColor(Color.RED);
    g.drawRect(w/4, h/4, w/2, h/2);
  }

  public static void main(String[] args)
  {
    JFrame window = new JFrame("Drawings");
    window.setBounds(100, 100, 300, 200);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel canvas = new Drawings();
    canvas.setBackground(Color.WHITE);
    window.getContentPane().add(canvas);
    window.setVisible(true);
  }
}


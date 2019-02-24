import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Shuffler extends JFrame
{
  public Shuffler()
  {
    super("Shuffler");
    TextPanel canvas = new TextPanel();
    setJMenuBar(new ShufflerMenu(canvas));
    ControlPanel controls = new ControlPanel(canvas);
    Container c = getContentPane();
    c.add(canvas, BorderLayout.CENTER);
    c.add(controls, BorderLayout.SOUTH);
  }

  public static void main(String[] args)
  {
    Shuffler window = new Shuffler();
    window.setBounds(100, 100, 640, 480);
    window.setResizable(false);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setVisible(true);
  }
}

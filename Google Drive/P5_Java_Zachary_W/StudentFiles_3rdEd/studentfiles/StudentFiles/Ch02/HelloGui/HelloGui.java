// This program displays a label "Hello, GUI!"

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelloGui extends JFrame
{
  public HelloGui()   // Constructor
  {
    super("GUI Demo");    // Set the title bar
    Container c = getContentPane();
    c.setBackground(Color.CYAN);
    c.setLayout(new FlowLayout());
    c.add(new JLabel(" Hello, GUI!", 10));
  }

  public static void main(String[] args)
  {
    HelloGui window = new HelloGui();

    // Set this window's location and size:
    // upper-left corner at 300, 300; width 200, height 100
    window.setBounds(300, 300, 200, 100);

    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setVisible(true);
  }
}

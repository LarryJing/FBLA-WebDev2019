/**
 * This drawing program helps create pictures with several
 * balloons (colored disks or other shapes)
 * Authors: Maria Litvin and Gary Litvin
 */

import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.JFrame;

public class BalloonDraw extends JFrame
{
  public BalloonDraw()  // constructor
  {
    super("Drawing Editor");

    DrawingPanel canvas = new DrawingPanel();
    ControlPanel controls = new ControlPanel(canvas);
    Container c = getContentPane();
    c.add(canvas, BorderLayout.CENTER);
    c.add(controls, BorderLayout.SOUTH);
  }

  public static void main(String[] args)
  {
    BalloonDraw window = new BalloonDraw();
    window.setBounds(100, 100, 400, 400);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setVisible(true);
  }
}

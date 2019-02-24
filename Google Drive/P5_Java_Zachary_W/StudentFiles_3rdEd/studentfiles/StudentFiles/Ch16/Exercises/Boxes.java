// Chapter 16 Question 5

import java.awt.Color;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

public class Boxes extends JFrame
    implements ActionListener
{
  private BoxDrawer canvas;
  private JComboBox<String> colorList;
  // Starting with Java 7, JComboBox is type-specific. In
  // earlier versions, use
  // private JComboBox colorList;
  
  private JCheckBox filled, rounded, threeD;

  private static String colorNames[] =
    {" red", " orange", " yellow",
     " green", " blue", " cyan", " magenta",
     " gray", " light gray", " dark gray", " pink", " black", " white"};

  private static Color colorValues[] =
    {Color.RED, Color.ORANGE, Color.YELLOW,
     Color.GREEN, Color.BLUE, Color.CYAN, Color.MAGENTA,
     Color.GRAY, Color.LIGHT_GRAY, Color.DARK_GRAY, Color.PINK, Color.BLACK, Color.WHITE};

  public Boxes()
  {
    super("Boxes");
    colorList = new JComboBox<String>(colorNames);
    // In Java 6 or earlier:
    // colorList = new JComboBox(colorNames);
    
    colorList.addActionListener(this);

    filled = new JCheckBox("Filled");
    filled.addActionListener(this);
    rounded = new JCheckBox("Rounded");
    rounded.addActionListener(this);
    threeD = new JCheckBox("3D");
    threeD.addActionListener(this);

    JPanel controls = new JPanel();
    controls.add(colorList);
    controls.add(filled);
    controls.add(rounded);
    controls.add(threeD);

    canvas = new BoxDrawer();

    Container c = getContentPane();
    c.add(controls, BorderLayout.SOUTH);
    c.add(canvas, BorderLayout.CENTER);

    Color color = colorValues[colorList.getSelectedIndex()];
    canvas.setBoxColor(color);

    canvas.setBoxType(0);
  }

  public void actionPerformed(ActionEvent e)
  {
    Color color = colorValues[colorList.getSelectedIndex()];
    canvas.setBoxColor(color);

    int type = 0;
    if (filled.isSelected())
      type += 1;
    if (rounded.isSelected())
      type += 2;
    if (threeD.isSelected())
      type += 4;
    canvas.setBoxType(type);

    canvas.repaint();
  }

  public static void main(String[] args)
  {
    Boxes window = new Boxes();
    window.setBounds(100, 100, 400, 240);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    window.setVisible(true);
  }
}


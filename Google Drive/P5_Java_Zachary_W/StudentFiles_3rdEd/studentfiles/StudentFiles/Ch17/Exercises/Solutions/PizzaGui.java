// Chapter 17 Question 7

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.Box;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class PizzaGui extends JFrame
{
  public PizzaGui()
  {
    CompoundBorder border = new CompoundBorder(
        new EmptyBorder(6, 6, 6, 6),     // 6 pixels on top, left, bottom, right
        new LineBorder(Color.black, 1)); // outside, 1 pixel thick

    JRadioButton small = new JRadioButton("Small");
    JRadioButton medium = new JRadioButton("Medium");
    JRadioButton large = new JRadioButton("Large", true);

    ButtonGroup gr = new ButtonGroup();
    gr.add(small);
    gr.add(medium);
    gr.add(large);

    JPanel sizes  = new JPanel();
    sizes.setBorder(border);
    sizes.setLayout(new GridLayout(3, 1, 10, 10));
    sizes.add(small);
    sizes.add(medium);
    sizes.add(large);

    JCheckBox cheese = new JCheckBox("Extra cheese");
    JCheckBox mushrooms = new JCheckBox("Mushrooms");
    JCheckBox pepperoni = new JCheckBox("Pepperoni");

    JPanel toppings  = new JPanel();
    toppings.setBorder(border);
    toppings.setLayout(new GridLayout(3, 1, 10, 10));
    toppings.add(cheese);
    toppings.add(mushrooms);
    toppings.add(pepperoni);

    Box hbox = Box.createHorizontalBox();
    hbox.add(Box.createHorizontalStrut(10));
    hbox.add(sizes);
    hbox.add(Box.createHorizontalStrut(10));
    hbox.add(toppings);
    hbox.add(Box.createHorizontalStrut(10));

    hbox.add(new JToggleButton("To go", false));
    hbox.add(Box.createHorizontalStrut(10));

    Container c = getContentPane();
    c.add(hbox, BorderLayout.CENTER);
  }

  public static void main(String[] args)
  {
    PizzaGui window = new PizzaGui();
    window.setBounds(100, 100, 320, 150);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    window.setResizable(false);
    window.setVisible(true);
  }
}


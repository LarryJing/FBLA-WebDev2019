// This class implements a Celsius-Fahrenheit converter

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class Temperature extends JFrame
  implements ActionListener
{
  private JTextField displayF, displayC;

  // Constructor
  public Temperature()
  {
    Container c = getContentPane();
    c.setLayout(new GridLayout(2, 2, 10, 0));

    c.add(new JLabel("  Fahrenheit:"));
    c.add(new JLabel("  Celsius:"));

    displayF = new JTextField(6);
    displayF.setBackground(Color.YELLOW);
    displayF.addActionListener(this);
    c.add(displayF);

    displayC = new JTextField(6);
    displayC.setBackground(Color.YELLOW);
    displayC.addActionListener(this);
    c.add(displayC);
 }

  // Invoked when <Enter> is pressed
  public void actionPerformed(ActionEvent e)
  {
    FCConverter fc = new FCConverter();

    if ((JTextField)e.getSource() == displayF)
    {
      // Fahrenheit to Celsius
      double degrees = stringToDouble(displayF.getText());
      if (!Double.isNaN(degrees))
      {
        fc.setFahrenheit(degrees);
        degrees = fc.getCelsius();
        displayC.setText(String.format("%1.1f", degrees));
      }
      else
      {
        displayF.selectAll();
      }
    }
    else
    {
      // Celsius to Fahrenheit
      double degrees = stringToDouble(displayC.getText());
      if (!Double.isNaN(degrees))
      {
        fc.setCelsius(degrees);
        degrees = fc.getFahrenheit();
        displayF.setText(String.format("%1.1f", degrees));
      }
      else
      {
        displayC.selectAll();
      }
    }
  }

  // Extracts a double value from a string
  private double stringToDouble(String s)
  {
    double degrees;
    try
    {
      degrees = Double.parseDouble(s);
    }
    catch (NumberFormatException ex)
    {
      JOptionPane.showMessageDialog(null,
        "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
      degrees = Double.NaN;
    }
    return degrees;
  }

  //**********************************************************************

  public static void main(String[] args)
  {
    Temperature window = new Temperature();
    window.setBounds(300, 300, 200, 80);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    window.setVisible(true);
  }
}

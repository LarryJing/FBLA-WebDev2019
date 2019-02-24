import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class Wages extends JFrame
    implements ActionListener
{
  private JTextField inputHours, inputRate, display;
  private DecimalFormat money = new DecimalFormat("$0.00");

  public Wages()
  {
    super("Wages Calculator");

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(3,2));

    panel.add(new JLabel("   Hours worked:"));
    inputHours = new JTextField(5);
    inputHours.setHorizontalAlignment(JTextField.RIGHT);
    panel.add(inputHours);

    panel.add(new JLabel("   Hourly rate:"));
    inputRate = new JTextField(5);
    inputRate.setHorizontalAlignment(JTextField.RIGHT);
    panel.add(inputRate);

    panel.add(new JLabel("   Total wages:"));
    display = new JTextField(20);
    display.setHorizontalAlignment(JTextField.RIGHT);
    display.setEditable(false);
    display.setBackground(Color.yellow);
    panel.add(display);

    JButton calc = new JButton("Calculate wages");
    calc.addActionListener(this);

    Container c = getContentPane();
    c.add(panel, BorderLayout.CENTER);
    c.add(calc, BorderLayout.SOUTH);
  }

  public double totalWages(double hours, double rate)
  {
    double wages;

    _________________________
    ...

    return wages;
  }

  public void actionPerformed(ActionEvent e)
  {
    String s = inputHours.getText();
    double hours = Double.parseDouble(s);
    s = inputRate.getText();
    double rate = Double.parseDouble(s);
    double wages = totalWages(hours, rate);
    display.setText(money.format(wages));
  }

  public static void main(String[] args)
  {
    Wages window = new Wages();
    window.setBounds(300, 300, 200, 150);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    window.setVisible(true);
  }
}


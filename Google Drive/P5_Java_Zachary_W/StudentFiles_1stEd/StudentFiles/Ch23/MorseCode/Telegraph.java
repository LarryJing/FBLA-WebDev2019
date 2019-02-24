// The main class from the telegraph project.
// Opens two windows on the screen and starts morse
// code exchange between them

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Telegraph extends JFrame
    implements ActionListener
{
  private Telegraph otherStation;

  private JTextField inputText;
  private JTextArea codedText;
  private JTextField receivedText;

  private static final Font courier16 = new Font("Monospaced", Font.PLAIN, 16);

  public Telegraph(String name)
  {
    super(name);

    inputText = new JTextField("Enter a message", 30);
    inputText.setFont(courier16);
    inputText.selectAll();
    inputText.addActionListener(this);
    
    codedText = new JTextArea(4, 30);
    codedText.setEditable(false);
    codedText.setLineWrap(true);
    codedText.setFont(courier16);

    receivedText = new JTextField(30);
    receivedText.setBackground(Color.yellow);
    receivedText.setEditable(false);
    receivedText.setFont(courier16);
    
    Container c = getContentPane();
    c.setLayout(new FlowLayout(FlowLayout.LEFT));
    c.add(inputText);
    c.add(codedText);
    c.add(receivedText);
  }

  public void connect(Telegraph other)
  {
    otherStation = other;
  }

  public void send(String message)
  {
    inputText.setText("");
    receivedText.setText("");
    String code = MorseCode.encode(message);
    codedText.setText("[" + code + "] >>>");
    otherStation.receive(code);
  }

  public void receive(String code)
  {
    codedText.setText(">>> [" + code + "]");
    String message = MorseCode.decode(code);
    receivedText.setText(message);
  }

  public void actionPerformed(ActionEvent e)
  {
    send(inputText.getText());
  }

  /******************************************************************/
  /***************                        main       ****************/
  /******************************************************************/

  public static void main(String[] args)
  {

    Telegraph new_york = new Telegraph("New York");
    new_york.setBounds(50, 150, 300, 200);
    new_york.setDefaultCloseOperation(EXIT_ON_CLOSE);

    Telegraph london = new Telegraph("London");
    london.setBounds(400, 300, 300, 200);
    london.setDefaultCloseOperation(EXIT_ON_CLOSE);

    london.connect(new_york);
    new_york.connect(london);
    MorseCode.start();

    new_york.setVisible(true);
    london.setVisible(true);
  }
}

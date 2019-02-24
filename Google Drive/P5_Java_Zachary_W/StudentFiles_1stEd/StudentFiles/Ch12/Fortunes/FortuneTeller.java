// This is the Fortune Teller applet

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.AudioClip;

public class FortuneTeller extends JApplet
    implements ActionListener
{
  // Declare an array of "fortunes" (strings):
  ___________________________________________
  ...

  private JTextField display;
  private AudioClip ding;

  public void init()
  {
    ding = getAudioClip(getDocumentBase(), "ding.wav");

    display = new JTextField("  Press \"Next\" to see your fortune...", 30);
    display.setBackground(Color.WHITE);
    display.setEditable(false);

    JButton go = new JButton("Next");
    go.addActionListener(this);

    Container c = getContentPane();
    c.setLayout(new FlowLayout());
    c.add(display);
    c.add(go);
  }

  public void actionPerformed(ActionEvent e)
  {
    ding.play();

    // Pick a random fortune:
    ___________________________________________
    ...
    display.setText("  " + ... );
  }
}


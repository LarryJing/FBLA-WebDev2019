/**
 * Cryptogram Solver
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.Box;

public class Cryptogram extends JFrame
{
  private static final String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private static String lettersByFrequency = "JQXZKBVWFUYMPGCLSDHROANITE";

  private JTextField[] subFields = new JTextField[letters.length()];
  private JLabel[] hintLabels = new JLabel[letters.length()];
  private JTextArea textAreaIn, textAreaOut;

  private Enigma enigma;

  public Cryptogram()
  {
    super("Cryptogram Solver");

    setJMenuBar(new CryptogramMenu(this, new DecodeAction()));

    JPanel p1 = new JPanel();
    p1.setPreferredSize(new Dimension(100, 81));
    p1.setLayout(new GridLayout(3, 1, 3, 3));
    p1.add(new JLabel("Code letter:", JLabel.RIGHT));
    p1.add(new JLabel("Stands for:", JLabel.RIGHT));
    p1.add(new JLabel("Computer hints:", JLabel.RIGHT));

    JPanel p2 = new JPanel();
    p2.setPreferredSize(new Dimension(569, 81));
    p2.setLayout(new GridLayout(3, 26, 3, 3));
    for (int k = 0; k < letters.length(); k++)
    {
      p2.add(new JLabel(letters.substring(k, k+1), JLabel.CENTER));
    }

    for (int k = 0; k < letters.length(); k++)
    {
      JTextField tf = new JTextField();
      tf.setBackground(Color.yellow);
      tf.setHorizontalAlignment(JTextField.CENTER);
      p2.add(tf);
      subFields[k] = tf;
    }

    for (int k = 0; k < letters.length(); k++)
    {
      hintLabels[k] = new JLabel(" ", JLabel.CENTER);
      p2.add(hintLabels[k]);
    }

    JPanel p3 = new JPanel();
    p3.setPreferredSize(new Dimension(80, 81));
    p3.setLayout(new GridLayout(3, 1, 3, 3));
    p3.add(new JPanel());   // filler
    JButton refresh = new JButton("Refresh");
    refresh.addActionListener(new DecodeAction());
    p3.add(refresh);

    Box b1 = Box.createHorizontalBox();
    b1.add(p1);
    b1.add(Box.createHorizontalStrut(10));
    b1.add(p2);
    b1.add(Box.createHorizontalStrut(10));
    b1.add(p3);

    JPanel p123 = new JPanel();
    p123.add(b1);

    Font font = new Font("Monospaced", Font.PLAIN, 12);

    textAreaIn = new JTextArea(20, 30);
    textAreaIn.setFont(font);
    textAreaIn.setLineWrap(true);
    textAreaIn.setWrapStyleWord(true);
    JScrollPane areaScrollPaneIn = new JScrollPane(textAreaIn);
    areaScrollPaneIn.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

    textAreaOut = new JTextArea(20, 30);
    textAreaOut.setFont(font);
    textAreaOut.setLineWrap(true);
    textAreaOut.setWrapStyleWord(true);
    textAreaOut.setEditable(false);
    JScrollPane areaScrollPaneOut = new JScrollPane(textAreaOut);
    areaScrollPaneOut.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

    Box b2 = Box.createHorizontalBox();
    b2.add(areaScrollPaneIn);
    b2.add(Box.createHorizontalStrut(10));
    b2.add(areaScrollPaneOut);

    Container c = getContentPane();
    c.add(p123, BorderLayout.NORTH);
    c.add(b2, BorderLayout.CENTER);

    enigma = new Enigma(letters.length());
    clearSubs();
  }

  private void clearSubs()
  {
    for (int k = 0; k < letters.length(); k++)
    {
      subFields[k].setText("-");
      enigma.setSubstitution(k, '-');
    }
  }

  private void normalSubs()
  {
    for (int k = 0; k < letters.length(); k++)
    {
      JTextField tf = subFields[k];
      String s = tf.getText();
      char ch;
      if (s.length() < 1)
        ch = '-';
      else
      {
        ch = Character.toUpperCase(s.charAt(0));
        if (!Character.isLetter(ch))
          ch = '-';
      }
      tf.setText(ch + "");
      enigma.setSubstitution(k, ch);
    }
  }

  private void randomSubs()
  {
    char[] subs = letters.toCharArray();

    for (int n = subs.length; n > 1; n--)
    {
      int k = (int)(n * Math.random());
      char ch = subs[k];
      subs[k] = subs[n-1];
      subs[n-1] = ch;
    }

    for (int k = 0; k < letters.length(); k++)
    {
      subFields[k].setText(subs[k] + "");
      enigma.setSubstitution(k, subs[k]);
    }
  }

  public void setHints(String text)
  {
    String hints = enigma.getHints(text, lettersByFrequency);
    for (int k = 0; k < letters.length(); k++)
    {
      hintLabels[k].setText(hints.substring(k, k+1));
    }
  }

  public String getTextIn()
  {
    return textAreaIn.getText();
  }

  public String getTextOut()
  {
    return textAreaOut.getText();
  }

  public void setTextIn(String text)
  {
    textAreaIn.setText(text);
    textAreaIn.setCaretPosition(0);
  }

  public void setTextOut(String text)
  {
    textAreaOut.setText(enigma.decode(text));
    textAreaOut.setCaretPosition(0);
  }

  private class DecodeAction implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      String cmd = ((AbstractButton)e.getSource()).getActionCommand();

      if ("Refresh".equals(cmd) || "Decode".equals(cmd))
      {
        normalSubs();
      }
      else if ("Clear".equals(cmd))
      {
        clearSubs();
      }
      else if ("Encode".equals(cmd))
      {
        randomSubs();
      }
      setTextOut(getTextIn());
    }
  }

  /******************************************************************/
  /***************                  main             ****************/
  /******************************************************************/

  public static void main(String[] args)
  {
    Cryptogram window = new Cryptogram();
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    window.setBounds(30, 30, 800, 600);
    window.setVisible(true);
  }
}

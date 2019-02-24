/**
 * Display of the Goofenspeil game
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Box;

public class GoofenspielView extends JPanel
{
  private final int numCards;
  private JTextField computerTricks, humanTricks, computerWins, humanWins, ties;
  private PlayingCard[] computerCards, humanCards;

  private static String spadesNames[] =
    {
      "2-spades.gif", "3-spades.gif", "4-spades.gif", "5-spades.gif", "6-spades.gif", "7-spades.gif", "8-spades.gif",
      "9-spades.gif", "10-spades.gif", "Jack-spades.gif", "Queen-spades.gif", "King-spades.gif", "Ace-spades.gif"
    };

  private static String heartsNames[] =
    {
      "2-hearts.gif", "3-hearts.gif", "4-hearts.gif", "5-hearts.gif", "6-hearts.gif", "7-hearts.gif", "8-hearts.gif",
      "9-hearts.gif", "10-hearts.gif", "Jack-hearts.gif", "Queen-hearts.gif", "King-hearts.gif", "Ace-hearts.gif"
    };

  public GoofenspielView(int numCards, Goofenspiel controller)
  {
    this.numCards = numCards;

    JPanel computerPanel = new JPanel();
    computerPanel.setLayout(new GridLayout(1, numCards));
    JPanel humanPanel = new JPanel();
    humanPanel.setLayout(new GridLayout(1, numCards));

    computerCards = new PlayingCard[numCards];
    humanCards = new PlayingCard[numCards];

    for (int k = 0; k < numCards; k++)
    {
      computerCards[k] = new PlayingCard("cards/" + spadesNames[k], k + 1, null);
      computerPanel.add(computerCards[k]);

      humanCards[k] = new PlayingCard("cards/" + heartsNames[k], k + 1, controller);
      humanPanel.add(humanCards[k]);
    }

    Font font1 = new Font("SansSerif", Font.BOLD, 24);
    Font font2 = new Font("SansSerif", Font.PLAIN, 20);

    computerTricks = new JTextField(5);
    computerTricks.setBackground(Color.yellow);
    computerTricks.setEditable(false);
    computerTricks.setHorizontalAlignment(JTextField.RIGHT);
    computerTricks.setFont(font2);

    humanTricks = new JTextField(5);
    humanTricks.setBackground(Color.yellow);
    humanTricks.setEditable(false);
    humanTricks.setHorizontalAlignment(JTextField.RIGHT);
    humanTricks.setFont(font2);

    computerWins = new JTextField(5);
    computerWins.setBackground(Color.yellow);
    computerWins.setEditable(false);
    computerWins.setHorizontalAlignment(JTextField.RIGHT);
    computerWins.setFont(font2);

    humanWins = new JTextField(5);
    humanWins.setBackground(Color.yellow);
    humanWins.setEditable(false);
    humanWins.setHorizontalAlignment(JTextField.RIGHT);
    humanWins.setFont(font2);

    ties = new JTextField(5);
    ties.setBackground(Color.yellow);
    ties.setEditable(false);
    ties.setHorizontalAlignment(JTextField.RIGHT);
    ties.setFont(font2);

    JPanel display = new JPanel();
    display.setLayout(new GridLayout(6, 1));
    JPanel p = new JPanel();

    JLabel label = new JLabel("Tricks");
    label.setFont(font1);
    p.add(label);
    display.add(p);
    p = new JPanel();
    label = new JLabel("Computer");
    label.setFont(font2);
    p.add(label);
    label = new JLabel("  Guest  ");
    label.setFont(font2);
    p.add(label);
    display.add(p);
    p = new JPanel();
    p.add(computerTricks);
    p.add(humanTricks);
    display.add(p);
    p = new JPanel();
    label = new JLabel("Score");
    label.setFont(font1);
    p.add(label);
    display.add(p);
    p = new JPanel();
    label = new JLabel("Computer");
    label.setFont(font2);
    p.add(label);
    label = new JLabel("  Guest  ");
    label.setFont(font2);
    p.add(label);
    label = new JLabel("  Tie  ");
    label.setFont(font2);
    p.add(label);
    display.add(p);
    p = new JPanel();
    p.add(computerWins);
    p.add(humanWins);
    p.add(ties);
    display.add(p);

    Box vb = Box.createVerticalBox();
    vb.add(Box.createVerticalStrut(5));
    vb.add(computerPanel);
    vb.add(Box.createVerticalStrut(10));
    vb.add(display);
    vb.add(Box.createVerticalStrut(10));
    vb.add(humanPanel);

    add(vb);
  }

  public void update(GoofenspielModel model)
  {
    int computerHand[] = model.getComputerHand();
    int humanHand[] = model.getHumanHand();

    for (int k = 0; k < numCards; k++)
    {
      computerCards[k].setActive(computerHand[k] > 0);
      humanCards[k].setActive(humanHand[k] > 0);
    }

    computerTricks.setText(model.getComputerTricks() + "  ");
    humanTricks.setText(model.getHumanTricks() + "  ");
    computerWins.setText(model.getComputerWins() + "  ");
    humanWins.setText(model.getHumanWins() + "  ");
    ties.setText(model.getTies() + "  ");

    repaint();
  }
}
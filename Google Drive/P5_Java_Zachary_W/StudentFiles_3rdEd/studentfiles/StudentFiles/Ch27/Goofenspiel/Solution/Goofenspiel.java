/**
 * This is the main class for Goofenspeil, also serves as a controller
 */

import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

public class Goofenspiel extends JFrame
    implements MouseListener
{
  private final int numCards;

  private GoofenspielStrategy[] strategies;
  private int currentStrategy;
  private GoofenspielModel model;

  public Goofenspiel(int numCards)
  {
    super("Goofenspiel");
    this.numCards = numCards;

    strategies = new GoofenspielStrategy[]
         {new GoofenspielRandomStrategy(), new GoofenspielMinMaxStrategy()};
    currentStrategy = 0;

    GoofenspielView view = new GoofenspielView(this.numCards, this);
    model = new GoofenspielModel(numCards, view);
    model.setStrategy(strategies[currentStrategy]);

    Container c = getContentPane();
    c.add(view, BorderLayout.CENTER);
  }

  public void mouseReleased(MouseEvent e)
  {
    PlayingCard card = (PlayingCard)e.getSource();
    if (!card.isActive())
      return;

    model.nextMove(card.getRank() - 1);

    if (model.isNewGame() && model.getWinsInARow() >= 2)
    {
      model.resetWinsInARow();
      currentStrategy = (currentStrategy + 1) % strategies.length;
      model.setStrategy(strategies[currentStrategy]);
    }
  }
  public void mousePressed(MouseEvent e) {}
  public void mouseClicked(MouseEvent e) {}
  public void mouseEntered(MouseEvent e) {}
  public void mouseExited(MouseEvent e) {}

  public static void main(String[] args)
  {
    int numCards = 7;
    if (args.length > 0)
    {
      numCards = Integer.parseInt(args[0]);
      if (numCards > 13)
        numCards = 13;
    }

    Goofenspiel window = new Goofenspiel(numCards);
    window.setBounds(100, 100, 75 * numCards + 40, 520);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    //window.setResizable(true);
    window.setVisible(true);
  }
}
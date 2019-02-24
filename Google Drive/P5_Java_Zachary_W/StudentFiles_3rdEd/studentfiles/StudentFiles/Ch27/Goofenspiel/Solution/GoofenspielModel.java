/**
 * Model of the Goofenspeil game
 */
public class GoofenspielModel
{
  private final int numCards;
  private GoofenspielView view;
  private GoofenspielStrategy strategy;
  private int[] humanHand, computerHand;
  private int humanTricks, computerTricks;
  private int humanWins, computerWins, ties, winsInARow;
  private boolean newGame;

  public GoofenspielModel(int numCards, GoofenspielView view)
  {
    this.numCards = numCards;
    this.view = view;
    humanHand = new int[numCards];
    computerHand = new int[numCards];

    humanWins = 0;
    computerWins = 0;
    winsInARow = 0;

    startNewGame();
    view.update(this);
  }

  private void startNewGame()
  {
    for (int k = 0; k < numCards; k++)
    {
      humanHand[k] = k + 1;
      computerHand[k] = k + 1;
    }

    humanTricks = 0;
    computerTricks = 0;
    newGame = true;
  }

  private boolean gameOver()
  {
    for (int k = 0; k < numCards; k++)
      if (computerHand[k] > 0)
        return false;
    return true;
  }

  public void setStrategy (GoofenspielStrategy strategy)
  {
    this.strategy = strategy;
  }

  public int[] getComputerHand()
  {
    return computerHand;
  }

  public int[] getHumanHand()
  {
    return humanHand;
  }

  public int getComputerTricks()
  {
    return computerTricks;
  }

  public int getHumanTricks()
  {
    return humanTricks;
  }

  public int getComputerWins()
  {
    return computerWins;
  }

  public int getHumanWins()
  {
    return humanWins;
  }

  public int getTies()
  {
    return ties;
  }

  public int getWinsInARow()
  {
    return winsInARow;
  }

  public void resetWinsInARow()
  {
    winsInARow = 0;
  }

  public boolean isNewGame()
  {
    return newGame;
  }

  public void nextMove(int k)
  {
    if (strategy == null)
      return;

    newGame = false;

    if (k < 0 || k >= numCards || humanHand[k] == 0)
      return;
    humanHand[k] = 0;

    int computerCard = strategy.getMove(computerHand);
    computerHand[computerCard] = 0;

    if (k < computerCard)
      computerTricks++;
    else if (k > computerCard)
      humanTricks++;

    if (gameOver())
    {
      if (computerTricks > humanTricks)
      {
        computerWins++;
        winsInARow = 0;
      }

      else if (computerTricks < humanTricks)
      {
        humanWins++;
        winsInARow++;
      }
      else
        ties++;

      startNewGame();
    }

    view.update(this);
  }
}
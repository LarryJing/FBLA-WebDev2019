public class GoofenspielMinMaxStrategy
      implements GoofenspielStrategy
{
  // Picks the smallest or the largest unused card
  // with equal probablility.
  public int getMove(int[] hand)
  {
    int k;

    if (Math.random() < 0.5)
    {
      k = 0;
      while (hand[k] == 0)
        k++;
    }
    else
    {
      k = hand.length - 1;
      while (hand[k] == 0)
        k--;
    }

    return k;
  }
}
public class GoofenspielRandomStrategy
      implements GoofenspielStrategy
{
  // Picks any unused card randomly with equal probablility.
  public int getMove(int[] hand)
  {
    int k = 0, count = 0;

    for (int kk = 0; kk < hand.length; kk++)
    {
      if (hand[kk] > 0)
      {
        count++;
        if (Math.random() < 1.0/count)
          k = kk;
      }
    }

    return k;    
  }
}
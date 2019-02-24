import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class HanoiTowerModel
{
  private int nDisks;
  private LinkedList<Integer>[] pegList;
  private int fromPeg, toPeg;
  private Queue<Move> solutionMoves;

  HanoiTowerModel(int n)
  {
    nDisks = n;
    pegList = new LinkedList[3];
    for (int peg = 0; peg < 3; peg++)
      pegList[peg] = new LinkedList<Integer>();

    for (int k = 1; k <= n; k++)
      pegList[0].add(new Integer(k));
    fromPeg = 0;
    toPeg = 1;
    solutionMoves = new LinkedList<Move>();
    solve(fromPeg, toPeg, nDisks, solutionMoves);
  }

  public void makeMove()
  {
    if (solutionMoves.isEmpty())
    {
      int temp = fromPeg;
      fromPeg = toPeg;
      toPeg = temp;
      solve(fromPeg, toPeg, nDisks, solutionMoves);
    }

    Move m = solutionMoves.remove();
    Integer k = pegList[m.from].removeLast();
    pegList[m.to].add(k);
  }

  public List<Integer> getPeg(int peg)
  {
    return pegList[peg];
  }

  private void solve(int fromPeg, int toPeg, int n, Queue<Move> solutionMoves)
  {
    if (n > 1)
    {
      int sparePeg = 3 - fromPeg - toPeg;
      solve(fromPeg, sparePeg, n-1, solutionMoves);
      solutionMoves.add(new Move(fromPeg, toPeg));
      solve(sparePeg, toPeg, n-1, solutionMoves);
    }
    else
    {
      solutionMoves.add(new Move(fromPeg, toPeg));
    }
  }

  private class Move
  {
    public int from;
    public int to;

    public Move(int from, int to)
    {
      this.from = from;
      this.to = to;
    }
  }
}
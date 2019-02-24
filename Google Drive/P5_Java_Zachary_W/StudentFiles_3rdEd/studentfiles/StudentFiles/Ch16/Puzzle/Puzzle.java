/**
 * This program is a click-and-move puzzle
 */

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Puzzle extends JFrame
    implements ActionListener, MouseListener
{
  private EasySound bells, drop, bzz;
  private PuzzleCell[] cells;
  private int pickedIndex = -1;

  public Puzzle()
  {
    super("Puzzle");
    bells = new EasySound("bells.wav");
    drop = new EasySound("drop.wav");
    bzz = new EasySound("bzz.wav");

    Container c = getContentPane();
    c.setLayout(new GridLayout(4, 3, 1, 1)); // 4 by 3; horz gap 1, vert gap 1

    cells = new PuzzleCell[10];

    for (int i = 1; i <= 9; i++)
    {
      cells[i] = new PuzzleCell(i);
      c.add(cells[i]);
    }
    c.add (new JPanel()); // must put something in row 4 col 1
    cells[0] = new PuzzleCell(0);
    c.add(cells[0]);      // put empty cell in row 4 col 2

    addMouseListener(this);

    Timer t = new Timer(2000, this);  // delay 2 seconds
    t.setRepeats(false);        // Send only one event, then stop
    t.start();
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
  }

  // ActionListener (for the timer)
  public void actionPerformed(ActionEvent e)
  {
    bells.play();

    // Scramble the puzzle by setting shuffled numbers 1 through 9
    //   to the puzzle cells:
    int numbers[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    shuffle(numbers);
    for (int i = 1; i <= 9; i++)
    {
      int k = numbers[i-1];
      cells[i].setPieceNumber(k);
    }

    setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    repaint();
  }

  private void shuffle(int a[])
  {
    ___________________________________
    ...
  }

  /**
   * Sets the index of the cell from which the piece was "picked."
   * i is the number of the clicked cell
   */
  private void pickPiece(int i)
  {
    if (cells[i].getPieceNumber() != 0) // pick only from 
    {                                   //    a non-empty cell
      pickedIndex = i;
      cells[i].setPicked(true);
      cells[i].repaint();
    }
    else
    {
      bzz.play();
    }
  }

  /**
   * "Moves" the picked piece into the clicked empty cell.
   * i is the number of the clicked cell that has to be empty.
   */
  private void dropPiece(int i)
  {
    if (cells[i].getPieceNumber() == 0) // drop only into an empty cell
    {
      // Set the empty cell's number to the picked piece
      int k = cells[pickedIndex].getPieceNumber();
      cells[i].setPieceNumber(k);
      cells[i].repaint();

      // Set the piece number for the source cell to "empty"
      cells[pickedIndex].setPieceNumber(0);
      cells[pickedIndex].setPicked(false);
      cells[pickedIndex].repaint();

      pickedIndex = -1;    // nothing picked now
      if (allSet())
        bells.play();
      else
        drop.play();
    }
    else
    {
      bzz.play();
    }
  }

  /**
   * Returns true if all puzzle pieces are in their original places, and
   * false otherwise
   */
  private boolean allSet()
  {
    ___________________________________
    ...
  }

  // MouseListener implementation:
  public void mousePressed(MouseEvent e)
  {
    int x = e.getX();
    int y = e.getY();

    // Figure out the index of the cell that was clicked:
    int col= 3 * x / getWidth();
    int row = 4 * y / getHeight();
    int i = 3 * row + col;
    if (i >= 0 && i < 9)
      i++;
    else if (i == 10)
      i = 0;
    else
      return;

    if (pickedIndex < 0)
      pickPiece(i);
    else
      dropPiece(i);
  }

  // Not used:
  public void mouseClicked(MouseEvent e) { }
  public void mouseReleased(MouseEvent e) { }
  public void mouseEntered(MouseEvent e) { }
  public void mouseExited(MouseEvent e) { }

  public static void main(String[] args)
  {
    Puzzle window = new Puzzle();
    window.setBounds(100, 100, 300, 400);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    window.setVisible(true);
  }
}


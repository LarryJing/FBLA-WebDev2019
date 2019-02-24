import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HanoiTower extends JFrame
    implements ActionListener
{
  private HanoiTowerView view;

  public HanoiTower(int nDisks)
  {
    super("The Tower of Hanoi");

    JButton go = new JButton("Move next disk");
    go.addActionListener(this);

    view = new HanoiTowerView(nDisks);
    view.setBackground(Color.WHITE);

    Container c = getContentPane();
    c.add(view, BorderLayout.CENTER);
    c.add(go, BorderLayout.SOUTH);
  }

  /**
   *  Handles input events: called when user presses <Enter>
   */
  public void actionPerformed(ActionEvent e)
  {
    view.makeMove();
  }

  /******************************************************************/
  /***************                        main       ****************/
  /******************************************************************/

  public static void main(String[] args)
  {
    int nDisks = 5;
    if (args.length > 0)
      nDisks = Integer.parseInt(args[0]);

    HanoiTower window = new HanoiTower(nDisks);
    window.setBounds(20, 20, 720, 250);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    window.setResizable(true);
    window.setVisible(true);
  }
}
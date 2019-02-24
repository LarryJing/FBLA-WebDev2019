import java.awt.event.*;
import javax.swing.*;

// Represents a control panel for a craps "table"

public class ControlPanel extends JPanel
    implements ActionListener
{
  private CrapsTable table;

  // Constructor
  public ControlPanel(CrapsTable t)
  {
    table = t;
    JButton rollButton = new JButton("Roll");
    rollButton.addActionListener(this);
    add(rollButton);
  }

  // Called when the roll button is clicked
  public void actionPerformed(ActionEvent e)
  {
    if (!table.diceAreRolling())
      table.rollDice();
  }
}

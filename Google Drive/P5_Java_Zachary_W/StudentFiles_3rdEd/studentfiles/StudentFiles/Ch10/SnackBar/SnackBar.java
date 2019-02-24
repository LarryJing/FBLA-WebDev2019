/**
 * The SnackBar program models several "vending machines"
 */
 
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.Box;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

public class SnackBar extends JFrame
                      implements ActionListener
{
  private static final String MY_PASSWORD = "jinx";
  private VendingMachine[] machines;

  public SnackBar()
  {
    super("Snack Bar");

    // Load the coin icon for the vending machine buttons:
    ImageIcon coin = new ImageIcon("coin.gif");

    Color brandColor1 = new Color(130, 30, 10); // r, g, b
    Color brandColor2 = new Color(255, 180, 0);
    Color brandColor3 = new Color(90, 180, 0);

    VendingMachine[] machines =
    {
      new VendingMachine("Java", brandColor1, 45, coin),
      new VendingMachine("JApple", brandColor2, 50, coin),
      new VendingMachine("Jinx", brandColor3, 35, coin)
    };
    this.machines = machines;
    
    int w = machines.length * (200+5);
    int h = 310;
    setMinimumSize(new Dimension(w, h));

    Box wall = Box.createHorizontalBox();
    wall.add(Box.createHorizontalStrut(5));
    for (VendingMachine machine : machines)
    {
      wall.add(machine);
      wall.add(Box.createHorizontalStrut(5));
    }

    JPanel service = new JPanel();
    service.add(new JLabel(" Service login: "));
    JPasswordField password = new JPasswordField("", 5);
    password.addActionListener(this);
    service.add(password);

    Container c = getContentPane();
    c.setBackground(Color.GRAY);
    c.add(wall, BorderLayout.CENTER);
    c.add(service, BorderLayout.SOUTH);
  }

  /**
   * Password field: user strikes <Enter>
   */
  public void actionPerformed(ActionEvent e)
  {
    JPasswordField password = (JPasswordField)e.getSource();
    String word = new String(password.getPassword());
    password.setText("");
    if (MY_PASSWORD.equals(word))
    {
      for (VendingMachine machine : machines)
        machine.reload();
        
      JOptionPane.showMessageDialog(null,
        "Machines reloaded",
        "Service", JOptionPane.INFORMATION_MESSAGE);
    }
    else
    {
      JOptionPane.showMessageDialog(null,
        "Login failed", "Service", JOptionPane.ERROR_MESSAGE);
    }
  }

  // *****************************************************

  public static void main(String[] args)
  {
    SnackBar window = new SnackBar();
    window.setLocation(50, 50);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    window.setVisible(true);
  }
}


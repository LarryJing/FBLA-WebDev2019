import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.Box;

/**
 *  This is the main class for the Ramblecs game.
 *  See Help for the rules.
 */
public class Ramblecs extends JFrame
{
  private RamblecsMenu menuBar;
  private ControlPanel controlpanel;

  public Ramblecs()
  {
    super("Ramblecs");

    menuBar = new RamblecsMenu(this);
    setJMenuBar(menuBar);

    RamblecsDictionary dictionary = new RamblecsDictionary();
    LetterPanel whiteboard = new LetterPanel(this, dictionary);
    controlpanel = new ControlPanel(whiteboard);
    whiteboard.setScoreDisplay(controlpanel);
    controlpanel.addKeyListener(new
                  RamblecsKeyListener(whiteboard, controlpanel));

    Box box = Box.createHorizontalBox();
    box.add(whiteboard);
    box.add(controlpanel);
    getContentPane().add(box);

    newGame();
  }

  public void newGame()
  {
    controlpanel.newGame();
  }

  public boolean soundEnabled()
  {
    return menuBar.soundEnabled();
  }

  public static void main(String[] args)
  {
    // Set system look and feel:
    ______________________________
    ...
      
    Ramblecs window = new Ramblecs();
    window.setBounds(100, 100, 395, 355);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setVisible(true);
  }
}


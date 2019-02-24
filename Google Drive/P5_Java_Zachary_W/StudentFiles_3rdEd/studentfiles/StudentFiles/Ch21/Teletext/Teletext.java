/**
 * Teletext main clas. Displays a rolling list of headlines
 */
 
import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Teletext extends JFrame
{
  private static String[] headlines =
  {
    "Sun or rain expected today, dark tonight",
    "Soap and water still cleans well",
    "Malls try to attract shoppers",
    "Economist uses theory to explain economy",
    "Include your Children when Baking Cookies",
    "Old School Pillars are Replaced by Alumni",
    "Drunk Gets Nine Months in Violin Case",
    "Eye Drops off Shelf",
    "Squad Helps Dog Bite Victim"
  };

  public Teletext()
  {
    super("Headlines");
    setSize(600, 320);
    
    TeletextList msgList = new TeletextList(headlines);
    TeletextDisplay display = new TeletextDisplay(msgList);
    TeletextInput inputPanel = new TeletextInput(msgList);
    Container c = getContentPane();
    c.add(display, BorderLayout.CENTER);
    c.add(inputPanel, BorderLayout.SOUTH);

    Timer t = new Timer(100, display);
    t.start();
  }


  /******************************************************************/
  /***************                        main       ****************/
  /******************************************************************/

  public static void main(String[] args)
  {
    Teletext window = new Teletext();
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    window.setLocation(100, 100);
    window.setVisible(true);
  }
}

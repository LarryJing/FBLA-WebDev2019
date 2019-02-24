/**
 * The main class for the Three kittens program
 */

import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ThreeKittens extends JFrame
{
  private JTextArea display;

  public ThreeKittens()
  {
    display = new JTextArea("\n");
    display.setEditable(false);
    Container c = getContentPane();
    c.add(new JScrollPane(display), BorderLayout.CENTER);
  }

  public static void main(String[] args)
  {
    ThreeKittens window = new ThreeKittens();
    window.setLocation(400, 100);
    window.setSize(300, 600);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    window.setVisible(true);

    String[] kittysPossessions = {"right glove", "right glove", "right glove", "hat"};
    String[] tommysPossessions = {"left glove"};
    String[] lizzysPossessions = {"left glove", "left glove", "hat", "hat"};

    List<Kitten> Kittens = new ArrayList<Kitten>();
    Kittens.add(new Kitten("Kitty", Arrays.asList(kittysPossessions)));
    Kittens.add(new Kitten("Tommy", Arrays.asList(tommysPossessions)));
    Kittens.add(new Kitten("Lizzy", Arrays.asList(lizzysPossessions)));

    MailServer server = new MailServer();
    for (Kitten kitten : Kittens)
      kitten.addMailServer(server);

    while (true)
    {
      while (!server.isEmpty())
      {
        Message msg = server.remove();
        window.display.append(msg + "\n");
        server.dispatch(msg);
      }

      // Collections.shuffle(kittens);

      for (Kitten kitten : Kittens)
        kitten.readMail();
    }
  }
}

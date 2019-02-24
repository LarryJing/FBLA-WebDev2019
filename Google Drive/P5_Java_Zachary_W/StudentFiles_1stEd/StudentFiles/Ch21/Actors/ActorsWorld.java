import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.*;
import java.util.*;

public class ActorsWorld extends JFrame
{
  private JTextArea display;

  public ActorsWorld()
  {
    display = new JTextArea();
    display.setEditable(false);
    Container c = getContentPane();
    c.add(new JScrollPane(display), BorderLayout.CENTER);
  }

  public static void main(String[] args)
  {
    ActorsWorld window = new ActorsWorld();
    window.setSize(400, 300);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    window.setVisible(true);

    String[] kittysPossessions = {"right glove", "right glove", "right glove", "hat"};
    String[] tommysPossessions = {"left glove"};
    String[] lizzysPossessions = {"left glove", "left glove", "hat", "hat"};

    List<Actor> actors = new ArrayList<Actor>();
    actors.add(new Actor("Kitty", Arrays.asList(kittysPossessions)));
    actors.add(new Actor("Tommy", Arrays.asList(tommysPossessions)));
    actors.add(new Actor("Lizzy", Arrays.asList(lizzysPossessions)));

    MailServer email = new MailServer();
    for (Actor actor : actors)
      actor.addMailServer(email);

    window.display.append("The following exchanges took place:\n\n");

    while (true)
    {
      while (!email.isEmpty())
      {
        Message msg = email.remove();
        window.display.append(msg + "\n");
        email.dispatch(msg);
      }

      // Collections.shuffle(actors);

      for (Actor actor : actors)
        actor.readMail();
    }
  }
}

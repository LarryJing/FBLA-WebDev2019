import javax.swing.JFrame;

/**
 * The main class for the <i>Java Messenger</i> application.
 */
public class Messenger
{
  public static void main(String[] args)
  {
    Server server = new Server();
    server.addUser("vindog1981", "no");
    server.addUser("apscholar5", "no");
    server.addUser("python2015", "no");
    server.addUser("lucytexan", "no");

    LoginWindow window = new LoginWindow("Java Messanger", server);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setBounds(0, 0, 360, 140);
    window.setVisible(true);
  }
}

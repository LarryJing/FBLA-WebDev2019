/**
 * Broser main class
 */

import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import java.util.List;
import java.util.LinkedList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class LineCruiser extends JFrame
{
  public LineCruiser(List<String> textLines)
  {
    super("Line Cruiser");
    setSize(640, 400);
    
    JScrollBar scrollbar = new JScrollBar();
    BrowserView view = new BrowserView(scrollbar, textLines);
    BrowserModel model = new BrowserModel(view);
    BrowserControlPanel controlPanel = new BrowserControlPanel(model);
    view.addMouseListener(new BrowserMouseListener(model,
                                          view, controlPanel));

    Container c = getContentPane();
    c.add(controlPanel, BorderLayout.NORTH);
    c.add(view, BorderLayout.CENTER);
    c.add(scrollbar, BorderLayout.EAST);

  }

  /**************************************************************/
  /*****************              main           ****************/
  /**************************************************************/

  public static List<String> loadFile(String fileName)
  {
    BufferedReader inputFile = null;
    try
    {
      inputFile =
               new BufferedReader(new FileReader(fileName), 1024);
    }
    catch (IOException ex)
    {
      System.out.println("*** Cannot open " + fileName + " ***");
      System.exit(1);
    }

    List<String> textLines = new LinkedList<String>();

    try
    {
      String line;
      while ((line = inputFile.readLine()) != null)
        textLines.add(line);
    }
    catch (IOException ex)
    {
      System.out.println("*** Cannot read " + fileName + " ***");
    }

    try
    {
      inputFile.close();
    }
    catch (IOException ex)
    {
      System.out.println("*** Cannot close " + fileName + " ***");
    }

    return textLines;
  }

  public static void main(String[] args)
  {
    List<String> textLines = loadFile("lines.html");
    LineCruiser browser = new LineCruiser(textLines);
    browser.setLocation(100, 100);
    browser.setDefaultCloseOperation(EXIT_ON_CLOSE);
    browser.setVisible(true);
  }
}

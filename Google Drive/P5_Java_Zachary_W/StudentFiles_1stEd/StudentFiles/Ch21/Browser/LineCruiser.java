import java.awt.*;
import javax.swing.*;
import java.util.List;
import java.util.LinkedList;
import java.io.*;

public class LineCruiser extends JFrame
{
  public LineCruiser(List<String> textLines)
  {
    super("Line Cruiser");

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

    return textLines;
  }

  public static void main(String[] args)
  {
    List<String> textLines = loadFile("lines.html");
    LineCruiser browser = new LineCruiser(textLines);
    browser.setSize(640, 400);
    browser.setDefaultCloseOperation(EXIT_ON_CLOSE);
    browser.setVisible(true);
  }
}

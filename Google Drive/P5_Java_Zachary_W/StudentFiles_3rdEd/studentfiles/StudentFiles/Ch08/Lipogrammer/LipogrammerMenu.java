import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LipogrammerMenu extends JMenuBar
{
  private Lipogrammer lipogrammer;
  private JMenuItem openItem, saveItem, exitItem;

  // Constructor
  public LipogrammerMenu(Lipogrammer lipo)
  {
    lipogrammer = lipo;

    JMenu fileMenu = new JMenu("File");
    fileMenu.setMnemonic('F');

    FileAction fileAction = new FileAction();
    openItem = new JMenuItem("Open...");
    openItem.setMnemonic('O');
    openItem.addActionListener(fileAction);
    saveItem = new JMenuItem("Save...");
    saveItem.setMnemonic('S');
    saveItem.addActionListener(fileAction);
    exitItem = new JMenuItem("Exit");
    exitItem.setMnemonic('x');
    exitItem.addActionListener(fileAction);
    fileMenu.add(openItem);
    fileMenu.add(saveItem);
    fileMenu.addSeparator();
    fileMenu.add(exitItem);
    add(fileMenu);
  }


  /******************************************************************/
  /***************    Action Listener for the Menu   ****************/
  /******************************************************************/

  private class FileAction implements ActionListener
  {
    private String pathname = System.getProperty("user.dir") + "/";

    public void actionPerformed(ActionEvent e)
    {
      JMenuItem m = (JMenuItem)e.getSource();
      if (m == openItem)
      {
        loadText();
      }
      else if (m == saveItem)
      {
        saveText();
      }
      else if (m == exitItem)
      {
        System.exit(0);
      }
    }

    private void loadText()
    {
      JFileChooser fileChooser = new JFileChooser(pathname);
      fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
      int result = fileChooser.showOpenDialog(lipogrammer);
      if (result == JFileChooser.CANCEL_OPTION)
        return;

      File file = fileChooser.getSelectedFile();
      if (file == null)
        return;

      pathname = file.getAbsolutePath();
      Scanner fileIn = null;
      try
      {
        fileIn = new Scanner(file);
      }
      catch (IOException ex)
      {
        System.out.println("*** Can't open file ***");
        return;
      }

      StringBuffer buffer = new StringBuffer((int)file.length());
      while (fileIn.hasNextLine())
        buffer.append(fileIn.nextLine());

      lipogrammer.setText(buffer.toString());
      lipogrammer.refresh();
      fileIn.close();
    }

    private void saveText()
    {
      lipogrammer.refresh();
      JFileChooser fileChooser = new JFileChooser(pathname);
      fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
      int result = fileChooser.showSaveDialog(lipogrammer);
      if (result == JFileChooser.CANCEL_OPTION)
        return;

      File file = fileChooser.getSelectedFile();
      if (file != null)
      {
        pathname = file.getAbsolutePath();
        PrintWriter fileOut;
        try
        {
          fileOut = new PrintWriter(new FileWriter(file));
        }
        catch (IOException ex)
        {
          System.out.println("*** Can't create file ***");
          return;
        }

        fileOut.print(lipogrammer.getText());
        fileOut.close();
      }
    }
  }
}

/**
 * Menu for Cryptogram Solver
 */

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class CryptogramMenu extends JMenuBar
{
  private Cryptogram cryptogram;
  private JMenuItem openItem, saveItem, exitItem;

  public CryptogramMenu(Cryptogram crypto, ActionListener decodeAction)
  {
    cryptogram = crypto;

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

    JMenu decodeMenu = new JMenu("Decode");
    decodeMenu.setMnemonic('D');
    JMenuItem decodeItem = new JMenuItem("Decode");
    decodeItem.setMnemonic('D');
    decodeItem.addActionListener(decodeAction);
    JMenuItem clearItem = new JMenuItem("Clear");
    clearItem.setMnemonic('C');
    clearItem.addActionListener(decodeAction);
    JMenuItem encodeItem = new JMenuItem("Encode");
    encodeItem.setMnemonic('R');
    encodeItem.addActionListener(decodeAction);
    decodeMenu.add(decodeItem);
    decodeMenu.add(clearItem);
    decodeMenu.add(encodeItem);

    add(fileMenu);
    add(decodeMenu);
  }

  /******************************************************************/
  /***************          Action Listeners         ****************/
  /******************************************************************/

  private class FileAction implements ActionListener
  {
    private String pathName = System.getProperty("user.dir") + "/";

    public void actionPerformed(ActionEvent e)
    {
      JMenuItem m = (JMenuItem)e.getSource();
      if (m == openItem)
      {
        JFileChooser fileChooser = new JFileChooser(pathName);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = fileChooser.showOpenDialog(cryptogram);
        if (result == JFileChooser.CANCEL_OPTION)
          return;

        File file = fileChooser.getSelectedFile();
        if (file != null)
          pathName = file.getAbsolutePath();

        BufferedReader inputFile;
        try
        {
          inputFile = new BufferedReader(new FileReader(pathName), 1024);
        }
        catch (FileNotFoundException ex)
        {
          JOptionPane.showMessageDialog(cryptogram, "Invalid File Name",
                      "Cannot open " + pathName, JOptionPane.ERROR_MESSAGE);
          return;
        }

        StringBuffer buffer = new StringBuffer((int)file.length());

        try
        {
          while (inputFile.ready())
            {
              buffer.append((char)inputFile.read());
            }
        }
        catch (IOException ex)
        {
          System.err.println("Error reading " + pathName + "\n");
          return;
        }

        try
        {
          inputFile.close();
        }
        catch (IOException ex)
        {
          System.err.println("Error closing " + pathName + "\n");
          return;
        }

        String text = buffer.toString();
        cryptogram.setTextIn(text);
        cryptogram.setHints(text);
        cryptogram.setTextOut(text);
      }
      else if (m == saveItem)
      {
        JFileChooser fileChooser = new JFileChooser(pathName);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = fileChooser.showSaveDialog(cryptogram);
        if (result == JFileChooser.CANCEL_OPTION)
          return;

        File file = fileChooser.getSelectedFile();
        if (file != null)
          pathName = file.getAbsolutePath();

        PrintWriter outputFile;
        try
        {
          outputFile = new PrintWriter(new FileWriter(pathName, false));
        }
        catch (IOException ex)
        {
          JOptionPane.showMessageDialog(cryptogram, "Invalid File Name",
                      "Cannot create " + pathName, JOptionPane.ERROR_MESSAGE);
          return;
        }

        String text = cryptogram.getTextOut();
        outputFile.print(text);
        outputFile.close();
      }
      else if (m == exitItem)
      {
        System.exit(0);
      }
    }
  }
}
/**
 * Giggle Search Engine GUI
 */

import java.awt.Font;
import java.awt.Dimension;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import javax.swing.border.EmptyBorder;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.List;

public class Giggle extends JFrame
{
  public static JFrame thisWindow;

  private JMenuItem openItem, exitItem;
  private JTextArea textArea;
  private JTextField searchFld;
  private SearchEngine searchEngine;

  public Giggle()
  {
    super("Giggle");

    thisWindow = this;

    JMenuBar menuBar = new JMenuBar();

    JMenu fileMenu = new JMenu("File");
    fileMenu.setMnemonic('F');

    FileAction fileAction = new FileAction();
    openItem = new JMenuItem("Open...");
    openItem.setMnemonic('O');
    openItem.addActionListener(fileAction);
    exitItem = new JMenuItem("Exit");
    exitItem.setMnemonic('x');
    exitItem.addActionListener(fileAction);
    fileMenu.add(openItem);
    fileMenu.addSeparator();
    fileMenu.add(exitItem);

    menuBar.add(fileMenu);
    setJMenuBar(menuBar);

    JPanel panel = new JPanel();
    panel.setPreferredSize(new Dimension(100, 35));
    searchFld = new JTextField(20);
    JButton searchBtn = new JButton("Search");
    ActionListener listener = new SearchAction();
    searchFld.addActionListener(listener);
    searchBtn.addActionListener(listener);

    panel.add(searchFld);
    panel.add(searchBtn);

    textArea = new JTextArea("No documents have been processed -- the word index is empty");
    textArea.setFont(new Font("Serif", Font.BOLD, 16));
    textArea.setEditable(false);
    textArea.setBorder(new EmptyBorder(0, 10, 0, 10));
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);
    JScrollPane areaScrollPane = new JScrollPane(textArea);
    areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

    Container c = getContentPane();
    c.add(panel, BorderLayout.NORTH);
    c.add(areaScrollPane, BorderLayout.CENTER);
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
        int result = fileChooser.showOpenDialog(thisWindow);
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
          JOptionPane.showMessageDialog(thisWindow, "Invalid File Name",
                      "Cannot open " + pathName, JOptionPane.ERROR_MESSAGE);
          return;
        }


        searchEngine = new SearchEngine(pathName);
        String line;
        try
        {
          while ((line = inputFile.readLine()) != null)
            searchEngine.add(line);
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

        textArea.setText("Indexed " + pathName);
      }

      else if (m == exitItem)
      {
        System.exit(0);
      }
    }
  }

  private class SearchAction implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      if (searchEngine == null)
        return;

      String word = searchFld.getText().trim().toLowerCase();
      List<String> hits = searchEngine.getHits(word);
      int numHits = 0;
      if (hits != null)
        numHits = hits.size();
      textArea.setText("\"" + word + "\" in " + searchEngine.getURL() + ": " +
                                                            numHits + " hit(s)\n\n");

      if (numHits > 0)
      {
        for (String line : hits)
          textArea.append(line + "\n\n");
      }
      textArea.setCaretPosition(0);
    }
  }

  /******************************************************************/
  /***************                  main             ****************/
  /******************************************************************/

  public static void main(String[] args)
  {
    Giggle window = new Giggle();
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    window.setBounds(0, 0, 640, 480);
    window.setVisible(true);
  }
}

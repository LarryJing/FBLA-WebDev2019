import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.*;
import java.util.List;
import java.util.PriorityQueue;

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
      PriorityQueue<String> hits = searchEngine.getHits(word);
      int numHits = 0;
      String lines = "";

      if (hits != null)
      {  
        while (!hits.isEmpty())
        {
          lines += hits.remove() + "\n\n";
          numHits++;
        }
      }

      textArea.setText("\"" + word + "\" in " + searchEngine.getURL() + ": " +
                                                            numHits + " hit(s)\n\n");
      if (numHits > 0)
      { 
        textArea.append(lines);
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

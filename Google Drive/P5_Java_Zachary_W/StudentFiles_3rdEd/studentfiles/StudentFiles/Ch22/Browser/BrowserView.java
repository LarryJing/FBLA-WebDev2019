/**
 * Browser display
 */
 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import java.util.List;
import java.util.ListIterator;

public class BrowserView extends JPanel
    implements AdjustmentListener
{
  private static final int LINE_HEIGHT = 20;
  private static final int X_OFFSET = LINE_HEIGHT / 2;
  private static final int Y_OFFSET = LINE_HEIGHT / 4;

  private Font font;
  private JScrollBar scrollbar;
  private int topLine;
  private List<String> textLines;

  public BrowserView(JScrollBar scrollbar, List<String> textLines)
  {
    setBackground(Color.WHITE);

    this.scrollbar = scrollbar;
    this.textLines = textLines;
    scrollbar.setValues(0, 1, 0, textLines.size());
    scrollbar.addAdjustmentListener(this);

    topLine = scrollbar.getValue();
    font = new Font("Serif", Font.PLAIN, LINE_HEIGHT);
  }

  public void update(int lineNum)
  {
    topLine = lineNum;
    scrollbar.setValue(topLine);
    repaint();
  }

  public int getLineNumber(int x, int y)
  {
    int n = topLine + (y - Y_OFFSET) / LINE_HEIGHT; // line # clicked
    String line = textLines.get(n);                 // line clicked
    String name = getReference(line);               // <a href="#name">
    if (name == null)
      return -1;

    n = 0;
    for (String nextLine : textLines)
    {
      if (name.equals(getName(nextLine)))           // <a name="name">
        return n;
      n++;
    }

    return -1;
  }

  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    if (textLines == null)
      return;

    int x = X_OFFSET;
    int y = LINE_HEIGHT + Y_OFFSET;
    int yLimit = getHeight() + LINE_HEIGHT;

    g.setFont(font);
    String line;
    ListIterator<String> iter = textLines.listIterator(topLine);

    while (iter.hasNext() && y < yLimit)
    {
      line = iter.next();
      if (getReference(line) != null)
        g.setColor(Color.BLUE);
      else
        g.setColor(Color.BLACK);
      line = stripTags(line);
      g.drawString(line, x, y);
      y += LINE_HEIGHT;
    }
  }

  /**************************************************************/
  /*****************            Scroll bar       ****************/
  /**************************************************************/

  public void adjustmentValueChanged(AdjustmentEvent e)
  {
    topLine = e.getValue();
    repaint();
  }

  /*********************************************************************/
  /**************              Private methods            **************/
  /*********************************************************************/

  private String stripTags(String str)
  {
    int first;

    while ((first = str.indexOf('<')) >= 0)
    {
      int count = 1;
      int last = first + 1;
      while (count > 0 && last < str.length())
      {
        char c = str.charAt(last);
        if (c == '<') count++;
        else if (c == '>') count--;
        last++;
      }
      if (count == 0)
        str = str.substring(0, first) + str.substring(last);
    }

    return str;
  }

  private String getReference(String line)
  {
    int first = line.indexOf("<a href=");

    if (first >= 0)
    {
      first = line.indexOf('#', first) + 1;
      int last = line.indexOf('\"', first);
      return line.substring(first, last);
    }
    else
      return null;
  }

  private String getName(String line)
  {
    int first = line.indexOf("<a name=");

    if (first >= 0)
    {
      first = line.indexOf('\"', first) + 1;
      int last = line.indexOf('\"', first);
      return line.substring(first, last);
    }
    else
      return null;
  }
}

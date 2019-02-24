import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;

public class TeletextDisplay extends JPanel
                    implements ActionListener
{
  private TeletextList msgList;
  private static final int LINE_HEIGHT = 24;
  private int xOffset;
  private int yOffset;
  private Font myFont;

  public TeletextDisplay(TeletextList msgList)
  {
    this.msgList = msgList;
    myFont = new Font("Serif", Font.PLAIN, LINE_HEIGHT);
    setBackground(Color.WHITE);
    xOffset = LINE_HEIGHT / 2;
    yOffset = -LINE_HEIGHT;
  }

  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);

    if (yOffset == -LINE_HEIGHT)
      yOffset = getHeight();

    if (msgList != null)
    {
      g.setFont(myFont);
      int nLines = (getHeight() - yOffset) / LINE_HEIGHT + 2;
      msgList.draw(g, xOffset, yOffset, LINE_HEIGHT, nLines);
    }
  }

  public void actionPerformed(ActionEvent e)
  {
    yOffset -= 2;
    if (yOffset <= 0)
    {
      yOffset += LINE_HEIGHT;
      msgList.scrollUp();
    }
    repaint();
  }
}

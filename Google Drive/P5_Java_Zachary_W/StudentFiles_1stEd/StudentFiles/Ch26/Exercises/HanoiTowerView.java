import java.awt.Graphics;
import java.awt.Color;
import java.util.List;
import javax.swing.JPanel;

public class HanoiTowerView extends JPanel
{
  private HanoiTowerModel model;

  public HanoiTowerView(int nDisks)
  {
    setBackground(Color.WHITE);
    model = new HanoiTowerModel(nDisks);
  }

  public void makeMove()
  {
    model.makeMove();
    repaint();
  }

  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);

    if (model == null)
      return;

    for (int peg = 0; peg < 3; peg++)
      drawDisks(peg, g);
  }

  private void drawDisks(int peg, Graphics g)
  {
    List<Integer> disks = model.getPeg(peg);
    if (disks == null)
      return;

    int w = getWidth();
    int h = getHeight();

    int x = w/4 * (peg + 1);
    int y = h * 2 / 3;
    int d = h / 30;
    int radius = w / 8;

    Color diskColor;

    if (peg < 2)
      diskColor = Color.GRAY;
    else
      diskColor = Color.LIGHT_GRAY;

    g.setColor(diskColor);
    g.fillRect(x - radius + d, y + radius / 4 + 2*d, 2 * radius - 2*d, d);

    for (Integer disk : disks)
    {
      int k = disk.intValue();
      radius = w / 8 - 2 * d * k;

      if (k % 2 == 0)
        diskColor = Color.GRAY;
      else
        diskColor = Color.LIGHT_GRAY;

      g.setColor(diskColor);
      g.fillOval(x - radius, y - radius / 4 + d, 2 * radius, radius / 2);
      g.setColor(Color.black);
      g.drawOval(x - radius, y - radius / 4 + d - 1 , 2 * radius, radius / 2);

      g.setColor(diskColor);
      g.fillRect(x - radius, y, 2 * radius + 1, d);
      
      g.setColor(diskColor);
      g.fillOval(x - radius, y - radius / 4, 2 * radius, radius / 2);
      g.setColor(Color.black);
      g.drawOval(x - radius, y - radius / 4, 2 * radius, radius / 2);

      y -= d;
    }

    g.setColor(Color.BLUE);
    g.fillRect(x - 5, h/6, 10, y - h/6 + d);
  }
}

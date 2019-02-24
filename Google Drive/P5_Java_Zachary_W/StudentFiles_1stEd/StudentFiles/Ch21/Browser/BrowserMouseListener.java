import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class BrowserMouseListener implements MouseListener
{
  private BrowserModel model;
  private BrowserView view;
  private BrowserControlPanel controlPanel;

  public BrowserMouseListener(BrowserModel model, BrowserView view,
           BrowserControlPanel controlPanel)
  {
    this.model = model;
    this.view = view;
    this.controlPanel = controlPanel;
  }
  
  public void mouseReleased(MouseEvent e)
  {
    int n = view.getLineNumber(e.getX(), e.getY());
    if (n >= 0)
      model.followLink(n);

    controlPanel.resetButtons();
  }

  // not used
  public void mousePressed(MouseEvent e) {}
  public void mouseClicked(MouseEvent e) {}
  public void mouseEntered(MouseEvent e) {}
  public void mouseExited(MouseEvent e) {}
}

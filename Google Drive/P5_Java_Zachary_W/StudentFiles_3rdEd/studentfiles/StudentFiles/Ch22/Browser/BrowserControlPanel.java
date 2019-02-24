/**
 * Control panel for broser
 */
 
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JButton;

public class BrowserControlPanel extends JPanel
    implements ActionListener
{
  private BrowserModel model;
  private JButton homeBtn, backBtn, forwardBtn;

  public BrowserControlPanel(BrowserModel model)
  {
    this.model = model;

    homeBtn = new JButton("Home");
    homeBtn.addActionListener(this);

    backBtn = new JButton("<==");
    backBtn.addActionListener(this);

    forwardBtn = new JButton("==>");
    forwardBtn.addActionListener(this);

    setLayout(new FlowLayout(FlowLayout.LEFT));
    add(homeBtn);
    add(backBtn);
    add(forwardBtn);

    resetButtons();
  }

  public void resetButtons()
  {
    backBtn.setEnabled(model.hasBack());
    forwardBtn.setEnabled(model.hasForward());
  }

  /**************************************************************/
  /*****************            Buttons          ****************/
  /**************************************************************/

  public void actionPerformed(ActionEvent e)
  {
    JButton b = (JButton)e.getSource();

    if (b == homeBtn)
    {
      model.home();
    }
    else if (b == backBtn)
    {
      model.back();
    }
    else if (b == forwardBtn)
    {
      model.forward();
    }

    resetButtons();
  }
}

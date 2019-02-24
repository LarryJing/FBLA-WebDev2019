import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;

/*
 * Represents the control panel in BalloonDraw.
 */
public class ControlPanel extends JPanel
{
  private DrawingPanel canvas;
  private JButton colorButton, colorDisplay; //, balloonButton;
  private JComboBox<String> chooseBalloonShape;

  public ControlPanel(DrawingPanel canvas)
  {
    this.canvas = canvas;

    colorButton = new JButton("Pick Color");
    colorButton.addActionListener(new ColorButtonListener());

    colorDisplay = new JButton();
    colorDisplay.setBackground(canvas.getColor());
    colorDisplay.setEnabled(false);

    //balloonButton = new JButton("Add Balloon");
    String[] balloonShapeNames = {"Round", "Oval", "Square", "Fancy"};
    chooseBalloonShape = new JComboBox<String>(balloonShapeNames);
    //balloonButton.addActionListener(new BalloonButtonListener());
    chooseBalloonShape.addActionListener(new BalloonButtonListener());

    add(colorButton);
    add(colorDisplay);
    //add(balloonButton);
    add(chooseBalloonShape);
  }

  private class ColorButtonListener
      implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      canvas.pickColor();
      colorDisplay.setBackground(canvas.getColor());
      canvas.requestFocus();
    }
  }

  private class BalloonButtonListener
      implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      canvas.addBalloon(chooseBalloonShape.getSelectedIndex() + 1);
      canvas.requestFocus();
    }
  }
}

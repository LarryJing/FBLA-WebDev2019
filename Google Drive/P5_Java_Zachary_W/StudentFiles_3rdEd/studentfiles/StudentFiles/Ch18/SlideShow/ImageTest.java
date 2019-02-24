import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JFrame;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ImageTest extends JFrame
{
  private Image picture;

  public ImageTest()
  {
    super("Image Test");
    setSize(1000, 800);
    
    String pathname = "images/happy.jpg";
    try
    {
      picture = ImageIO.read(new File(pathname));
    }
    catch (IOException ex)
    {
      System.out.println("*** Can't load " + pathname + " ***");
      System.exit(1);
    }
  }
  
  public void paint(Graphics g)
  {
    super.paint(g);
    
    if (picture != null)
    {
      // center the picture:
      int x = (getWidth() - picture.getWidth(null)) / 2;
      int y = (getHeight() - picture.getHeight(null)) / 2;
      g.drawImage(picture, x, y, null);
    }
  }
    
  public static void main(String[] args)
  {    
    ImageTest window = new ImageTest();
    window.setLocation(20, 20);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    window.setVisible(true);
  }
}

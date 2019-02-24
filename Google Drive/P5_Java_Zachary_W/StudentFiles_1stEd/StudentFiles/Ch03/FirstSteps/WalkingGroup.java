import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WalkingGroup implements StudentGroup
{
  private Walker amy;
  private Walker ben;
  private Image leftWomansShoe, rightWomansShoe;
  private Image leftMansShoe, rightMansShoe;

  private DanceFloor danceFloor;

  private enum State {READY, MOVING, STOPPED}
  private State currentState;
  private int stepsCount;

  // Constructor
  public WalkingGroup(DanceFloor df)
  {
    danceFloor = df;
    leftWomansShoe = (new ImageIcon("leftsandal.gif")).getImage();
    rightWomansShoe = (new ImageIcon("rightsandal.gif")).getImage();
    leftMansShoe = (new ImageIcon("leftshoe.gif")).getImage();
    rightMansShoe = (new ImageIcon("rightshoe.gif")).getImage();
  }

  // Sets up this group of participants
  public void setup(int floorDir, Dance steps1, Dance steps2)
  {
    int width = danceFloor.getWidth();
    int height = danceFloor.getHeight();
    int x = width / 10;
    int y = height / 2;

    if (floorDir == 0)
    {
      amy = new Walker(x, y - height / 5, leftWomansShoe, rightWomansShoe);
      ben = new Walker(x, y + height / 5, leftMansShoe, rightMansShoe);
    }
    else
    {
      amy = new Walker(x, y + height / 5, leftWomansShoe, rightWomansShoe);
      ben = new Walker(x, y - height / 5, leftMansShoe, rightMansShoe);
    }
    currentState = State.READY;
    danceFloor.update(this);
  }

  // Moves the group by one step
  public void makeNextStep()
  {
    if (currentState == State.READY)
    {
      amy.firstStep();
      ben.firstStep();
      currentState = State.MOVING;
      stepsCount = 0;
    }
    else if (currentState == State.MOVING)
    {
      if (amy.distanceTraveled() <= danceFloor.getWidth() * 3 / 4)
      {
        amy.nextStep();
        ben.nextStep();
        stepsCount++;
      }
      else
      {
        amy.stop();
        ben.stop();
        currentState = State.STOPPED;
      }
    }

    danceFloor.update(this);
  }

  // Draws this group
  public void draw(Graphics g)
  {
    amy.draw(g);
    ben.draw(g);
  }
}


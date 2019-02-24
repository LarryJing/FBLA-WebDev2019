import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PacingGroup implements StudentGroup
{
  private Pacer amy;
  private Pacer ben;
  private Image leftWomansShoe, rightWomansShoe;
  private Image leftMansShoe, rightMansShoe;

  private DanceFloor danceFloor;

  private enum State {READY, MOVING, STOPPED}
  private State currentState;
  private int stepsCount;

  // Constructor
  public PacingGroup(DanceFloor df)
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
      amy = new Pacer(x, y - height / 5, leftWomansShoe, rightWomansShoe);
      ben = new Pacer(x, y + height / 5, leftMansShoe, rightMansShoe);
    }
    else
    {
      amy = new Pacer(width - x, y + height / 5,
                                          leftWomansShoe, rightWomansShoe);
      ben = new Pacer(width - x, y - height / 5,
                                          leftMansShoe, rightMansShoe);
      amy.turnAround();
      ben.turnAround();
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
    else if (currentState == State.STOPPED)
    {
      amy.turnAround();
      ben.turnAround();
      currentState = State.READY;
    }

    danceFloor.update(this);
  }

  // Draws this group
  public void draw(Graphics g)
  {
    ben.draw(g);
    amy.draw(g);
  }
}


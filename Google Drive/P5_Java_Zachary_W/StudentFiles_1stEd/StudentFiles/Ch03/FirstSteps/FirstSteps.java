public class FirstSteps
{
  public static void main(String[] args)
  {
    DanceFloor danceFloor = new DanceFloor();

    StudentGroup students = new WalkingGroup(danceFloor);
    // Or: 
    //    StudentGroup students = new PacingGroup(danceFloor);

    new DanceLesson(students, danceFloor);
  }
}

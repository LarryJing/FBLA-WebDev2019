import java.util.Scanner;

public class CircleTest
{
  public static void main(String[] args)
  {
    Scanner kb = new Scanner(System.in);
    System.out.print("Enter the radius: ");
    double r = kb.nextDouble();
    Circle circle = new Circle(r);
    double area = circle.getArea();
    System.out.println("radius = " + r + " area = " + area);
  }
}

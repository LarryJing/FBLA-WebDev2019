


public class FractionTester_Shah_Sarthak {
	private static int pointCount = 5;
	private static int failCount = 0;
	private static int percentage = 0;
	private static final int TOTALPOINTS = 10;
	private static final Fraction FRACTIONFIVEHALVES = new Fraction(5,2);
	private static final Fraction FRACTIONTWOFIFTHS = new Fraction(2,5);
	private static final Fraction TESTTHREEFOURTHS = new Fraction(0.75);
	
	public static void main(String[] args)
	{
		System.out.println("***Testing Double Constructor***");
		System.out.println(TESTTHREEFOURTHS.toString() + " = 3/4");
		if(TESTTHREEFOURTHS.toString().equals("3/4"))
		{
			pointCount++;
			System.out.println("PASS\n");
		}
		else 
		{
			failCount++;
			System.out.println("FAIL\n");
		}
		
		System.out.println("***Testing Subtraction(Fraction)***");
		System.out.println(FRACTIONFIVEHALVES.subtract(FRACTIONTWOFIFTHS) + " = 21/10");
		if(FRACTIONFIVEHALVES.subtract(FRACTIONTWOFIFTHS).toString().equals("21/10"))
		{
			pointCount++;
			System.out.println("PASS\n");
		}
		else 
		{
			failCount++;
			System.out.println("FAIL\n");
		}
		
		System.out.println("***Testing Subtraction(Int)***");
		System.out.println(FRACTIONFIVEHALVES.subtract(1) + " = 3/2");
		if(FRACTIONFIVEHALVES.subtract(1).toString().equals("3/2"))
		{
			pointCount++;
			System.out.println("PASS\n");
		}
		else 
		{
			failCount++;
			System.out.println("FAIL\n");
		}
		
		System.out.println("***Testing Division(Fraction)***");
		System.out.println(FRACTIONFIVEHALVES.divide(FRACTIONTWOFIFTHS) + " = 25/4");
		if(FRACTIONFIVEHALVES.divide(FRACTIONTWOFIFTHS).toString().equals("25/4"))
		{
			pointCount++;
			System.out.println("PASS\n");
		}
		else 
		{
			failCount++;
			System.out.println("FAIL\n");
		}
		
		System.out.println("***Testing Division(int)***");
		System.out.println(FRACTIONFIVEHALVES.divide(3) + " = 5/6");
		if(FRACTIONFIVEHALVES.divide(3).toString().equals("5/6"))
		{
			pointCount++;
			System.out.println("PASS\n");
		}
		else 
		{
			failCount++;
			System.out.println("FAIL\n");
		}
		
		percentage = pointCount * 100 / TOTALPOINTS;
		System.out.println("");
		System.out.println("***FINAL RESULTS***");
		System.out.println("Points Earned: " + pointCount);
		System.out.println("Failures: " + failCount);
		System.out.println("Possible Points: " + TOTALPOINTS);
		System.out.println("Percentage: " + (pointCount * 100 / TOTALPOINTS) + "%");
}
}

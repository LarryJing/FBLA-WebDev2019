// Chapter 7 Question 4

import java.util.Scanner;

public class QuotientRemainder
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter a positive integer: ");
    int m = input.nextInt();
    System.out.print("Enter another positive integer: ");
    int n = input.nextInt();

    input.close();

    int q = 0;
    int r = m;
    while (r >= n)
    {
      r -= n;
      q += 1;
    }
    
    System.out.printf("When %d is divided by %d the quotient is %d and the remainder is %d.\n",
                            m, n, q, r); 
  }  
}

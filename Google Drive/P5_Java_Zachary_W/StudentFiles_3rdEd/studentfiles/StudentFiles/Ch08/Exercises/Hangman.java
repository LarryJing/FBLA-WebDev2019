// Chapter 8 Question 21

import java.util.Scanner;

public class Hangman
{
  private static String[] words = {"inheritance", "abstraction", "encapsulation", "polymorphism"};

  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    String word = words[(int)(Math.random() * words.length)];
    HangmanGame game = new HangmanGame(word);
    int count = 0;
    int failedGuesses = 0;

    boolean done = false;
    while (!done)
    {
      System.out.println("Tried: " + game.getTried());
      System.out.println("Failed guesses: " + failedGuesses);
      System.out.println(game.getGuessed());
      System.out.println();

      System.out.print("Enter next letter (or Quit): ");
      String s = input.next();
      if ("quit".equalsIgnoreCase(s))
        break;
      if (s.length() != 1)
      {
        System.out.println("Invalid input");
      }
      else
      {
        int result = game.tryLetter(s.charAt(0));
        switch(result)
        {
          case 0:

          System.out.println("Already tried");
          break;

          case -1:

          System.out.println("Sorry, not there");
          failedGuesses++;
          break;

          case 1:

          System.out.println("Yes!");
          break;
        }
      }

      count++;

      if (game.getGuessed().indexOf('-') == -1)
      {
        System.out.println("You guessed " + word + " in " + count + " tries.");
        done = true;
      }
    }
    input.close();
  }
}

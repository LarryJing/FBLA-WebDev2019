/**
 * @(#)DogYears.java
 *

  For testing purposes:
  Dog age of 1 = Human age 13
  Dog age of 2 = Human age 18
  Dog age of 5 = Human age 34
  Dog age of 8 = Human age 50
  Dog age of 12 = Human age 72

 *
 * @author
 * @version
 */

import ...

public class DogYears {

    public int convertToHumanYears(int dog) {
    	int human = ...
    	return ...
    }

	/*
    public int convertToDogYears(int human) {
    	// Work on this once you have finished convertToHumanYears()!
    	int dog = ...
    	return ...
    }
    */

	public static void main (String[] args) {
		// TAKE IN USER INPUT
		Scanner keyboard = ...
		System.out.print( ...
		int dog = ...

		DogYears converter = new DogYears();
		int human = converter.convertToHumanYears(dog);

		// PRINT OUT THE RESULT
		System.out.println( ...
	}

}
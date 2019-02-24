/*
   This class implements a vendor that sells one kind of items.
   A vendor carries out sales transactions.
*/

public class Vendor
{
  // Fields:
  ...

  //  Constructor
  //  Parameters:
  //    int price of a single item in cents
  //    int number of items to place in stock
  ... Vendor ...
  {
    ...
  }

  //  Sets the quantity of items in stock.
  //  Parameters:
  //    int number of items to place in stock
  //  Return:
  //    None
  ... setStock ...
  {
    ...
  }

  //  Returns the number of items currently in stock.
  //  Parameters:
  //    None
  //  Return:
  //    int number of items currently in stock
  ... getStock ...
  {
    ...
  }

  //  Adds a specified amount (in cents) to the deposited amount.
  //  Parameters:
  //    int number of cents to add to the deposit
  //  Return:
  //    None
  ... addMoney ...
  {
    ...
  }

  //  Returns the currently deposited amount (in cents).
  //  Parameters:
  //    None
  //  Return:
  //    int number of cents in the current deposit
  ... getDeposit ...
  {
    ...
  }

  //  Implements a sale.  If there are items in stock and
  //  the deposited amount is greater than or equal to
  //  the single item price, then adjusts the stock
  //  and calculates and sets change and returns true;
  //  otherwise refunds the whole deposit (moves it into change)
  //  and returns false.
  //  Parameters:
  //    None
  //  Return:
  //    boolean successful sale (true) or failure (false)
  ... makeSale ...
  {
    ...
  }

  //  Returns and zeroes out the amount of change (from the last
  //  sale or refund).
  //  Parameters:
  //    None
  //  Return:
  //    int number of cents in the current change
  ... getChange ...
  {
    ...
  }
}

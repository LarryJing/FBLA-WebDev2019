/**
 * This class implements a vendor that sells one kind
 * of items. A vendor carries out sales transactions.
 */
public class Vendor
{
  // Fields:
  ...

  /**
   * Constructs a Vendor
   * @param price the price of a single item in cents (int)
   * @param stock number of items to place in stock (int)
   */
  ... Vendor ...
  {
    ...
  }

  /**
   * Sets the quantity of items in stock.
   * @param qty number of items to place in stock (int)
   */
  ... setStock ...
  {
    ...
  }

  /**
   * Returns the number of items currently in stock.
   * @return number of items currently in stock (int)
   */
  ... getStock ...
  {
    ...
  }

  /**
   * Adds a specified amount (in cents) to the
   * deposited amount.
   * @param number of cents to add to the deposit (int)
   */
  ... addMoney ...
  {
    ...
  }

  /**
   * Returns the currently deposited amount (in cents).
   * @return number of cents in the current deposit (int)
   */
  ... getDeposit ...
  {
    ...
  }

  /**
   * Implements a sale.  If there are items in stock and
   * the deposited amount is greater than or equal to
   * the single item price, then adjusts the stock and
   * calculates and sets change, sets deposit to 0 and
   * returns true; otherwise refunds the whole deposit
   * (moves it into change) and returns false.
   * @return true for a successful sale, false otherwise (boolean)
   */
  ... makeSale ...
  {
    ...
  }

  /**
   * Returns and zeroes out the amount of change (from
   * the last sale or refund).
   * @return number of cents in the current change (int)
   */
  ... getChange ...
  {
    ...
  }
}

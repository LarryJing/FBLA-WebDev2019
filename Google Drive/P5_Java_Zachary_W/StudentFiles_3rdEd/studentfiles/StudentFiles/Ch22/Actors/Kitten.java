/**
 * Implements a "Kitten" that can receive and send messages about
 * its possessions and give extra items that it doesn't need to others.
 * The Kitten's objective is to collect at least one of each item.
 */

import java.util.Collection;
import java.util.ArrayList;

public class Kitten extends Actor
{
  private static String[] items = {"left glove", "right glove", "hat"};

  private Collection<String> myPossessions;
  private boolean allSetFlag; // = false;

  public Kitten(String name)
  {
    super(name);
  }

  public Kitten(String name, Collection<String> possessions)
  {
    super(name);
    myPossessions = new ArrayList<String>();
    myPossessions.addAll(possessions);
  }

  /**
   * Called by someone else to give an item to this Kitten.
   * Checks whether this Kitten still needs the item.  If so,
   * sends a thank-you message to giver and returns true;
   * otherwise returns false
   */
  public boolean receiveItem(Kitten giver, String item)
  {
    if (!myPossessions.contains(item))
    {
      myPossessions.add(item);
      send(giver, "thx for the " + item);
      return true;
    }
    else
      return false;
  }

  /**
   * 1. Checks possessions for this Kitten and sends a "need <item>"
   *    message to the list for each missing item.
   * 2. Removes and processes messages from the mailbox,
   *    one by one.
   * Processing messages:
   *     i)  Takes action only for messages with the text
   *         "need <item>", "have <item>", or "ship <item>".
   *         where <item> is the name of the item, such as "hat",
   *         "left glove", or "right glove".
   *         Skips all other messages.
   *    ii)  If this is a "need" message and this Kitten has an extra item
   *         requested, it responds with a "have <item>" message.
   *   iii) If this is a "have" message and this Kitten is missing the offered item,
   *        it responds with a "ship <item>" message.
   *    iv)  If this is a "ship" message and this Kitten still has an extra item,
   *         then it calls sender's receiveItem method.  If receiveItem
   *         returns true, removes item from this Kitten's possessions.
   * 3. If allSetFlag is not set and this Kitten is all set, that is has
   *    one of each item, sends "thx, all set" to the list.
   */
  public void readMail()
  {
    _______________________________________
    ...
  }

  public String toString()
  {
    return super.toString() + " " + myPossessions;
  }

  //*************************************************************

  /**
   * Returns the number of times item occurs in myPossessions
   */
  private int countPossessions(String item)
  {
    int count = 0;

    for (String str : myPossessions)
      if (item.equals(str))
        count++;

    return count;
  }

  /**
   * Checks whether this Kitten has one of each items
   */
  private boolean allSet()
  {
    for (String item : items)
    {
      if (countPossessions(item) != 1)
        return false;
    }
    allSetFlag = true;
    return true;
  }
}


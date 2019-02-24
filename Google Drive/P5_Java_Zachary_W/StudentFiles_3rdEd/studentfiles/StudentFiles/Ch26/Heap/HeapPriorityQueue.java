/**
 * Implements a priority queue based on a min-heap.
 */

import java.util.Comparator;
import java.util.NoSuchElementException;

public class HeapPriorityQueue
{
  private static final int DFLT_CAPACITY = 101;
  private Object[] items;
  private int numItems;
  private final Comparator<Object> comparator;

  public HeapPriorityQueue()
  {
    this(DFLT_CAPACITY, null);
  }

  public HeapPriorityQueue(Comparator<Object> c)
  {
    this(DFLT_CAPACITY, c);
  }

  public HeapPriorityQueue(int initialCapacity)
  {
    this(initialCapacity, null);
  }

  public HeapPriorityQueue(int initialCapacity, Comparator<Object> c)
  {
    items = new Object[initialCapacity + 1];
    comparator = c;
  }

  /**
   * Returns true if this priority queue is empty;
   * otherwise returns false.
   */
  public boolean isEmpty()
  {
    return numItems == 0;
  }

  /**
   * Returns the highest priority element without removing
   * it from this priority queue.
   */
  public Object peek()
  {
    if (numItems == 0)
    {
      throw new NoSuchElementException();
    }
    return items[1];
  }

  /**
   * Adds obj to this priority queue; returns true.
   */
  public boolean add(Object obj)
  {
    numItems++;
    if (numItems >= items.length)  // items[0] is not used
      growCapacity();
    items[numItems] = obj;
    reheapUp();
    return true;
  }

  /**
   * Removes and returns the highest priority item.
   */
  public Object remove()
  {
    if (numItems == 0)
    {
      throw new NoSuchElementException();
    }

    Object minObject = items[1];
    items[1] = items[numItems];
    numItems--;
    reheapDown();
    return minObject;
  }

  //**************************************************************************

  @SuppressWarnings("unchecked")
  private boolean lessThan(Object obj1, Object obj2)
  {
    if (comparator != null)
      return comparator.compare(obj1, obj2) < 0;
    else
      return ((Comparable<Object>)obj1).compareTo(obj2) < 0;
  }

  private void reheapDown()
  {
    __________________________________
    ...
  }

  private void reheapUp()
  {
    __________________________________
    ...
  }

  private void growCapacity()
  {
    Object[] tempItems = new Object[2 * items.length - 1];
    System.arraycopy(items, 0, tempItems, 0, items.length);
    items = tempItems;
  }
}


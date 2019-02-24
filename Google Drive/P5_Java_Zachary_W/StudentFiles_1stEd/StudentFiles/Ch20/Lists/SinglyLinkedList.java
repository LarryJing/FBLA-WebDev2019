// Implements a singly-linked list.

import java.util.Iterator;

public class SinglyLinkedList implements Iterable<Object>
{
  private ListNode head;
  private int nodeCount;

  // Constructor: creates an empty list
  public SinglyLinkedList()
  {
    head = null;
    nodeCount = 0;
  }

  // Constructor: creates a list that contains
  // all elements from the array values, in the same order
  public SinglyLinkedList(Object[] values)
  {
    ListNode tail = null;
    for (Object value : values) // for each value to insert
    {
      ListNode node = new ListNode(value, null);
      if (head == null)
        head = node;
      else
        tail.setNext(node);
      tail = node;    // update tail
    }

    nodeCount = values.length;
  }

  // Returns true if this list is empty; otherwise returns false.
  public boolean isEmpty()
  {
    ...
  }

  // Returns the number of elements in this list.
  public int size()
  {
    ...
  }

  // Returns true if this list contains an element equal to obj;
  // otherwise returns false.
  public boolean contains(Object obj)
  {
    ...
  }

  // Returns the index of the first element in equal to obj;
  // if not found, retunrs -1.
  public int indexOf(Object obj)
  {
    ...
  }

  // Adds obj to this collection.  Returns true if successful;
  // otherwise returns false.
  public boolean add(Object obj)
  {
    ...
  }

  // Removes the first element that is equal to obj, if any.
  // Returns true if successful; otherwise returns false.
  public boolean remove(Object obj)
  {
    ...
  }

  // Returns the i-th element.               
  public Object get(int i)
  {
    ...
  }

  // Replaces the i-th element with obj and returns the old value.
  public Object set(int i, Object obj)
  {
    ...
  }

  // Inserts obj to become the i-th element. Increments the size
  // of the list by one.
  public void add(int i, Object obj)
  {
    ...
  }

  // Removes the i-th element and returns its value.
  // Decrements the size of the list by one.
  public Object remove(int i)
  {
    ...
  }

  // Returns a string representation of this list.
  public String toString()
  {
    ...
  }

  // Returns an iterator for this collection.
  public Iterator<Object> iterator()
  {
    return new SinglyLinkedListIterator(head);
  }
}

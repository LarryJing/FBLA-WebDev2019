// Represents a node of a doubly-linked list.
public class ListNode2
{  
  private Object value;
  private ListNode2 previous;
  private ListNode2 next;

  // Constructor:
  public ListNode2(Object initValue, ListNode2 initPrevious,
                              ListNode2 initNext)
  {
    value = initValue;
    previous = initPrevious;
    next = initNext;
  }

  public Object getValue()
  {
    return value;
  }

  public ListNode2 getPrevious()
  {
    return previous;
  }

  public ListNode2 getNext()
  {
    return next;
  }

  public void setValue(Object theNewValue)
  {
    value = theNewValue;
  }

  public void setPrevious(ListNode2 theNewPrev)
  {
    previous = theNewPrev;
  }

  public void setNext(ListNode2 theNewNext)
  {
    next = theNewNext;
  }
}



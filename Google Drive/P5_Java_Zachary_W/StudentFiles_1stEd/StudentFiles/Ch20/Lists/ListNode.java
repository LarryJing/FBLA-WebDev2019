// Represents a node of a singly-linked list.

public class ListNode
{  
  private Object value;
  private ListNode next;

  // Constructor:
  public ListNode(Object initValue, ListNode initNext)
  {
    value = initValue;
    next = initNext;
  }

  public Object getValue() { return value; }
  public ListNode getNext() { return next; }

  public void setValue(Object theNewValue) { value = theNewValue; }
  public void setNext(ListNode theNewNext) { next = theNewNext; }
}


import java.util.LinkedList;

public class ListStack implements Stack
{ 
  private LinkedList<Object> items;

  public ListStack() { items = new LinkedList<Object>(); }
  public boolean isEmpty() { return items.isEmpty(); }
  public Object peek() { return items.getFirst(); }
  public void push(Object obj) { items.addFirst(obj); }
  public Object pop() { return items.removeFirst(); }
}

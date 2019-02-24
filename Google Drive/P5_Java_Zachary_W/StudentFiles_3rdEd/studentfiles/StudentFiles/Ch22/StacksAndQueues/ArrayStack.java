import java.util.ArrayList;

public class ArrayStack implements Stack
{
  private ArrayList<Object> items;

  public ArrayStack()  { items = new ArrayList<Object>(); }
  public boolean isEmpty() { return items.isEmpty(); }
  public Object peek() { return items.get(items.size() - 1); }
  public void push(Object obj) { items.add(obj); }
  public Object pop() { return items.remove(items.size() - 1); }
}

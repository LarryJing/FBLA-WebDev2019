public interface Stack 
{
  /**
   * Returns true if this stack is empty; otherwise returns false.
   */
  boolean isEmpty();

  /**
   * Returns (but does not remove) the object at the top of this stack
   * or null if the stack is empty.
   */
   Object peek();

  /**
   * Adds obj at the top of this stack.
   */
  void push(Object obj);

  /**
   * Removes and returns the object at the top of this stack.
   * Throws NoSuchElementException if the stack is empty.
   */  
  Object pop();
}

package DataStructures;

public class Stack<T> {
  private int size = 0;
  private Node<T> top = null;

  private static class Node<T> {
    private T data;
    private Node<T> prev;

    public Node(T data, Node<T> prev) {
      this.data = data;
      this.prev = prev;
    }

  }

  public int getSize() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void push(T data) {
    top = new Node<T>(data, top);
    size++;
  }

  public T pop() {
    if (isEmpty())
      throw new RuntimeException("Stack is empty");

    T data = top.data;
    top = top.prev;

    size--;
    return data;
  }

  public T peek() {
    if (isEmpty())
      throw new RuntimeException("Stack is empty");

    return top.data;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    Node<T> trav = top;
    while (trav != null) {
      sb.append(trav.data);
      if (trav.prev != null)
        sb.append(", ");
      trav = trav.prev;
    }
    sb.append("]");
    return sb.toString();
  }
}

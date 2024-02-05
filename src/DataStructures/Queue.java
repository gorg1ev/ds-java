package DataStructures;

public class Queue<T> {
  private int size = 0;
  private Node<T> head = null;
  private Node<T> tail = null;

  public static class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T data, Node<T> next) {
      this.data = data;
      this.next = next;
    }
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void enqueue(T data) {
    if (isEmpty())
      head = tail = new Node<T>(data, null);
    else {
      tail.next = new Node<T>(data, null);
      tail = tail.next;
    }

    size++;
  }

  public void dequeue() {
    if (isEmpty())
      throw new RuntimeException("Queue is empty");

    head = head.next;
    size--;
  }

  public T peek() {
    if (isEmpty())
      throw new RuntimeException("Queue is empty");

    return head.data;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[ ");
    Node<T> trav = head;
    while (trav != null) {
      sb.append(trav.data);
      if (trav.next != null)
        sb.append(", ");
      trav = trav.next;
    }
    sb.append(" ]");
    return sb.toString();
  }

}

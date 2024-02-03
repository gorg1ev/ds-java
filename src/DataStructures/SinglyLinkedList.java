package DataStructures;

public class SinglyLinkedList<T> {
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

    public T getValue() {
      return data;
    }

    public Node<T> getNextNode() {
      if (next == null)
        throw new RuntimeException("There is no next node");
      return next;
    }

    public T getNextValue(Node<T> node) {
      return node.getValue();
    }
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void shift(T data) {
    if (isEmpty()) {
      head = tail = new Node<T>(data, null);
    } else {
      head = new Node<T>(data, head);
    }

    size++;
  }

  public void push(T data) {
    if (isEmpty()) {
      head = tail = new Node<T>(data, null);
    } else {
      tail.next = new Node<T>(data, null);
      tail = tail.next;
    }

    size++;
  }

  public void insert(int index, T data) {
    if (index < 0 || index > size)
      throw new RuntimeException("Illegal Index.");

    if (index == 0) {
      shift(data);
      return;
    }

    if (index == size) {
      push(data);
      return;
    }

    Node<T> shift = head;
    for (int i = 0; i < index - 1; i++) {
      shift = shift.next;
    }

    shift.next = new Node<T>(data, shift.next);

    size++;
  }

  public T unShift() {
    if (isEmpty())
      throw new RuntimeException("List is empty.");

    T data = head.data;
    head = head.next;
    size--;

    if (isEmpty())
      tail = null;

    return data;
  }

  public T pop() {
    if (isEmpty())
      throw new RuntimeException("List is empty.");

    Node<T> prevLast = head;

    for (int i = 0; i < size - 2; i++) {
      prevLast = prevLast.next;
    }
    T data = prevLast.next.data;
    prevLast.next = null;
    tail = prevLast;
    size--;

    if (isEmpty())
      tail = null;

    return data;
  }

  public T remove(int index) {
    if (index < 0 || index >= size) {
      throw new RuntimeException("Illegal Index.");
    }

    if (isEmpty())
      throw new RuntimeException("List is empty");

    if (index == 0)
      unShift();

    if (index == size - 1)
      pop();

    Node<T> prevNode = at(index - 1);
    T data = prevNode.next.data;

    prevNode.next = prevNode.next.next;
    size--;

    return data;
  }

  public Node<T> getHead() {
    if (isEmpty())
      throw new RuntimeException("List is empty");

    return head;
  }

  public Node<T> getTail() {
    if (isEmpty())
      throw new RuntimeException("List is empty");

    return tail;
  }

  public int indexOf(T elm) {
    if (isEmpty())
      throw new RuntimeException("List is empty");

    if (elm == null)
      throw new RuntimeException("None");


    int index = 0;
    Node<T> trev = head;
    while (trev != null) {
      if (trev.data.equals(elm))
        break;

      trev = trev.next;
      index++;
    }

    return index;
  }

  public Node<T> at(int index) {
    if (isEmpty())
      throw new RuntimeException("List is empty");

    if (index < 0 || index >= size)
      throw new RuntimeException("Illegal Index.");

    Node<T> trev = head;
    for (int i = 0; i < size - 1; i++) {
      if (i == index)
        break;

      trev = trev.next;
    }

    return trev;
  }

  public void reverse() {
    if (isEmpty())
      throw new RuntimeException("List is empty");

    tail = head;
    Node<T> current = head;
    Node<T> prev = null;
    Node<T> next = null;

    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }

    head = prev;
  }

  public void clear() {
    if (isEmpty())
      throw new RuntimeException("List is empty");

    Node<T> trev = head;

    while (trev != null) {
      Node<T> next = trev.next;
      trev.data = null;
      trev.next = null;
      trev = next;
    }
    head = tail = null;
    size = 0;
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

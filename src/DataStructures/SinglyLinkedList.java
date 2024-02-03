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

  public void insert(int index, T data) throws Exception {
    if (index < 0 || index > size)
      throw new Exception("Illegal Index.");

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

  public void unShift() throws Exception {
    if (isEmpty())
      throw new Exception("List is empty.");

    head = head.next;
    size--;

    if (isEmpty())
      tail = null;
  }

  public void pop() throws Exception {
    if (isEmpty())
      throw new Exception("List is empty.");

    Node<T> prevLast = head;

    for (int i = 0; i < size - 2; i++) {
      prevLast = prevLast.next;
    }
    prevLast.next = null;
    tail = prevLast;
    size--;

    if (isEmpty())
      tail = null;
  }

  public void remove(int index) throws Exception {
    if (index < 0 || index >= size) {
      throw new Exception("Illegal Index.");
    }

    if (index == 0) {
      unShift();
      return;
    }

    if (index == size - 1) {
      pop();
      return;
    }

    Node<T> prevNode = head;
    for (int i = 0; i < index - 1; i++) {
      prevNode = prevNode.next;
    }

    prevNode.next = prevNode.next.next;
    size--;
  }

  public Node<T> getHead() {
    return head;
  }

  public Node<T> getTail() {
    return tail;
  }

  public T getHeadValue() {
    return head.data;
  }

  public T getTailValue() {
    return tail.data;
  }

  public int indexOf(T elm) throws Exception {
    if (elm == null)
      throw new Exception("None");

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

  public Node<T> at(int index) throws Exception {
    if (index < 0 || index >= size)
      throw new Exception("Illegal Index.");

    Node<T> trev = head;
    for (int i = 0; i < size - 1; i++) {
      if (i == index)
        break;

      trev = trev.next;
    }

    return trev;
  }

  public void reverse() {
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

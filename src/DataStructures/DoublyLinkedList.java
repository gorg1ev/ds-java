package DataStructures;

public class DoublyLinkedList<T> {
  private int size = 0;
  private Node<T> head = null;
  private Node<T> tail = null;

  public static class Node<T> {
    private T data;
    private Node<T> prev;
    private Node<T> next;

    public Node(T data, Node<T> prev, Node<T> next) {
      this.data = data;
      this.prev = prev;
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
      return node.next.getValue();
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
      head = tail = new Node<T>(data, null, null);
    } else {
      Node<T> newHead = new Node<T>(data, null, head);
      head.prev = newHead;
      head = newHead;
    }

    size++;
  }

  public void push(T data) {
    if (isEmpty()) {
      head = tail = new Node<T>(data, null, null);
    } else {
      Node<T> newTail = new Node<T>(data, tail, null);
      tail.next = newTail;
      tail = newTail;
    }

    size++;
  }

  public void insert(int index, T data) {
    if (isEmpty())
      throw new RuntimeException("List is empty");

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

    Node<T> trav = head;
    for (int i = 0; i < index - 1; i++) {
      trav = trav.next;
    }

    Node<T> newNode = new Node<T>(data, trav, trav.next);
    trav.next.prev = newNode;
    trav.next = newNode;
    size++;
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

  public Node<T> at(int index) {
    if (isEmpty())
      throw new RuntimeException("List is emtpy");

    if (index < 0 || index >= size)
      throw new RuntimeException("Illegal Index");

    if (index == 0)
      return getHead();
    if (index == size - 1)
      return getTail();

    Node<T> trav;
    if (index < size / 2) {
      trav = head;
      for (int i = 1; i <= index; i++) {
        trav = trav.next;
      }
    } else {
      trav = tail;
      for (int i = size - 2; i >= index; i--) {
        trav = trav.prev;
      }
    }

    return trav;
  }

  public int indexOf(T elm) {
    if (isEmpty())
      throw new RuntimeException("List is empty");

    int index = 0;
    Node<T> trav = head;
    while (trav != null) {
      if (trav.data == elm)
        break;

      trav = trav.next;
      index++;
    }

    if (index == size)
      return -1;

    return index;
  }

  public T unShift() {
    if (isEmpty())
      throw new RuntimeException("List is empty.");

    T data = head.data;
    head = head.next;
    head.prev = null;
    size--;

    if (isEmpty())
      tail = null;

    return data;
  }

  public T pop() {
    if (isEmpty()) {
      throw new RuntimeException("List is empty.");
    }

    T data = tail.data;
    tail = tail.prev;
    tail.next = null;
    size--;

    if (isEmpty())
      head = null;

    return data;
  }

  public void remove(int index) {
    if (isEmpty())
      throw new RuntimeException("List is empty");

    if (index < 0 || index >= size)
      throw new RuntimeException("Illegal Index");

    if (index == 0) {
      unShift();
      return;
    }

    if (index == size - 1) {
      pop();
      return;
    }


    size--;
  }

  public void reverse() {
    if (isEmpty())
      throw new RuntimeException("List is empty");;

    Node<T> current = head;
    Node<T> temp = null;

    while (current != null) {
      temp = current.prev;
      current.prev = current.next;
      current.next = temp;

      current = current.prev;
    }

    temp = head;
    head = tail;
    tail = head;
  }

  public void clear() {
    if (isEmpty())
      throw new RuntimeException("List is empty");


    Node<T> trav = head;

    while (trav != null) {
      Node<T> next = trav.next;
      trav.prev = trav.next = null;
      trav.data = null;
      trav = next;
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

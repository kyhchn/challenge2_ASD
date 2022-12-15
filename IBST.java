public interface IBST<T extends Comparable<T>> {
  public void add(Node<T> node);
  public int degree(Node<T> node);
  public int count();
  public Node<T> get(int key, Node<T> root);
  public Node<T> getMin(Node<T> node);
  public Node<T> getMax(Node<T> node);
  public Node<T> parent(Node<T> node);
  public Node<T> delete(int key);
  public Object[] toArray();
  public Object[] sort(Object[] tArray);
  public void print(Object[] tArray);
}

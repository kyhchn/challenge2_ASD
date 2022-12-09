public class BST<T> implements IBST<T> {
  Node<T> root;

  public BST(Node<T> root) {
    this.root = root;
  }

  @Override
  public String toString() {
    return preOrder(this.root);
  }

  public String preOrder(Node<T> n) {
    if (n == null)
      return "";
    String out = String.format(" %s; ", n.data.toString());
    out += preOrder(n.lt);
    out += preOrder(n.rt);
    return out;
  }

  // hitung degree dari suatu node
  @Override
  public int degree(Node<T> node) {
    // TODO Auto-generated method stub
    if (node.lt == null && node.rt == null) {
      return 0;
    } else if (node.lt == null || node.rt == null) {
      return 1;
    }
    return 2;
  }

  // hitung jumlah node yang ada di dalam BST
  @Override
  public int count() {
    // TODO Auto-generated method stub

    return 0;
  }

  // tambahkan node,
  // dan letakkan node dalam BST
  // sesuai nilai atribut int objek T
  @Override
  public void add(Node<T> node) {
    // TODO Auto-generated method stub

  }

  // get node dalam BST
  // yang memiliki atribut int objek T sama dengan key
  // dan dicari dari root node
  // yang ditentukan dari parameter root
  @Override
  public Node<T> get(int key, Node<T> root) {
    if (root.key == key)
      return root;
    Node<T> temp = null;
    if (root.lt != null)
      temp = get(key, root.lt);
    if (temp != null)
      return temp;
    if (root.rt != null)
      temp = get(key, root.rt);
    return temp;
  }

  // get node dengan atribut int objek T minimum
  // yang diawali dari subtree
  // dengan root node yang ditentukan lewat parameter
  @Override
  public Node<T> getMin(Node<T> node) {
    if (node == null)
      return null;
    return node.lt != null ? getMin(node.lt) : node;
  }

  // get node dengan atribut int objek T maksimum
  // yang diawali dari subtree
  // dengan root node yang ditentukan lewat parameter
  @Override
  public Node<T> getMax(Node<T> node) {
    if (node == null)
      return null;
    return node.rt != null ? getMax(node.rt) : node;
  }

  // get parent node dari suatu node
  @Override
  public Node<T> parent(Node<T> node) {
    Node<T> temp = root;
    while (temp!=null) {
      if(temp.lt.key == node.key || temp.rt.key == node.key){
        return temp;
      }else{
        if(node.key>temp.key){
          temp = temp.rt;
        }else{
          temp = temp.lt;
        }
      }
    }return null;
  }

  // hapus node dalam BST yang memiliki
  // atribut int sama dengan key
  @Override
  public Node<T> delete(int key) {
    // TODO Auto-generated method stub
    return null;
  }

  // traverse BST, simpan ke dalam array
  // return array
  @Override
  public T[] toArray() {
    // TODO Auto-generated method stub
    return null;
  }

  // array yang dihasilkan dari toArray()
  // urutkan berdasarkan atribut int objek T
  // teknik sorting bebas
  @Override
  public T[] sort(T[] tArray) {
    // TODO Auto-generated method stub
    return null;
  }

  // print array yang dihasilkan dari toArray()
  @Override
  public void print(T[] tArray) {
    // TODO Auto-generated method stub

  }
}

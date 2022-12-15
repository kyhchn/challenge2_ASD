import java.util.LinkedList;
import java.util.List;

public class BST<T extends Comparable<T>> implements IBST<T> {
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
    int res = 0;
    if (node.lt != null)
      res++;
    if (node.rt != null)
      res++;
    return res;
  }

  // hitung jumlah node yang ada di dalam BST
  @Override
  public int count() {
    List<T> nodes = new LinkedList<>();
    postOrderTravers(nodes, root);
    return nodes.size();
  }

  // tambahkan node,
  // dan letakkan node dalam BST
  // sesuai nilai atribut int objek T
  @Override
  public void add(Node<T> newNode) {
    Node<T> pointerNode = root;
    Node<T> parentPNode = null;
    boolean isUnique = true;
    if (pointerNode == null) {
      root = newNode;
    } else {
      while (pointerNode != null) {
        parentPNode = pointerNode;
        if (pointerNode.key != newNode.key) {
          if (newNode.key < pointerNode.key) {
            pointerNode = pointerNode.lt;
          } else {
            pointerNode = pointerNode.rt;
          }
        } else {
          isUnique = false;
          break;
        }
      }
      if (isUnique) {
        if (parentPNode.key > newNode.key) {
          parentPNode.lt = newNode;
        } else {
          parentPNode.rt = newNode;
        }
      }
    }

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
    if (node == null) {
      return null;
    }
    Node<T> temp = root;
    Node<T> parent = null;
    while (temp != null) {
      if (node.key < temp.key) {
        parent = temp;
        temp = temp.lt;
      } else if (node.key > temp.key) {
        parent = temp;
        temp = temp.rt;
      } else {
        return parent;
      }
    }
    return null;
  }

  // hapus node dalam BST yang memiliki
  // atribut int sama dengan key
  @Override
  public Node<T> delete(int key) {
    Node<T> targetNode = get(key, root);
    int degree = degree(targetNode);
    Node<T> parent = parent(targetNode);
    switch (degree) {
      case 0:
        if (parent.key > targetNode.key)
          parent.lt = null;
        else
          parent.rt = null;
        break;
      case 1:
        Node<T> child = targetNode.lt == null ? targetNode.rt : targetNode.lt;
        if (parent.key > child.key)
          parent.lt = child;
        else
          parent.rt = child;
        targetNode.lt = null;
        targetNode.rt = null;
        break;
      case 2:
        Node<T> leftMax = getMax(targetNode.lt);
        delete(leftMax.key);
        targetNode.data = leftMax.data;
        targetNode.key = leftMax.key;
        break;

    }
    return targetNode;
  }

  // traverse BST, simpan ke dalam array
  // return array
  @Override
  public Object[] toArray() {
    List<T> list = new LinkedList<>();
    postOrderTravers(list, root);
    Object[] array = new Object[list.size()];
    for (int i = 0; i < list.size(); i++) {
      array[i] = list.get(i);
    }
    return array;
  }

  // array yang dihasilkan dari toArray()
  // urutkan berdasarkan atribut int objek T
  // teknik sorting bebas
  @Override
  public Object[] sort(Object[] tArray) {
    for (int i = 1; i < tArray.length; i++) {
      T data = (T) tArray[i];
      int j = i - 1;
      while (j >= 0 && ((T) tArray[j]).compareTo(data) == 1) {
        T temp = (T) tArray[j];
        tArray[j] = tArray[j + 1];
        tArray[j + 1] = temp;
        j--;
      }
    }
    return tArray;
  }

  // print array yang dihasilkan dari toArray()
  @Override
  public void print(Object[] tArray) {
    System.out.print("[");
    for (int i = 0; i < tArray.length; i++) {
      System.out.print(tArray[i].toString());
      if (i != tArray.length - 1)
        System.out.print(", ");
    }
    System.out.print("]\n");
  }

  void postOrderTravers(List<T> aList, Node<T> node) {
    if (node != null) {
      postOrderTravers(aList, node.lt);
      postOrderTravers(aList, node.rt);
      aList.add(node.data);
    }
  }
}

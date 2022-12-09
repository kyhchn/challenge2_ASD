public class App {
  public static void main(String[] args) {

    Mobil prelude = new Mobil(1998, "Honda Prelude");
    BST<Mobil> tree = new BST<>(new Node<Mobil>(prelude.tahun, prelude));
    
    // bangun tree (BST) sesuai urutan masuknya mobil 
    // yang diuraikan dalam studi kasus
    // manfaatkan method: public void add(Node<T> node);

    tree.toString(); // untuk melihat isi tree

    // demokan semua method:
    // public int degree(Node<T> node);
    // public int count();
    // public Node<T> get(int key, Node<T> root);
    // public Node<T> getMin(Node<T> node);
    // public Node<T> getMax(Node<T> node);
    // public Node<T> parent(Node<T> node);
    // public Node<T> delete(int key);

    tree.toString(); // untuk melihat isi tree sesudah node di-delete

    Mobil[] mobils = tree.toArray(); // ubah BST menjadi array
    tree.sort(mobils); // sort array
    tree.print(mobils); // tampilkan array yang telah diurutkan


  }
}

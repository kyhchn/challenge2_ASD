public class App {
  public static void main(String[] args) {

    Mobil prelude = new Mobil(1998, "Honda Prelude");
    Mobil pajero = new Mobil(2010, "Pajero Stronk");
    Mobil avanza = new Mobil(2017, "Toyota Avanza");
    Mobil kijang = new Mobil(1970, "Toyota Kijang");
    BST<Mobil> tree = new BST<>(new Node<Mobil>(prelude.tahun, prelude));
    tree.add(new Node<Mobil>(pajero.tahun, pajero));
    tree.add(new Node<Mobil>(avanza.tahun, avanza));
    tree.add(new Node<Mobil>(kijang.tahun, kijang));

    System.out.println("Inorder traverse "+tree.toString());
    System.out.print("PostOrder traverse: ");
    tree.print(tree.toArray());
    System.out.println("setelah sorting");
    Object[] objects = tree.toArray();
    tree.sort(objects); 
    tree.print(objects);

    System.out.println("ukurannya : " + tree.count());

    System.out.println(tree.get(2017, tree.root));

    System.out.println("Mobil terlawas " + tree.getMin(tree.root));
    System.out.println("Mobil terbaru " + tree.getMax(tree.root));

    System.out.println("Parent dari " + tree.get(2017, tree.root) + tree.parent(tree.get(2017, tree.root)));
    System.out.println("Parent dari " + tree.get(2010, tree.root) + tree.parent(tree.get(2010, tree.root)));
    System.out.println("Parent dari " + tree.get(1970, tree.root) + tree.parent(tree.get(1970, tree.root)));

    System.out.println("DELETE");
    System.out.print("kondisi awal ");
    tree.print(tree.sort(tree.toArray()));
    Node<Mobil> deleteNode = null;
    deleteNode = tree.get(1998, tree.root);
    // deleteNode = tree.get(2017, tree.root);
    // deleteNode = tree.get(2010, tree.root);
    System.out.println("Delete tree " + deleteNode + " degree = " + tree.degree(deleteNode));
    tree.delete(1998);
    // tree.delete(2017);
    // tree.delete(2010);
    tree.print(tree.sort(tree.toArray()));
  }
}

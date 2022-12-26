public class App {
  public static void main(String[] args) {

    Mobil mobil1 = new Mobil(1998,"Honda prelude");
    Mobil mobil2 = new Mobil( 1972,"Jeep Wrangler");
    Mobil mobil3 = new Mobil( 1983,"Suzuki Jimmy");
    Mobil mobil4 = new Mobil(1967, "Mazda RX 87" );
    Mobil mobil5 = new Mobil( 2007,"Fiat 500");
    Mobil mobil6 = new Mobil( 1958, "Mercedes Benz 220");
    BST<Mobil> tree = new BST<>(new Node<Mobil>(mobil1.tahun, mobil1));
    tree.add(new Node<Mobil>(mobil2.tahun, mobil2));
    tree.add(new Node<Mobil>(mobil3.tahun, mobil3));
    tree.add(new Node<Mobil>(mobil4.tahun, mobil4));
    tree.add(new Node<Mobil>(mobil5.tahun, mobil5));
    tree.add(new Node<Mobil>(mobil6.tahun, mobil6));

    System.out.println("Inorder traverse "+tree.toString());
    System.out.print("PostOrder traverse: ");
    tree.print(tree.toArray());
    System.out.println("setelah sorting");
    Object[] objects = tree.toArray();
    tree.sort(objects); 
    tree.print(objects);

    System.out.println("ukurannya : " + tree.count());

    System.out.println(tree.get(2007, tree.root));

    System.out.println("Mobil terlawas " + tree.getMin(tree.root));
    System.out.println("Mobil terbaru " + tree.getMax(tree.root));

    // System.out.println("Parent dari " + tree.get(2017, tree.root) + tree.parent(tree.get(2017, tree.root)));

    System.out.println(tree);

    tree.delete(1972);

    System.out.println(tree);
    // System.out.println("DELETE");
    // System.out.print("kondisi awal ");
    // tree.print(tree.sort(tree.toArray()));
    // Node<Mobil> deleteNode = null;
    // deleteNode = tree.get(1998, tree.root);
    // // deleteNode = tree.get(2017, tree.root);
    // // deleteNode = tree.get(2010, tree.root);
    // System.out.println("Delete tree " + deleteNode + " degree = " + tree.degree(deleteNode));
    // tree.delete(1998);
    // // tree.delete(2017);
    // // tree.delete(2010);
    // tree.print(tree.sort(tree.toArray()));
  }
}


import BST.Binary_Search_Tree;
import DLL.Doubly_Linked_List;

public class main {
	public static void main(String[] args) throws Exception {

		// Doubly_Linked_List d_linkedlist = new Doubly_Linked_List();
		// d_linkedlist.add(5);
		// d_linkedlist.add(2);
		// d_linkedlist.add(3);
		// d_linkedlist.add(4);

		// // d_linkedlist.simpleSearch(2);

		// String testy = d_linkedlist.print_nodes();
		// System.out.println(testy);

		// d_linkedlist.simpleSort();
		// System.out.println("---------------------");

		// d_linkedlist.print_nodes();

		// Doubly_Linked_List sorted = d_linkedlist.insertionSort();

		// sorted.print_nodes();

		// d_linkedlist.fastSearch(3);

Binary_Search_Tree<Integer> bst = new Binary_Search_Tree<>();

        // Add nodes
        bst.addNode(50);
        bst.addNode(30);
        bst.addNode(70);
        bst.addNode(20);
        bst.addNode(40);
        bst.addNode(60);
        bst.addNode(80);

		System.out.println(bst.root);

		//bst.preOrderTraversal(bst.root);
		//bst.inOrderTraversal(bst.root);
		bst.postOrderTraversal(bst.root);
	}

	public static void linkedlist(String[] args) throws Exception {

	}

}

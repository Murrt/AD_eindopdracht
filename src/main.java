package src;

import DLL.Doubly_Linked_List;

public class main {
	public static void main(String[] args) throws Exception {

		Doubly_Linked_List d_linkedlist = new Doubly_Linked_List();
		d_linkedlist.add(5);
		d_linkedlist.add(2);
		d_linkedlist.add(3);
		d_linkedlist.add(4);

		d_linkedlist.simpleSearch(2);

		// d_linkedlist.print_nodes();

		// d_linkedlist.simpleSort();
		// System.out.println("---------------------");

		// d_linkedlist.print_nodes();

		// Doubly_Linked_List sorted = d_linkedlist.insertionSort();

		// sorted.print_nodes();

		// d_linkedlist.fastSearch(3);

	}

	public static void linkedlist (String[] args) throws Exception {

	}
	
}

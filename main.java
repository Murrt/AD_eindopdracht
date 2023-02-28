import java.util.ArrayList;

public class main {
	public static void main(String[] args) {
		Doubly_Linked_List d_linkedlist = new Doubly_Linked_List();

		Doubly_ListNode node1 = new Doubly_ListNode(1);
		Doubly_ListNode node2 = new Doubly_ListNode(2);
		Doubly_ListNode node3 = new Doubly_ListNode(3);

		node1.next = node2;
		node2.prev = node1;
		node2.next = node3;
		node3.prev = node2;

		// ArrayList<Doubly_ListNode> result = d_linkedlist.remove(node2);
		d_linkedlist.print_nodes(node2);

	}

		

	// public static void main(String[] args) {
	// 	Linked_List linkedlist = new Linked_List();

	// 	ListNode node1 = new ListNode(1);
	// 	ListNode node2 = new ListNode(2);
	// 	ListNode node3 = new ListNode(3);

	// 	node1.next = node2;
	// 	node2.next = node3;
	// 	node3.next = null;

	// 	ListNode node0 = linkedlist.add(0, node1);

	// 	linkedlist.print_nodes(node0);


	// 	linkedlist.print_nodes(node0);

	// 	linkedlist.remove(node1);	


	// }
}

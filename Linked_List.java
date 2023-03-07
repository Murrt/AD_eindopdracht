public class Linked_List {

	private ListNode head;
    private ListNode tail;
	public static void main(String[] args) {
	}

	public void remove(ListNode node) {
		ListNode prev_node = null;
		// in linked list kan alleen een node zonder next verwijderd worden omdat je
		// anders een deel van de link verwijderd. pop()
		while (node.next != null) {
			System.out.println(node.next);
			prev_node = node;
			node = node.next;
		}
		System.out.println(node + " removed");
		prev_node.next = null;
	}

	public ListNode add(Integer data,ListNode next_node) {
		return new ListNode(data, next_node);
	}

	public void print_nodes(ListNode node) {
		System.out.println("print");
		while (node.next != null) {
			System.out.println(node.toString());
			node = node.next;
		}
		System.out.println(node.toString());
	}
}
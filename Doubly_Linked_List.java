import java.util.ArrayList;

public class Doubly_Linked_List {

    private Doubly_ListNode head;
    private Doubly_ListNode tail;

    public static void main(String[] args) {

    }

    public ArrayList<Doubly_ListNode> remove(Doubly_ListNode node) {
        Doubly_ListNode prev_node = node.prev;
        Doubly_ListNode next_node = node.next;
        prev_node.next = next_node;
        next_node.next = prev_node;

        node.data = null;

        ArrayList<Doubly_ListNode> returnval = new ArrayList<Doubly_ListNode>();
        if (prev_node != null) {
            returnval.add(prev_node);
        }
        returnval.add(node);
        if (next_node != null) {
            returnval.add(next_node);

        }
        return returnval;
    }

    public void print_nodes(Doubly_ListNode node) {
        // naar het begin van de nodes
        while (node.prev != null) {
            node = node.next;
        }
        // print alle nodes
        while (node.next != null) {
            System.out.println(node.toString());
            node = node.next;
        }
        System.out.println(node.toString());
    }

    public int aantal_nodes() {
        int counter = 0;
        Doubly_ListNode node = head;
        while (node.next != tail) {
            counter++;
        }
        return counter;
    }

    public void add(int index, int data) {
        Doubly_ListNode node = new Doubly_ListNode();
        if (head == null) {
            head = node;
            tail = node;
        } else if (index == 0) {
            node.next = head;
            head.prev = node;
            head = node;
        } else if (aantal_nodes() == index) {
            node.prev = tail;
            tail.next = node;
            tail = node;
        } else {
            Doubly_ListNode nodeRef = head;
            for (int i = 1; i < index; i++) {
                nodeRef = nodeRef.next;
                node.next = nodeRef.next;
                nodeRef.next = node;
                node.prev = nodeRef;
                node.next.prev = node;
            }
        }
    }

}

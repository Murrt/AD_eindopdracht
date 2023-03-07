package src.LL;

public class Linked_List {

    public ListNode head;
    public ListNode tail;
    public int nodeCount = 0;

    public static void main(String[] args) {

    }

    public void remove(Integer index) throws Exception {
        if (index < 1 || index > nodeCount) {
            throw new Exception("ongeldige index");
        } else {

            ListNode current = head;
            ListNode last_ref;
            ListNode next_ref;

            for (Integer i = 0; i < nodeCount; i++) {
                System.out.print(current.data);
                current = current.next;
            }
            // [0,1][1,2][2,3][3,4]
        }

        nodeCount--;
    }

    public void print_nodes() {
        ListNode node = head;
        // loop door alle nodes
        for (int i = 1; i <= nodeCount; i++) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    public void add(Integer data) {

        ListNode node = new ListNode();
        node.data = data;

        if (tail == null) {
            tail = node;
        }

        // Make next of new node as head and previous as null /
        node.next = head;

        // change prev of head node to new node /
        if (head != null) {
            node.next = head;
        }

        // move the head to point to the new node /
        head = node;

        nodeCount++;
    }

    public Linked_List insertionSort() {

        Linked_List sorted = new Linked_List();
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            // current.prev = current.next = null;
            sorted = sortedInsert(sorted, current);
            current = next;
        }

        // maakt laatste value tail
        ListNode current_2 = head;

        for (int i = 1; i < sorted.nodeCount; i++) {
            ListNode pointer = current_2.next;
            current_2 = pointer;
        }
        sorted.tail = current_2.next; // !!!
        sorted.tail.next = null;

        return sorted;
    }

    static Linked_List sortedInsert(Linked_List sorted, ListNode newNode) {
        // check of eerste insert is
        if (sorted.head == null) {
            sorted.head = newNode;
        } else {
            // check of we gewoon head kunnen opschuiven
            if ((sorted.head).data >= newNode.data) {
                newNode.next = sorted.head;
                sorted.head = newNode;
            } else {
                // loop door de rest waar de node hoort
                ListNode current = sorted.head;
                for (int i = 1; i < sorted.nodeCount; i++) {
                    if (current.next.data < newNode.data) {
                        current = current.next;
                        newNode.next = current.next;
                    }
                }
                // insert de node
                if (current.next != null) {
                    newNode.next = current.next;
                    current.next = newNode;
                }
            }
        }
        sorted.nodeCount++;
        return sorted;
    }

    public Boolean simpleSearch(Integer data) throws Exception {
        // check of lijst niet leeg is
        if (head != null) {
            // loop door lijst vanaf head op match met data
            ListNode current = head;
            for (int i = 1; i < nodeCount; i++) {
                if (current.data == data) {
                    return true;
                }
                if (current.next != null) {
                    current = current.next;
                }
            }
        } else {
            throw new Exception("Doubly linked list heeft geen head");
        }
        return false;
    }

    void fastSearch(Integer data) throws Exception {
        // werkt alleen op gesorteerde lijst!
        Integer headDistance = Math.abs(head.data - data);
        Integer tailDistance = Math.abs(tail.data - data);

        // check of data in head of tail zit
        if (headDistance == 0 || tailDistance == 0) {
            System.out.println("Gevonden!");
            // check of
        } else {
            simpleSearch(data);
        }
    }

    void simpleSort() {
        ListNode current = null, index = null;
        int data;
        if (head == null) {
            return;
        } else {
            for (current = head; current.next != null; current = current.next) {
                for (index = current.next; index != null; index = index.next) {
                    if (current.data > index.data) {
                        data = current.data;
                        current.data = index.data;
                        index.data = data;
                    }
                }
            }
        }
    }
}
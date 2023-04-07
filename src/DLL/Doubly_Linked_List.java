package DLL;

import java.util.LinkedList;
import java.util.List;

public class Doubly_Linked_List {

    public Doubly_ListNode head;
    public Doubly_ListNode tail;
    public int nodeCount = 0;

    public static void main(String[] args) {

    }

    public void remove(Integer index) throws Exception {
        if (index < 0 || index > nodeCount) {
            throw new Exception("Ongeldige index aangeleverd");
        }

        if (index == nodeCount) {
            tail = tail.prev;
        } else if (index == 1) {
            head = head.next;
        } else {
            // zoek naar juiste node
            Doubly_ListNode node = head;
            for (int i = 1; i < index; i++) {
                if (node.next != null) {
                    node = node.next;
                }
            }

            // koppel node die ervoor zit aan die erachter en andersom.
            Doubly_ListNode prev_node = node.prev;
            Doubly_ListNode next_node = node.next;
            prev_node.next = next_node;
            next_node.next = prev_node;
        }
        nodeCount--;
    }

    public String print_nodes() {
        List<String> strings = new LinkedList<>();
        Doubly_ListNode node = head;
        
        // loop door alle nodes
        for (int i = 1; i < nodeCount; i++) {
            System.out.println(node.data);
            strings.add(Integer.toString(node.data));
            node = node.next;
        }

        System.out.println(node.data);
        strings.add(Integer.toString(node.data));

        String message = String.join(",", strings);
        return message;
    }

    public void add(Integer data) {

        Doubly_ListNode node = new Doubly_ListNode();
        node.data = data;

        if (tail == null) {
            tail = node;
        }

        // Make next of new node as head and previous as null /
        node.next = head;
        node.prev = null;

        // change prev of head node to new node /
        if (head != null) {
            head.prev = node;
        }

        // move the head to point to the new node /
        head = node;

        nodeCount++;
    }

    public Doubly_Linked_List insertionSort() {

        Doubly_Linked_List sorted = new Doubly_Linked_List();
        Doubly_ListNode current = head;

        while (current != null) {
            Doubly_ListNode next = current.next;
            // current.prev = current.next = null;
            sorted = sortedInsert(sorted, current);
            current = next;
        }

        // maakt laatste value tail
        Doubly_ListNode current_2 = sorted.head;

        for (int i = 1; i < sorted.nodeCount; i++) {
            Doubly_ListNode pointer = current_2.next;
            current_2 = pointer;
        }
        sorted.tail = current_2; // !!!
        sorted.tail.next = null;

        return sorted;
    }

    static Doubly_Linked_List sortedInsert(Doubly_Linked_List sorted, Doubly_ListNode newNode) {
        // check of eerste insert is
        if (sorted.head == null) {
            sorted.head = newNode;
        } else {
            // check of we gewoon head kunnen opschuiven
            if ((sorted.head).data >= newNode.data) {
                newNode.next = sorted.head;
                newNode.next.prev = newNode;
                sorted.head = newNode;
            } else {
                // loop door de rest waar de node hoort
                Doubly_ListNode current = sorted.head;
                for (int i = 1; i < sorted.nodeCount; i++) {
                    if (current.next.data < newNode.data) {
                        current = current.next;
                        newNode.next = current.next;
                        if (current.next != null) {
                            newNode.next.prev = newNode;
                        }
                    }
                }
                // insert de node
                current.next = newNode;
                newNode.prev = current;
            }
        }

        sorted.nodeCount++;
        return sorted;
    }

    public Boolean simpleSearch(Integer data) throws Exception {
        // check of lijst niet leeg is
        if (head != null) {
            // loop door lijst vanaf head op match met data
            Doubly_ListNode current = head;
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

    public Boolean reverseSimpleSearch(Integer data) throws Exception {
        if (tail != null) {
            Doubly_ListNode current = tail;
            while (current.prev != null) {
                if (current.data == data) {
                    System.out.println("Gevonden!");
                    return true;
                }
                if (current.prev != null) {
                    current = current.prev;
                }
            }
            // bovenstaande loop skipt head
            if (head.data == data) {
                System.out.println("Gevonden!");
                return true;
            }
        } else {
            throw new Exception("Doubly linked list heeft geen tail");
        }

        return false;
    }

    public Boolean fastSearch(Integer data) throws Exception {
        // werkt alleen op gesorteerde lijst!
        Integer headDistance = Math.abs(head.data - data);
        Integer tailDistance = Math.abs(tail.data - data);

        // check of data in head of tail zit
        if (headDistance == 0 || tailDistance == 0) {
            System.out.println("Gevonden!");
            return true;
            // check of
        } else if (head.data < data || tail.data > data) {
            System.out.println("Niet gevonden!");
            return false;
        } else {
            if (headDistance > tailDistance) {
                System.out.println("vanaf head");
                return simpleSearch(data);
            } else {
                return reverseSimpleSearch(data);
            }
        }
    }

    public void simpleSort() {
        Doubly_ListNode current = null, index = null;
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
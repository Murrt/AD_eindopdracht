package DLL;

import java.util.LinkedList;
import java.util.List;

public class Doubly_Linked_List {

    public Doubly_ListNode head;
    public Doubly_ListNode tail;
    public int nodeCount;

    public Doubly_Linked_List() {
        this.head = null;
        this.tail = null;
        this.nodeCount = 0;
    }

    public static void main(String[] args) {

    }

    public long remove(Integer index) throws Exception {
        long startTime = System.nanoTime();

        if (index < 0 || index > nodeCount - 1) {
            throw new Exception("Invalid index provided");
        }
        if (index == 0 && nodeCount == 1) {
            head = null;
            tail = null;
        } else if (index == nodeCount) {
            tail = tail.prev;
        } else if (index == 1) {
            head = head.next;
            head.prev = null;
        } else {
            Doubly_ListNode node = head;
            for (int i = 1; i < index; i++) {
                if (node.next != null) {
                    node = node.next;
                }
            }

            Doubly_ListNode prev_node = node.prev;
            Doubly_ListNode next_node = node.next;
            prev_node.next = next_node;
            if (next_node != null) {
                next_node.prev = prev_node;
            }
        }
        nodeCount--;

        long endTime = System.nanoTime();
        long time = (endTime - startTime) / 100000;

        return time;
    }

    public String print_nodes() {
        List<String> strings = new LinkedList<>();
        Doubly_ListNode node = head;

        while (node != null) {
            System.out.println(node.data);
            strings.add(Integer.toString(node.data));
            node = node.next;
        }

        String message = String.join(",", strings);
        return message;
    }

    public void add(Integer data) {
        Doubly_ListNode node = new Doubly_ListNode(data);

        if (tail == null) {
            tail = node;
        }

        node.next = head;
        if (head != null) {
            head.prev = node;
        }
        head = node;

        nodeCount++;
    }

    public Object[] insertionSort() {
        Doubly_Linked_List sorted = new Doubly_Linked_List();
        Doubly_ListNode current = head;
        long startTime = System.nanoTime();

        while (current != null) {
            Doubly_ListNode next = current.next;
            sorted = sortedInsert(sorted, current);
            current = next;
        }

        long endTime = System.nanoTime();
        long time = (endTime - startTime) / 1000000;

        return new Object[] { sorted, time };
    }

    private Doubly_Linked_List sortedInsert(Doubly_Linked_List sorted, Doubly_ListNode newNode) {
        if (sorted.head == null) {
            sorted.head = newNode;
            sorted.tail = newNode;
            newNode.prev = null;
            newNode.next = null;
        } else {
            if (sorted.head.data.compareTo(newNode.data) >= 0) {
                newNode.next = sorted.head;
                newNode.next.prev = newNode;
                newNode.prev = null;
                sorted.head = newNode;
            } else if (sorted.tail.data.compareTo(newNode.data) <= 0) {
                newNode.prev = sorted.tail;
                newNode.prev.next = newNode;
                newNode.next = null;
                sorted.tail = newNode;
            } else {
                Doubly_ListNode current = sorted.head;
                while (current.next != null && current.next.data.compareTo(newNode.data) < 0) {
                    current = current.next;
                }
                newNode.next = current.next;
                newNode.next.prev = newNode;
                current.next = newNode;
                newNode.prev = current;
            }
        }

        sorted.nodeCount++;
        return sorted;
    }
    
    public Object[] simpleSearch(Integer data) throws Exception {
        boolean ret = false;
        long startTime = System.nanoTime();

        if (nodeCount > 0) {
            Doubly_ListNode current = head;
            while (current != null) {
                if (current.data.equals(data)) {
                    ret = true;
                    break;
                }
                current = current.next;
            }

            long endTime = System.nanoTime();
            long time = (endTime - startTime) / 1000000;

            return new Object[] { ret, time };
        }
        return new Object[] { ret, 0 };
    }

    public Object[] reverseSimpleSearch(Integer data) throws Exception {
        boolean ret = false;
        long startTime = System.nanoTime();

        Doubly_ListNode current = tail;
        while (current != null) {
            if (current.data.equals(data)) {
                ret = true;
                break;
            }
            current = current.prev;
        }

        long endTime = System.nanoTime();
        long time = (endTime - startTime) / 1000000;

        return new Object[] { ret, time };
    }

    public Object[] fastSearch(Integer data) throws Exception {
        Integer headDistance = Math.abs(head.data - data);
        Integer tailDistance = Math.abs(tail.data - data);
        long startTime = System.nanoTime();

        boolean res = false;

        if (headDistance == 0 || tailDistance == 0) {
            System.out.println("Found!");
            res = true;
        } else if (head.data.compareTo(data) < 0 || tail.data.compareTo(data) > 0) {
            System.out.println("Not found!");
            res = false;
        } else {
            if (headDistance > tailDistance) {
                System.out.println("From head");
                Object[] ss = simpleSearch(data);
                res = (boolean) ss[0];
                startTime += (long) ss[1];
            } else {
                System.out.println("From tail");
                Object[] ss = reverseSimpleSearch(data);
                res = (boolean) ss[0];
                startTime += (long) ss[1];
            }
        }

        long endTime = System.nanoTime();
        long time = (endTime - startTime) / 1000000;

        return new Object[] { res, time };
    }

    public long simpleSort() {
        long startTime = System.nanoTime();
        Doubly_ListNode current = null, index = null;
        int data;
        if (head == null) {
            return 0;
        } else {
            for (current = head; current.next != null; current = current.next) {
                for (index = current.next; index != null; index = index.next) {
                    if (current.data.compareTo(index.data) > 0) {
                        data = current.data;
                        current.data = index.data;
                        index.data = data;
                    }
                }
            }
        }

        long endTime = System.nanoTime();
        long time = (endTime - startTime) / 1000000;
        return time;
    }
}

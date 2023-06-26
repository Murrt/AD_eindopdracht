package LL;

import java.util.LinkedList;
import java.util.List;

public class Linked_List {

    public ListNode<Student> head;
    public ListNode<Student> tail;
    public int nodeCount = 0;

    public static void main(String[] args) {

    }

    public long remove(Integer index) throws Exception {
        long startTime = System.nanoTime();

        if (index < 0 || index >= nodeCount) {
            System.out.println(nodeCount);
            throw new Exception("ongeldige index");
        } else {
            if (index == 0) {
                // removing the first element must be handled specially
                head = head.next;
            } else {
                // loop to the node before the one we want to remove
                ListNode<Student> current = head;
                for (int i = 0; i < index - 1; i++) {
                    current = current.next;
                }
                // skip the node
                if (current.next != null && current.next.next != null) {
                    current.next = current.next.next;
                } else {
                    tail = current;
                    tail.next = null;
                }
            }
        }
        nodeCount--;
        long endTime = System.nanoTime();
        long time = (startTime - endTime) / 100000;

        return time;
    }

    public String print_nodes() {
        if (nodeCount == 0) {
            return null;
        }
        System.out.println("-----------------");
        System.out.println("Node count: " + nodeCount);
        System.out.println("Node head: " + head.data);
        // System.out.println("Node tail: " + tail.data);

        List<String> strings = new LinkedList<>();
        ListNode<Student> node = head;
        // loop through all nodes
        for (int i = 1; i <= nodeCount; i++) {
            if (node.data != null) {
                if (node.next != null) {
                    System.out.println("current: " + node.data + " next: " + node.next.data);
                } else {
                    System.out.println("current: " + node.data);
                }
                strings.add(Integer.toString(node.data.getStudentNumber()));
            }
            node = node.next;
        }

        String message = String.join(",", strings);
        System.out.println("-----------------");

        return message;
    }

    public void add(Student data) {
        ListNode<Student> node = new ListNode<>();
        node.data = data;

        if (tail == null) {
            tail = node;
        }

        // Make next of new node as head and previous as null
        node.next = null;

        // change prev of head node to new node
        if (head != null) {
            node.next = head;
        }

        // move the head to point to the new node
        head = node;

        nodeCount++;
    }

    public Object[] insertionSort() {

        Linked_List sorted = new Linked_List();
        ListNode<Student> current = head;
        long startTime = System.nanoTime();

        while (current != null) {
            ListNode<Student> next = current.next;
            sorted = sortedInsert(sorted, current);
            current = next;
        }

        // make last value tail
        ListNode<Student> current_2 = sorted.head;

        for (int i = 1; i <= sorted.nodeCount; i++) {
            ListNode<Student> pointer = current_2.next;
            current_2 = pointer;
        }

        sorted.tail = current_2; // !!!
        sorted.tail.next = null;

        long endTime = System.nanoTime();
        long time = (endTime - startTime) / 1000000;

        return new Object[] { sorted, time };
    }

    static Linked_List sortedInsert(Linked_List sorted, ListNode<Student> newNode) {
        // check if first insert
        if (sorted.head == null) {
            sorted.head = newNode;
        } else {
            // check if we can simply move the head
            if (sorted.head.data.compareTo(newNode.data) >= 0) {
                newNode.next = sorted.head;
                sorted.head = newNode;
            } else {
                // loop through the rest to find the correct position for the node
                ListNode<Student> current = sorted.head;
                while (current.next != null && current.next.data.compareTo(newNode.data) < 0) {
                    current = current.next;
                }
                // insert the node
                newNode.next = current.next;
                current.next = newNode;
            }
        }
        sorted.nodeCount++;
        return sorted;
    }

    public Object[] simpleSearch(Integer data) throws Exception {
        Boolean ret = false;
        long startTime = System.nanoTime();

        // check if the list is not empty
        if (head != null) {
            // loop through the list from head to find a match with the data
            ListNode<Student> current = head;
            System.out.println("Gezocht: " + data);

            for (int i = 0; i < nodeCount; i++) {
                if (current.data.getStudentNumber().equals(data)) {
                    System.out.println("Gevonden: " + current.data);
                    ret = true;
                }
                if (current.next != null) {
                    current = current.next;
                }
            }
        } else {
            throw new Exception("Doubly linked list heeft geen head");
        }

        long endTime = System.nanoTime();
        long time = (endTime - startTime) / 1000000;

        return new Object[] { ret, time };
    }

    public Object[] fastSearch(Integer data) throws Exception {

        Boolean ret = false;
        long startTime = System.nanoTime();

        if (nodeCount > 0) {
            // works only on a sorted list!
            Integer headDistance = Math.abs(head.data.compareTo(data));
            Integer tailDistance = Math.abs(tail.data.compareTo(data));

            // check if data is in head or tail
            if (headDistance == 0 || tailDistance == 0) {
                ret = true;
            } else {
                Object[] ss = simpleSearch(data);
                ret = (Boolean) ss[0];
                startTime += (long) ss[1];
            }

            long endTime = System.nanoTime();
            long time = (endTime - startTime) / 1000000;

            return new Object[] { ret, time };
        }

        return new Object[] { ret, 0 };
    }

    public long simpleSort() {
        ListNode<Student> current = null, index = null;
        long startTime = System.nanoTime();

        int data;
        if (head == null) {
            return 0;
        } else {
            for (current = head; current.next != null; current = current.next) {
                for (index = current.next; index != null; index = index.next) {
                    if (current.data.getStudentNumber() > index.data.getStudentNumber()) {
                        data = current.data.getStudentNumber();
                        current.data.setStudentNumber(index.data.getStudentNumber());
                        index.data.setStudentNumber(data);
                    }
                }
            }
        }

        long endTime = System.nanoTime();
        long time = (endTime - startTime) / 1000000;

        return time;
    }
}

package LL;

public class main {

    public static void main(String[] args) throws Exception {
        Linked_List linkedlist = new Linked_List();

        linkedlist.add(1);
        linkedlist.add(0);
        linkedlist.add(3);
        linkedlist.add(12);
        linkedlist.add(5);
        linkedlist.add(120);
        linkedlist.add(10);

        String print0 = linkedlist.print_nodes();
        System.out.println(print0);

        Linked_List sorted = linkedlist.insertionSort();
        linkedlist = sorted;

        String print = linkedlist.print_nodes();
        System.out.println(print);

    }

}

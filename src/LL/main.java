package LL;

public class main {

    public static void main(String[] args) throws Exception {
        Linked_List linkedlist = new Linked_List();

        linkedlist.add(1);
        linkedlist.add(12);
        linkedlist.add(3);
        linkedlist.add(4);
        linkedlist.add(19);
        linkedlist.add(7);

        Linked_List sorted = linkedlist.insertionSort();
        sorted.print_nodes();
        Linked_List sorted2 = sorted.insertionSort();
        sorted2.print_nodes();

    }

}

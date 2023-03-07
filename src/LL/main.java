package src.LL;

public class main {

    public static void main(String[] args) throws Exception {
        Linked_List linkedlist = new Linked_List();

        linkedlist.add(5);
        linkedlist.add(2);
        linkedlist.add(3);
        linkedlist.add(4);

        Linked_List sorted = linkedlist.insertionSort();

        sorted.print_nodes();

    }

}

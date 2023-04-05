package DLL;

public class main {

    public static void main(String[] args) throws Exception {
        Doubly_Linked_List dlinkedlist = new Doubly_Linked_List();

        dlinkedlist.add(5);
        dlinkedlist.add(2);
        dlinkedlist.add(3);
        dlinkedlist.add(4);

        String print0 = dlinkedlist.print_nodes();

        // System.out.println(print0);

        Doubly_Linked_List sorted = dlinkedlist.insertionSort();

        // String print = sorted.print_nodes();
        System.out.println(sorted.head.data);
        System.out.println(sorted.tail.data);

        // System.out.println(print);

    }

}

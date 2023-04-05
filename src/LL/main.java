package LL;

public class main {

    public static void main(String[] args) throws Exception {
        Linked_List linkedlist = new Linked_List();

        linkedlist.add(1);
        linkedlist.add(2);
        linkedlist.add(3);
        linkedlist.add(4);
        linkedlist.add(5);
        linkedlist.add(6);

        String print = linkedlist.print_nodes();
        System.out.println(print);

        linkedlist.remove(3);
        
        String print2 = linkedlist.print_nodes();
        System.out.println(print2);
    }

}

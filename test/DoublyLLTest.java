package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import DLL.Doubly_Linked_List;

public class DoublyLLTest {
    Doubly_Linked_List d_linkedlist = new Doubly_Linked_List();

    @BeforeEach
    void setLL() {
        d_linkedlist.add(5);
        d_linkedlist.add(2);
        d_linkedlist.add(3);
        d_linkedlist.add(4);
    }

    @Test
    void printTest() throws Exception {
        String testy = d_linkedlist.print_nodes();
        System.out.println(testy);
    }

    @Test
    void addAndRemoveTest() throws Exception {
    d_linkedlist.remove(1);
    assertEquals(d_linkedlist.nodeCount, 3);
    d_linkedlist.add(4);
    assertEquals(d_linkedlist.nodeCount, 4);
    }

    @Test
    void insertionSort() throws Exception {
        Doubly_Linked_List sorted = d_linkedlist.insertionSort();
        assertEquals(sorted.head.data, 2);
        assertEquals(sorted.tail.data, 5);
    }

    @Test
    void simpleSearchTest() throws Exception {
        Boolean res = d_linkedlist.simpleSearch(2);
        assertEquals(true, res);
    } 
}

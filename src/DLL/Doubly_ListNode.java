package src.DLL;
public class Doubly_ListNode {

    public int data;
    public Doubly_ListNode prev;
    public Doubly_ListNode next;
    public Doubly_ListNode head;

    public Doubly_ListNode() {
        this.data = 0;
        this.prev = null;
        this.next = null;
    }

    public Doubly_ListNode(Integer data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    public Doubly_ListNode(Integer data, Doubly_ListNode next, Doubly_ListNode prev) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public String toString() {
        return "Doubly_ListNode(" + data + ")";
    }

}
public class Doubly_ListNode {

    public Object data;
    public Doubly_ListNode prev;
    public Doubly_ListNode next;

    public Doubly_ListNode() {
        this.data = null;
        this.prev = null;
        this.next = null;
    }

    public Doubly_ListNode(Object data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    public Doubly_ListNode(Object data, Doubly_ListNode next, Doubly_ListNode prev) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public String toString() {
        return "Doubly_ListNode(" + data.toString() + ")";
    }

}
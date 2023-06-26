package DLL;

public class Doubly_ListNode extends LL.ListNode<Integer> {

    public Doubly_ListNode prev, next, tail, head;

    public Doubly_ListNode() {
        super();
    }

    public Doubly_ListNode(Integer data) {
        super(data);
    }

    public Doubly_ListNode(Integer data, Doubly_ListNode next, Doubly_ListNode prev) {
        super(data, next);
        this.prev = prev;
    }

    public String toString() {
        return "Doubly_ListNode(" + data + ")";
    }
}

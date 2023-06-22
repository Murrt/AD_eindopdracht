package LL;

public class ListNode<T> implements Comparable<T> {
    public T data;
    public ListNode<T> next;

    public ListNode() {
        this.data = null;
        this.next = null;
    }

    public ListNode(T data) {
        this.data = data;
        this.next = null;
    }

    public ListNode(T data, ListNode<T> next) {
        this.data = data;
        this.next = next;
    }

    public String toString() {
        return "ListNode(" + data.toString() + ")";
    }

    @Override
    public int compareTo(T otherData) {
        if (data instanceof Comparable) {
            return ((Comparable<T>) data).compareTo(otherData);
        }
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
}

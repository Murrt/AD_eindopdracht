package src.LL;
public class ListNode {

	public Integer data;
	public ListNode next;

	public ListNode() {
		this.data = null;
		this.next = null;
	}
	
	public ListNode(Integer data) {
		this.data = data;
		this.next = null;
	}
	
	public ListNode(Integer data, ListNode next) {
		this.data = data;
		this.next = next;
	}
	
	public String toString() {
		return "ListNode(" + data.toString() + ")";
	}

}
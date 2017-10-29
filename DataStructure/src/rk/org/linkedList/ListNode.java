package rk.org.linkedList;

public class ListNode {
	
	private int data;
	private ListNode next;
	
	public ListNode(){
      super();
	}
	
	public ListNode(int data) {
		super();
		this.data = data;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public ListNode getNext() {
		return next;
	}
	public void setNext(ListNode next) {
		this.next = next;
	}

}

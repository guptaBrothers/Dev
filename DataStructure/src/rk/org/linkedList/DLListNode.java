package rk.org.linkedList;

public class DLListNode {
	private int data;
	private DLListNode next;
	private DLListNode prev;
	
	
	public DLListNode(){	
	}
	
	public DLListNode(int data){
		this.data = data;
		this.next = null;
		this.prev = null;
	}
	

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public DLListNode getNext() {
		return next;
	}

	public void setNext(DLListNode next) {
		this.next = next;
	}

	public DLListNode getPrev() {
		return prev;
	}

	public void setPrev(DLListNode prev) {
		this.prev = prev;
	}
	
	

}

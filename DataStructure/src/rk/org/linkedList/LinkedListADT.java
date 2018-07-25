package rk.org.linkedList;

public class LinkedListADT  {
	
	private ListNode head;
	
	
	/*
	 * Operations on linked list
	 * 1. Reverse a link list
	 * 2. Make linked list circular
	 * 3. Detect loop in a link list
	 * 4. Find Loop Node
	 * 
	 * */
	
	
	
	
	@SuppressWarnings("unused")
	public void addNode(int data){
		
		ListNode newNode = new ListNode();
		if(null == newNode){
			System.out.println("Memory Error");
			return ;
		}
		newNode.setData(data);
		
		if(head == null){
			head = newNode;
		}
		else{
			ListNode current = head;
			while(current.getNext()!= null){
				current = current.getNext();
			}
			current.setNext(newNode);
		}
	}

	public int getLength() {
		ListNode current = head;
		int count=0;
		while(current!= null){
			count++;
			current = current.getNext();
		}
		return count;
	}
	
	public void displayList(ListNode head){
		ListNode current = head;
		System.out.println("\n list is :");
		while(current!= null){
			System.out.print("  " +current.getData());
			current =current.getNext();
		}
	}
	

	/**
	 * @param args
	 */
	public static void main (String[] args){
		
		LinkedListADT linkedList = new LinkedListADT();
		linkedList.addNode(1);
		linkedList.addNode(2);
		linkedList.addNode(3);
		linkedList.addNode(4);
		linkedList.addNode(5);
		System.out.println("length of list is : " +linkedList.getLength());
		ListNode current =linkedList.head;
//		linkedList.displayList(current);
//		linkedList.head = linkedList.reverseLinkedList();
//		linkedList.displayList(linkedList.head);
//		current = linkedList.head;
//		current = linkedList.createLoopInLinkedList(current);
//		if(linkedList.isLoopInLinkledList(current)){
//			System.out.println("\n There is a loop in the list " + " & loopNode data is + " + linkedList.getLoopNode(current).getData());
//		}else{
//			linkedList.displayList(currelinkedList.displayList(current)nt);
//		}
//		current =linkedList.head;
//		linkedList.rotateByKNode(current, 3);
		ListNode newHead =linkedList.reverseLinkedListWithoutTempVariable(current);
		current.setNext(null);
		linkedList.displayList(newHead);
	}
	
	public ListNode getLoopNode(ListNode head){
		ListNode slowPtr =head;
		ListNode fastPtr =head;
		boolean loopExists = false;
		while(fastPtr!=null && fastPtr.getNext()!=null){
			fastPtr = fastPtr.getNext().getNext();
			slowPtr = slowPtr.getNext();
			if(fastPtr == slowPtr){
				fastPtr =head;
				loopExists =true;
				break;
			}
		}
		
		if(loopExists){
			while(fastPtr!=slowPtr){
				fastPtr = fastPtr.getNext();
				slowPtr = slowPtr.getNext();
			}
			return fastPtr;
		}
		else
			return null;
	}
	
	public boolean isLoopInLinkledList(ListNode head){
		ListNode slowPtr =head;
		ListNode fastPtr =head;
		while(fastPtr!=null && fastPtr.getNext()!=null){
			fastPtr = fastPtr.getNext().getNext();
			slowPtr = slowPtr.getNext();
			if(fastPtr == slowPtr)
				return true;			
		}
		
		return false;
		
	}
	
	public void makeCircularLinkedList(){
		ListNode current = head;
		if(head!= null && head.getNext()!= null ){
			while(current.getNext() != null){
				current = current.getNext();
			}
			current.setNext(head);
		}else{
			System.out.println("With one element in the list cannot be circular");
		}
		
	}
	
	public ListNode reverseLinkedList(){
		if(head == null)
			return head;
		ListNode prev = null;
		ListNode current = head;
		ListNode next = null;
		while(current.getNext()!= null){
			next =current.getNext();
			current.setNext(prev);
			prev=current;
			current = next;
		}
		current.setNext(prev);
		return current;
	}
	
	public ListNode reverseLinkedListWithoutTempVariable(ListNode curr){
		ListNode newHead = null;
		if(curr == null || curr.getNext() == null){
			newHead = curr;
			return curr;
		}
		if(curr.getNext().getNext()== null){        // end detection
			newHead = curr.getNext();
			curr.getNext().setNext(curr);           // change pointer ** vip
			curr.setNext(null);
		}else{
			newHead = reverseLinkedListWithoutTempVariable(curr.getNext());
			curr.getNext().setNext(curr);
		}
		return newHead;
	}
	
	public ListNode reverseByKNodes(ListNode head,int k){

		if(head ==null)
			return head;
		ListNode curr = head;
		ListNode prev = null;
		ListNode next = null;
		int count =k;
		while(curr.getNext()!=null && (count--)>0){
			next =curr.getNext();
			curr.setNext(prev);
			prev =curr;
			curr = next;
		}
		if(next != null )
			head.setNext(reverseByKNodes(next,k));

		return prev;
	}

	public ListNode createLoopInLinkedList(ListNode head) {
		// TODO Auto-generated method stub
		
		ListNode temp = null;
		ListNode current = head;
		while(current.getNext()!=null){
			if(current.getData() == 3){
				temp = current;
			}
			current= current.getNext();
		}
		current.setNext(temp);
		return head;
	}
	
	public void rotateByKNode(ListNode head, int k){
		ListNode targetNode =new ListNode();
		ListNode current =head;
		int count =0;
		while(current.getNext()!= null){
			count++;
			if(count==k){
				targetNode = current;
			}
			current= current.getNext();
		}
		if(count<= k){
			System.out.println("List cannot be rotated, since is size is less the the times it can be roatated");
		}
		else{
			current.setNext(head);
			head = targetNode.getNext();
			targetNode.setNext(null);
		}
			
		this.displayList(head);
		
	}
}


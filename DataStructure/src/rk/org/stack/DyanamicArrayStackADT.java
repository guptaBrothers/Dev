package rk.org.stack;

public class DyanamicArrayStackADT {
	int top;
	int CAPACITY ;
	int size;
	int stackArray[];
	
	public DyanamicArrayStackADT(){
		this.top=-1;
		this.CAPACITY=10;
		this.size=0;
		stackArray = new int[CAPACITY];
	}
	
	public boolean isStackEmpty(){
		if(top==-1)
			return true;
		else
		    return false;
	}
	
	public int stackSize(){
		int elementCount=0;
		if(top!=-1){
		return top+1;
		}
		return 0;
	}
	
	public boolean isStackFull(){
		
		if(top==this.stackSize()){
			return true;
		}
		return false;
	}
	
	public int peek(){
		if(top==-1){
			System.out.println("Stack empty");
		}
		return stackArray[top];
	}
	
	public void push(int data){
		if(this.stackSize()==this.CAPACITY){
			stackArray = expand();
			stackArray[++top] =data;
		}
		else{
			stackArray[++top] =data;
		}
	}
	
	public void pop(){
		
		if(top==-1){
			System.out.println("StackArray Empty");
		}
		stackArray[top--]=-1;  // a method to show that the memory is emptied
		stackArray = shrink();
	}

	private int [] shrink() {
		if(this.stackSize() < (CAPACITY>>2)){
			int[] newStackArray = new int[CAPACITY>>1];
			int i=0;
			while(i<this.stackSize()){
				newStackArray[i] = stackArray[i];
			}
		  return newStackArray;	
		}
		
		return stackArray;
	}

	private int[] expand() {
		int[] newStackArray = new int[CAPACITY<<1];
		int stackArrayIterator=0;
		while(stackArrayIterator<=top){
			newStackArray[stackArrayIterator] = stackArray[stackArrayIterator];
		}
		return newStackArray;
	}

}

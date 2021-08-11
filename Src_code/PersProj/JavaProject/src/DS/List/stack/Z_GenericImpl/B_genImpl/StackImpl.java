package DS.List.stack.Z_GenericImpl.B_genImpl;

/**
 * Unlike array, access is restricted.
 * A stack allows access to only one data item: the last item inserted. LIFO
 * 
 * Real time use : 
 * Most microprocessors use a stack-based architecture. When a method is called, 
 * its return address and arguments are pushed onto a stack, and when it returns, they’re popped off. 
 * The stack operations are built into the microprocessor.
 * 	- Reversing a Word
 *  - Delimiter Matching
 *  - Parsing Arithmetic Expressions
 *  
 *  
 * Operations : 
 * 
 * Push(data) : To insert a data item on the stack.
 * 		If the stack is full and you try to push another item, you’ll get the Can’t insert: stack is full message. 
 * 		Need to handle in case of array implementation, not required in case of linked list implementation.
 * 
 * Pop() : To remove a data item (as well as returned by this method) from the top of the stack,
 * 		if the stack is empty and you try to pop an item, you’ll get the Can’t pop: stack is empty message.
 * 		Need to handle in both implementation.
 *  In Actual deleted items remain in the array until written over by new data.
 *  However, they cannot be accessed after the Top marker drops below their position, so conceptually they are gone.
 *  
 * Peek() : The peek operation is used to read the value from the top of the stack without removing it.
 * 
 * 
 *
 */

interface StackIf {
	public String pop();
	public String peek();
	public void push(String str);

}


public class StackImpl implements StackIf {
	
	private String StackContainer[];
	private int size;
	private int top;
	
	StackImpl(int size){		
		StackContainer = new String[size];
		this.size =size;
		top = -1;
	}
	
	public static void main(String args[]){
		StackImpl myStack = new StackImpl(4);
		myStack.push("Manish");
		myStack.push("Samrat");
		myStack.push("Virat");
		myStack.push("Manisha");
		myStack.push("Oracle");
		
		//myStack.clear_stack(myStack);
		
	}
	
	public void clear_stack (StackImpl myStack) {

		while (!myStack.isEmpty()) {
			System.out.println(myStack.pop());
			
		}
	}
	
	
	public String pop(){
		if (!isEmpty()){
			return StackContainer[top--];
		}
		
		return null;
		
	}
	
	public String peek(){
		if (!isEmpty()){
			return StackContainer[top];
		}
		
		return null;		
	}
	
	public void push(String str){
		if (!isFull()){
			top = top+1;
			StackContainer[top] = str;
		}
		
	}
	
	public boolean isEmpty() {
		if (this.top <= -1) {			
			//System.out.println("Errorneous operation : Stack is empty");
			return true;
		}
		
		return false;
	}

	public boolean isFull() {
		if (this.top == size-1) {			
			//System.out.println("Errorneous operation : Stack is Full");
			return true;
		}
		
		return false;
	}	

}

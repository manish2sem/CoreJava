package DS.List.stack.Z_GenericImpl.B_genImpl;


/**
 *	Second solution:
 *		Keep the stack container of type object.
 		Then cast the element wherever retrieved from the array from Object to E:
 * 			E result = (E)elements[--size];
 * 		
 * 		Pushing into stack doesn't required any special attention.
 * 			As any data (or object) can be pushed as stack container is of type Object.
 *
 */

public class GenericStack<T> {
	
	private Object[] StackContainer; 
	private int size;
	private int top;
	
	public GenericStack(int size) {
		this.size = size;
		StackContainer = new Object[size];
		top = -1;
	}
	

	public static void main(String args[]){
		
		stringStack();
	}
	
	static void stringStack(){
		int size =6;
		GenericStack<String> myStack = new GenericStack<String>(size);
		myStack.push("Manish");
		myStack.push("Samrat");
		myStack.push("Virat");
		myStack.push("Manisha");
		myStack.push("Oracle");

		while (!myStack.isEmpty()) {
			System.out.println(myStack.pop());

		}	
	}

	static void longStack(){
		int size =6;
		GenericStack<Long> myStack = new GenericStack<Long>(size);
		myStack.push(1l);
		myStack.push(2l);
		myStack.push(300L);
		myStack.push(40L);
		myStack.push(90l);

		while (!myStack.isEmpty()) {
			System.out.println(myStack.pop());

		}	
	}

	
	public void push(T data){
		if (!isFull()){
			top = top+1;
			StackContainer[top] = data;
//			StackContainer.add(data);
		}
		
	}
	
	public T peek(){
		if (!isEmpty()){
	//		return StackContainer.get(top);
			return (T)StackContainer[top];
		}
		
		return null;		
	}
	
	public T pop(){
		if (!isEmpty()){
			return (T)StackContainer[top--];
		}
		
		return null;
		
	}
	
	private boolean isEmpty() {
		if (this.top <= -1) {			
			System.out.println("Errorneous operation : Stack is empty");
			return true;
		}		
		return false;
	}
	
	private boolean isFull() {
		if (this.top == size-1) {			
			//System.out.println("Errorneous operation : Stack is Full");
			return true;
		}
		return false;
	}

}

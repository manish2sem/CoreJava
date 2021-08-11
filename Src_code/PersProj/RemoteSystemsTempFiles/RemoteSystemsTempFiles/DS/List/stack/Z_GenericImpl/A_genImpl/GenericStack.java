package DS.List.stack.Z_GenericImpl.A_genImpl;

/**
 * How can we declare our own classes as generic types?
 * 
 * 		public interface List<E>
 * The <E> is a placeholder for the type you pass in. 
 * The List interface is behaving as a generic "template" , and when you write your code, 
 * you change it from a generic List to a List<Dog> or List<Integer>, and so on. 
 * 
 * Method declaration :
 * 		boolean add(E o){  }
 * In other words, whatever E is when you declare the List, that's what you can add to it. 
 * So imagine this code:
 * List<Animal> list = new ArrayList<Animal>();
 * 
 * Challenges to make it generic :
 * 		T[] StackContainer = new T[size]; 
 * First Solution: 
 * 	create an array of Object and cast it to the generic array type.
 * 		T[] StackContainer = (T[]) new Object[size]; 
 * 
 * This is not (in general) typesafe, compiler will emit a warning.
 * But this is ok, You can supress the warning as it is not going to harm.
 * 
 *
 */

public class GenericStack<T> {

	private T[] StackContainer; 
	private int size;
	private int top;

	//	public GenericStack(int size, List<T> StackContainer) {
	public GenericStack(int size) {
		this.size = size;
		StackContainer = (T[])new Object[size];
		this.StackContainer = StackContainer;
		top = -1;
	}


	public static void main(String args[]){
		longStack();
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
			return StackContainer[top];
		}

		return null;		
	}

	public T pop(){
		if (!isEmpty()){
			//			return StackContainer.get(top--);
			return StackContainer[top--];
		}

		return null;

	}

	private boolean isEmpty() {
		if (this.top <= -1) {			
			//System.out.println("Errorneous operation : Stack is empty");
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

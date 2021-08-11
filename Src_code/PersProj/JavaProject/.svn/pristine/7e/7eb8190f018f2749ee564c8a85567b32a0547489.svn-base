package DS.List.stack;

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
 * You can use more than one parameterized type in a single class definition:
 * 		public class UseTwo<T, X> { } 
 * 
 * And you can use a form of wildcard notation in a class definition, to specify a 
 * range (called "bounds") for the type that can be used for the type parameter:
 * 		public class AnimalHolder<T extends Animal> {}
 *
 * @param <T>
 */

public class GenericStack<T> {
	
//	public List<T> StackContainer;
	private T[] StackContainer; 
	private int size;
	private int top;
	
//	public GenericStack(int size, List<T> StackContainer) {
	public GenericStack(int size, T[] StackContainer) {
		this.size = size;
	//	StackContainer = new T[size];
		this.StackContainer = StackContainer;
		top = -1;
	}
	
	

	public static void main(String args[]){
	//	List<String> StackContainer = new ArrayList<String>();
		int size =6;
		String[] StackContainer = new String[size];
		GenericStack<String> myStack = new GenericStack<String>(size, StackContainer);
		myStack.push("Manish");
		myStack.push("Samrat");
		myStack.push("Virat");
		myStack.push("Manisha");
		myStack.push("Oracle");
		
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

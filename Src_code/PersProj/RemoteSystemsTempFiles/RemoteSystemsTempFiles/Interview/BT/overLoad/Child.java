package Interview.BT.overLoad; 

public class Child extends Parent {
	public static void main(String[] args) {
		Parent child = new Child();
		child.go(3L);
	}
	
	
	void go(int x) {
		System.out.println("int Child "); 
	}
	
}

class Parent {
	void go(final int x) {
		System.out.println("int Parent"); 
	}
	

	void go(long x) {
		System.out.println("Long Parent "); 
	}
	
}

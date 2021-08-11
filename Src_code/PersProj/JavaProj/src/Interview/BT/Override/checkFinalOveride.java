package Interview.BT.Override;

public class checkFinalOveride {
	
	public static void main(String... args) {
		Parent checkFinal = new Child();
		checkFinal.go(3);
	}
}


class Parent {
	void go(final int x) {
		System.out.println("Parent"); 
	}
}

class Child extends Parent {
	void go( int x) {
		System.out.println("Child "); 
	}
}



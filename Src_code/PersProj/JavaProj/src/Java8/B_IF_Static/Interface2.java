package Java8.B_IF_Static;

public interface Interface2 {
	void method2();
	
	static void staticMethod(String str){
		System.out.println("Interface2 Printing "+str);
	}

	static void staticMethod2(String str){
		System.out.println("Interface2 Printing "+str);
		Interface1.staticMethod("This from Interface2->print2");
	}

}

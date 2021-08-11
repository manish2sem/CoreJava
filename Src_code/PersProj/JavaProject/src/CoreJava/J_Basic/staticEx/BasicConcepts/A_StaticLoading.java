package CoreJava.J_Basic.staticEx.BasicConcepts;

public class A_StaticLoading {
	static int x =10;

	static {
		System.out.println("Static -> "+x);
	}
	public static void main(String[] args) {
		System.out.println("main");
	}

}

package CoreJava.J_Elementry.Operator.incrmnt;

public class C_WithMrthod {

	public static void main(String[] args) {
		int i = 11;		 
        System.out.println(methodTwo(i) + ++i - --i);
	}
	
	static int methodOne(int i) {
		System.out.println("methodOne : " + i);
       i = i++ + --i; 
       System.out.println("methodOne br return: " + i);

        return i;
    }
 
    static int methodTwo(int i) {
		System.out.println("methodTwo : " + i);
       i = i-- - ++i + methodOne(i); 
       System.out.println("methodTwo br return: " + i);
	//	i = i-- - ++i + i++ + methodOne(i) + ++i ; 
        return i;
    }

}

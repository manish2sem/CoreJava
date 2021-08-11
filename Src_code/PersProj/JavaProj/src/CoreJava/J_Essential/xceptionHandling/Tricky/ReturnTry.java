package CoreJava.J_Essential.xceptionHandling.Tricky;

public class ReturnTry {
	
	public static void main(String [] args)	{
		ReturnTry arithmeticExceptionEx = new ReturnTry();
		int i = arithmeticExceptionEx.methodWithException();
		System.out.print(" returned value of i is : " + i);	
	}

	public static int methodWithException() {
		try {
			int n =45/1;
			return 1;
		}catch (ArithmeticException e) {
			System.out.print("1 ");	
			return 2;
		}catch (RuntimeException e) {
			System.out.print("2 ");
			return 3;
		}catch (Exception e) {
			System.out.print("3 ");		
		}finally{
			System.out.println("4 ");	
			return 4;
		}

	}


}

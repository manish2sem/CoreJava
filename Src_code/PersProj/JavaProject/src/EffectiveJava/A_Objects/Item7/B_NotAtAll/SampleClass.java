package EffectiveJava.A_Objects.Item7.B_NotAtAll;
/**
 * An uncaught exception will terminate the thread and 
 * print a stack trace.
 * but not if it occurs in a finalizer—it won’t even print a warning.
 * 
 * Remove try/catch block of throwsRunExcp and execute the main.
 * @author Manish
 *
 */
public class SampleClass {

	boolean flag = false;
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public SampleClass(boolean flag){
		this.flag = flag;
	}

	public void throwsRunExcp(){
		int n=10;
		try{
			System.out.println(n/0);
		}catch (ArithmeticException ae){

		}
	}

	@Override protected void finalize() throws Throwable {
		try {
			this.flag = false;
			System.out.println("Object is garbage colllected.");
		} finally {
			//super.finalize();
		}
	}


}

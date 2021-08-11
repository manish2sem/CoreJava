package EffectiveJava.A_Objects.Item7.A_Uses;
/**
 * Finalizers method is called when object is garbage collected.
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

	@Override protected void finalize() throws Throwable {
		try {
			this.flag = false;
			System.out.println("Object is garbage colllected.");
		} finally {
			//super.finalize();
		}
	}


}

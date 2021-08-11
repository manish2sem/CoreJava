package CoreJava.J_Importent.ClassLoder.ClassloaderLeaks;

public class Leak implements ILeak {
	private ILeak leak;

	public Leak(ILeak leak) {
		this.leak = leak;
	}
}
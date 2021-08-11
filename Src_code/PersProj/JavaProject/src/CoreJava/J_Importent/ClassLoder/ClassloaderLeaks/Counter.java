package CoreJava.J_Importent.ClassLoder.ClassloaderLeaks;

public class Counter implements ICounter {
	private int counter;
	private ILeak leak;

	private static final long[] cache = new long[1000000];

	/* message(), counter(), plusPlus() impls */

	public ILeak leak() {
		return new Leak(leak);
	}

	public ICounter copy(ICounter other) {
		if (other != null) {
			counter = other.counter();
			leak = other.leak();
		}
		return this;
	}
}
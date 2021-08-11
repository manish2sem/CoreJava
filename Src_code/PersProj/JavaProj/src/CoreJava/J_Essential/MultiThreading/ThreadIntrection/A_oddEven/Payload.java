package CoreJava.J_Essential.MultiThreading.ThreadIntrection.A_oddEven;

class Payload {
	String name;
	int length;
	private int index;

	public Payload(String name) {
		this.name = name;
		this.length = name.length();
	}

	public synchronized void printOdd() throws InterruptedException {
		while (index < length) {
			//Thread.sleep(100);
			if (index % 2 == 0) {
				wait();
			}
			if (index < length) {
				System.out.println(index + " " + name.charAt(index));
				notifyAll();
				index++;
			}
		}
	}

	public synchronized void printEven() throws InterruptedException {
		while (index < length) {
			//Thread.sleep(300);
			if (index % 2 != 0) {
				wait();
			}
			if (index < length) {
				System.out.println("\t" + index + " " + name.charAt(index));
				notifyAll();
				index++;
			}
		}
	}
}

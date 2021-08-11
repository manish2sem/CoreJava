package CoreJava.J_Essential.MultiThreading.ThreadIntrection.A_oddEven;

public class Printer extends Thread{
	Payload payload;
	static boolean type = false;
	String flag;

	public Printer(Payload payload) {
		this.payload = payload;

		//Any thread should be able to pick up printing job first.
		if (type == false) {
			flag = "First";
			type = true;
		} else {
			flag = "Second";
		}
	}

	public void run() {
		try {
			// Even Number
			if (flag.equals("First")) {
				System.out.println(this.getName() + " " + flag);
				payload.printEven();
			} else {// Odd Number
				System.out.println(this.getName() + " " + flag);
				payload.printOdd();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}



package CoreJava.J_Essential.MultiThreading.ThreadIntrection.OddEven;

public class PrintEvenOddTester {
	
	public static void main(String ... args){
        Printer print = new Printer();
        Thread t1 = new Thread(new TaskEvenOdd(print, 1000,  false));
        Thread t2 = new Thread(new TaskEvenOdd(print, 1000, true));
       t1.start();
        t2.start();
    }

}

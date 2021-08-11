package CoreJava.J_Essential.MultiThreading.StaticMethods;

public class GuessANumber extends Thread {
	private int number;
	public GuessANumber(int number){
		this.number = number;
	}
	
	public void run(){
		int counter = 0;
		int guess = 0;
		do {
			Thread.yield();   //Since Thread2 is set for highest priority it wont give (actually gives but due to high priority again takes back) the CPU to other threads.
			guess = (int) (Math.random() * 100 + 1);
			System.out.println(this.getName() + " guesses " + guess);
			counter++;
		}while(guess != number); 
		
		System.out.println("** Correct! " + this.getName() + " in " + counter + " guesses.**");
	}
}

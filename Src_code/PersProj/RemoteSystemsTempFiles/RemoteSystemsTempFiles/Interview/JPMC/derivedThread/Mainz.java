package Interview.JPMC.derivedThread;

public class Mainz {
	public static void main(String[] args) {
		/*Thread DrvdThrd = new Thread(new DrvdThrd());
		DrvdThrd.start();*/
		
		Thread DrvdThrd = new Thread(new BaseThread(){			
								public void run(){
									System.out.println("DrvdThrd");
								}
							});
		DrvdThrd.start();		
	}
}

package EffectiveJava.A_Objects.Item7.A_Uses;

/**
 * 		sampleClass = null;
 * Doesn't make always object to be garbage collected.
 * So, Finalizers are unpredictable.
 * @author Manish
 *
 */
public class FinalizeUse {

	public static void main(String[] args) throws InterruptedException {
		SampleClass sampleClass = new SampleClass(true);
		boolean flag = sampleClass.isFlag();
		sampleClass = null;
		for(int i =0; i<10; i++){
			Thread.sleep(1000);
			 if(i==5){
					System.gc(); 
			 }
			System.out.println("Thread running" + i);
		}
		
	}
	
	
}

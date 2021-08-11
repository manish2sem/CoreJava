package EffectiveJava.A_Objects.Item7.B_NotAtAll;

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
		sampleClass.throwsRunExcp();
		for(int i =0; i<10; i++){
			Thread.sleep(1000);
			sampleClass = null;
			 if(i==5){
					System.gc(); 
			 }
			System.out.println("Thread running" + i);
		}
		
	}
	
	
}

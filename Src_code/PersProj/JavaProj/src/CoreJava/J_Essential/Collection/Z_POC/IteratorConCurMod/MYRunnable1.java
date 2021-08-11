package CoreJava.J_Essential.Collection.Z_POC.IteratorConCurMod;

import java.util.List;

public class MYRunnable1 implements Runnable{
	List strList;

	MYRunnable1 (List strList){
		this.strList = strList;
	}

	@Override
	public void run() {
		while (true){
			System.out.println("Added by "+Thread.currentThread().getName()+" : " +strList.size());
			strList.add("Manish");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

package CoreJava.J_Essential.Collection.Z_POC.IteratorConCurMod;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

public class MYRunnable2 implements Runnable{
	List strList;

	MYRunnable2 (List strList){
		this.strList = strList;
	}

	@Override
	public void run() {
		Iterator itr = strList.iterator();

		while (true){
			//System.out.println("Removed by "+Thread.currentThread().getName()+ " : " +strList.size());
			if(itr.hasNext()){
				//String str itr.remove();
				System.out.println("Removed by "+Thread.currentThread().getName()+ " : " +strList.size());
				try{
				System.out.println(itr.next());
				}catch (ConcurrentModificationException e) {
					e.printStackTrace();
					run();
				}

			}
		//	strList.remove("Manish");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}

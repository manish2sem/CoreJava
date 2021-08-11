package Interview.Medlife;

import java.util.ArrayList;
import java.util.List;

public class MyArrListQ<E> {
	
	List<E> MyQ = new ArrayList<E>(); 
	public void enqueue(E item){
		MyQ.add(item);
	}
	
	public E dequeue(){
		return MyQ.remove(0);
	}
	
	public boolean hasItems() {
		return !MyQ.isEmpty();
	}

}

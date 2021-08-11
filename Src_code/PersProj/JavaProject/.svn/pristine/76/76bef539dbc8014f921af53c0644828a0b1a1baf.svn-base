package CoreJava.J_Essential.Collection.general.collectionsConcept;

import java.util.HashMap;
import java.util.Map;

public class Bx_BucketConcepts {
	public static void main(String[] args) {
		Map<KeyClsA, String> myMap = new HashMap<KeyClsA, String>();
		myMap.put(new KeyClsA("Manish") , "Samrat");
		myMap.put(new KeyClsA("Manish") , "Samrat");
		System.out.println("contains ----> " + myMap.containsKey(new KeyClsA("Manish")));
		System.out.println("Size ---- " + myMap.size());
		System.out.println("Display ---- ");
		for(KeyClsA key : myMap.keySet()){
			System.out.println(myMap.get(key));
		}
	}	

}


class KeyClsA{
	String keyName;
	public KeyClsA(String name){
		keyName = name;
	}

	@Override
	public int hashCode(){
		return 10;
	}

	public boolean equals(Object key){
		return false;
	}

}
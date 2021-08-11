package DS.Other.Duplicates;

import java.util.HashMap;
import java.util.Map;

public class DuplicateCount {
	
	public static void main(String[] args) {
		String statement ="My name is manish kumar";
		findDuplicate(statement);
	}
	
	private static void findDuplicate(String str){
		
		char[] charArray = str.toCharArray();
		Map<Character, Integer> charMap = new HashMap<Character, Integer>();
		
		for(char c : charArray){
			
			if(charMap.containsKey(c)){
				charMap.put(c, charMap.get(c)+1 );
			}else{
				charMap.put(c, 1);
			}
			
		}
		
		for(char c : charMap.keySet()){
			System.out.println(c +" ---> " +charMap.get(c));
		}
	}
}



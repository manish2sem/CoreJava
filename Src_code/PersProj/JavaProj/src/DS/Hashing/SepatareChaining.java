package DS.Hashing;

/**
 * Load Factors : the ratio of the number of items in a hash table to its size 
 *  	In separate chaining it’s normal to put N or more items into an N cell array; 
 *  	thus, the load factor can be 1 or greater. There’s no problem with this; 
 *  Of course, we don’t want the lists to become too full.
 *  Finding the initial cell takes fast O(1) time, but searching through a list
 *  takes time proportional to M, the average number of items on the list. This is O(M) time.
 *  
 * Duplicates : Duplicates are allowed and may be generated in the Fill process. 
 *  All items with the same key will be inserted in the same list, 
 *  so if you need to discover all of them, you must search the entire list.
 *  
 * Deletion In separate chaining, deletion poses no special problems as it does in open addressing.
 *  
 * Table Size 
 *   With separate chaining, making the table size a prime number is not as important
 *   as it is with quadratic probes and double hashing.
 *   
 * Buckets 
 *   Another approach similar to separate chaining is to use an array at each location in the hash table, 
 *   instead of a linked list. Such arrays are sometimes called buckets. 
 *   This approach is not efficient because of the problem of choosing the size of the buckets.
 *   Linked lists, which allocate memory dynamically, don’t have this problem.
 */

import java.util.ArrayList;
import java.util.List;

public class SepatareChaining {
	final int HASH_SIZE = 20;
	List<String>[] HashTableArr = new List[HASH_SIZE];
	public static void main (String[] args) {
		SepatareChaining hashTbl = new SepatareChaining();
		hashTbl.insert("Manish");
		hashTbl.insert("Samrat");
		hashTbl.insert("Oracle1");
		hashTbl.insert("Virat");
		hashTbl.insert("Manisha");
		hashTbl.insert("Oracle1");
		hashTbl.insert("Manish");
		hashTbl.insert("Samrat");
		hashTbl.insert("Virat");
		hashTbl.insert("Manisha");
		hashTbl.insert("Oracle1");
		hashTbl.insert("Manish");
		hashTbl.insert("Samrat");
		hashTbl.insert("Virat");
		hashTbl.insert("Manisha");		
		hashTbl.insert("Manish");
		hashTbl.insert("Samrat");
		hashTbl.insert("Virat");
		hashTbl.insert("Manisha");
		hashTbl.insert("Oracle1");
		
		hashTbl.display();
		
		System.out.println("Find for Samrat " + hashTbl.find("Samrat"));
		System.out.println("Find for Vishal " + hashTbl.find("Vishal"));
		System.out.println("Delete Oracle1 : " + hashTbl.delete("Oracle1"));
		System.out.println("Delete Keane " + hashTbl.delete("Keane"));
		
		hashTbl.display();	
		

    }
	/*
	private	void initialize(){
		
	}*/
	
	private	void display(){
		
		for (List myList : HashTableArr) {
			System.out.println("Contents of al after removal: " + myList); 
		}
		
	}
	
	private	boolean find(String str){
		int index = hashFunct(str);
		if (HashTableArr[index]!=null) {
			return HashTableArr[index].contains(str);
		}
		return false;
		
	}
	
	
	private	boolean delete(String str){
		int index = hashFunct(str);
		if (HashTableArr[index].contains(str)) {
			
			return HashTableArr[index].remove(str);
		}
		
		return false;
		
	}
	
	private	void insert(String str){
		int index = hashFunct(str);
		if(HashTableArr[index]!=null){
			HashTableArr[index].add(str);			
			
		}else {
			List<String> myList = new ArrayList<String>();
			myList.add(str);
			HashTableArr[index]=myList;
			
		}
		
	}
	
	private	int hashFunct(String str){
		System.out.println("Hash Code : " + str.hashCode());
		int hashCd = 0;
		if (str.hashCode()<0) {
			hashCd = str.hashCode() * -1;
			
		}
		int hashFun = hashCd % LinearProbing.HASH_SIZE;
		System.out.println("Hash Function for : "+str + " is " + hashFun);
		return hashFun;		
	}

}

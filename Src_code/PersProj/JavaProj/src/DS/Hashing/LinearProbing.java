package DS.Hashing;

/**
 * In case of collision  we search sequentially for vacant cells, on, incrementing the index until we find an empty cell.
 * 
 * Issue :
 * Here, we search sequentially for vacant cells, on, incrementing the index until we find an empty cell.
 * say we inserted 5 element with similar hashFunction at position 1 to 5 and delete 3rd one then we loose the track of 4th and 5th.
 * because 3rd cell will return null and we stop our searching.
 * 
 * Methods : search, insertion, and deletion
 * @author Manish
 *
 * Virat and Oracle1 has same hashFunction for following program.
 * Oracle1 is inserted before Virat.
 * if Oracle1 is deleted Virat is not found.
 * Reason : this is the issue with delete in Linear probing 
 * 
 * Duplicates Allowed?
 * 		you can insert them with the Insert button if you like.
 * 		Then you’ll see that only the first one can be accessed. 
 * 		The only way to access a second item with the same key is to delete the first one. This isn’t too convenient.
 * 		You could rewrite the Find algorithm to look for all items with the same key instead of just the first one.
 * 		However, it would then need to search through all the cells of every linear sequence it encountered. 
 * 		This wastes time for all table accesses, even when no duplicates are involved. 
 * In the majority of cases you probably want to forbid duplicates.
 * 
 * ReHash :
 * When array is full its size is doubled.
 * 		- Preserved old array value
 * 		- Create a new array with doubled size. and refer it by old array reference variable.
 * 		- insert old array's element into new Array using insert method.
 */
public class LinearProbing {
	static  int HASH_SIZE = 20;
	static String HashTableArr[] = new String[HASH_SIZE];
	public static void main (String[] args) {
		HashTableEx hashTbl = new HashTableEx();	


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
		hashTbl.insert("Oracle1");
		hashTbl.insert("Manish");
		hashTbl.insert("Samrat");
		hashTbl.insert("Virat");
		hashTbl.insert("Manisha");
		hashTbl.insert("Oracle1");


		for (String str : HashTableArr) {

			System.out.println(str);
		}

		System.out.println("***********Find***********");

		System.out.println(hashTbl.find("Samrat"));
		System.out.println(hashTbl.find("Manish"));
		System.out.println(hashTbl.find("Oracle1"));
		System.out.println(hashTbl.find("Virat"));


		System.out.println("***********Find***********");

		System.out.println(hashTbl.delete("Oracle1"));		
		System.out.println("Finding Virat : " + hashTbl.find("Virat"));

		System.out.println("***********Print***********");

		for (String str : HashTableArr) {

			System.out.println(str);
		}

	}

	public int forTest(int x, int y){
		return x+y;
	}
	public int multiply(int x, int y){
		return x*y;
	}
	public int substract(int x, int y){
		return x-y;
	}
}

class HashTableEx {

	boolean find(String str) {

		int indx = hashFunct(str);
		int cnt=0;
		while((LinearProbing.HashTableArr[indx]!=null) ){
			if (LinearProbing.HashTableArr[indx].equals(str)) {
				return true;
			}else {
				indx = indx+1;
				if (indx > LinearProbing.HASH_SIZE-1) {
					indx = indx%LinearProbing.HASH_SIZE;
				}
				cnt++;
				if (cnt > LinearProbing.HASH_SIZE ){
					System.out.println("No Space left");
					break;
				}
			}
		}
		return false;
	}

	void insert (String str) {
		System.out.println("Inside inser SIZE = "+LinearProbing.HashTableArr.length);
		int indx = hashFunct(str);
		int cnt=0;
		while (true) {
			if (LinearProbing.HashTableArr[indx]== null) {
				LinearProbing.HashTableArr[indx] = str;
				break;
			}else {
				indx = indx+1;
				if (indx > LinearProbing.HASH_SIZE-1) {
					indx = indx%LinearProbing.HASH_SIZE;
				}
				cnt++;
				if (cnt > LinearProbing.HASH_SIZE ){
					System.out.println("No Space left so rehash");
					reHash(str);
					break;
				}
			}
		}

	}

	String delete (String str) {
		int indx = hashFunct(str);
		int cnt=0;
		while(LinearProbing.HashTableArr[indx]!=null){
			if (LinearProbing.HashTableArr[indx].equals(str)) {

				String deleted = LinearProbing.HashTableArr[indx];
				LinearProbing.HashTableArr[indx]=null;

				return deleted;
			}else {
				indx = indx+1;
				if (indx > LinearProbing.HASH_SIZE - 1) {
					indx = indx % LinearProbing.HASH_SIZE;
				}
				cnt++;
				if (cnt > LinearProbing.HASH_SIZE ){
					break;
				}
			}
		}
		System.out.println("String not found in HashTable");
		return null;		

	}

	private	int hashFunct(String str){
		//System.out.println("Hash Code : " + str.hashCode());
		int hashCd = 0;
		if (str.hashCode()<0) {
			hashCd = str.hashCode() * -1;

		}
		int hashFun = hashCd % LinearProbing.HASH_SIZE;
		System.out.println("Hash Function for : "+str + " is " + hashFun);
		return hashFun;		
	}

	private void reHash(String str){
		String oldHashTable[] = new String[LinearProbing.HASH_SIZE];
		for (int i=0; i<LinearProbing.HASH_SIZE; i++){
			oldHashTable[i]=LinearProbing.HashTableArr[i];
		}
		LinearProbing.HASH_SIZE *=2;
		LinearProbing.HashTableArr = new String[LinearProbing.HASH_SIZE];
		for (int i=0; i<oldHashTable.length; i++){
			insert(oldHashTable[i]);
		}
		insert(str);
		//	String oldHashTable[] = new String[LinearProbing.HASH_SIZE];



	}
}
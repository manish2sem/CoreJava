package DS.Hashing;

/**
 * A hash table is a data structure that offers very fast insertion and searching.
 * insertion and searching (and sometimes deletion) can take close to constant time: O(1) in big O notation.
 * 
 * hash function converts a number in a large range into a number in a smaller range. 
 * This smaller range corresponds to the index numbers in an array. 
 * 		E.G. : arrayIndex = hugeNumber % arraySize;
 * 
 * An array into which data is inserted using a hash function is called a hash table.
 * 
 * Collisions:
 * We pay a price for squeezing a large range into a small one. 
 * There’s good chance that two words could hash to the same array index.
 * This situation is called collision.
 * It may appear that the possibility of collisions renders the hashing scheme impractical, 
 * but in fact we can work around the problem in a variety of ways
 *	open addressing : when a collision occurs, is to search the array in some systematic way for 
 *					an empty cell and insert the new item there. 
 *	  Following three are popular open addressing schemes :
 *		linear probing :  we search sequentially for vacant cells, on, incrementing the index until we find an empty cell.
 *		quadratic probing :  Quadratic probing is an attempt to keep clusters from forming.
 *			In Linear probing, probes go to x+1, x+2, x+3, x+4, x+5 and so on.
 *			In quadratic probing, probes go to x+1, x+4, x+9, x+16, x+25, and so
 *		But it leads to the secondary clustering.

 *		double hashing : To eliminate secondary clustering as well as primary clustering. 
 * 				hash the key a second time, using a different hash function, and use the result as the step size. 
 * 				For a given key the step size remains constant throughout a probe, but it’s different for different keys.
 *
 *		separate chaining : to create an array that consists of linked lists of words instead of the words themselves.
 *		 Then, when a collision occurs, the new item is simply inserted in the list at that index.
 *
 *Probing :
 *Finding the next cell array for the data in case of collision.
 *
 *clustering :
 *As you add more and more items in hash table, the filled sequences(filled cells in sequence) become longer. This is called clustering.
 *As Hash-Table gets more full, the clusters grow larger. Clustering can result in very long probe lengths.
 *This means that accessing cells at the end of the sequence is very slow.
 *It’s not usually a problem when the array is two-thirds full. Beyond this, however, 
 *performance degrades seriously as the clusters grow larger and larger. 
 *For this reason it’s critical when designing a hash table to ensure that
 *it never becomes more than two-thirds, full.
 *
 *Expanding the Array :(Rehashing)
 *when a hash table becomes too full is to expand its array. So, must create a new, larger array,
 * and then insert the contents of the old small array into the new large one.
 * Since hash function calculates the location of a given data item based on the array size,
 * so items won’t be located in the same place in the large array as they were in the small array.
 * You’ll need to go through the old array in sequence, cell by cell, inserting each item you find 
 * into the new array with the insert() method. This is called rehashing.
 * It’s a time-consuming process, but necessary if the array is to be expanded.
 * 
 * The expanded array is usually made twice the size of the original array. 
 * Because the array size should be a prime number, the new array will need to be a bit more than twice as big. 
 * Calculating the new array size is part of the rehashing process.
 * 
 * loadFactor = nItems / arraySize;
 */
public class BasicHashing {

}

package DS.Tree.Concept.BinaryTree;

import DS.SampleObj.personData;

/**
 * you want to use a tree Because 
 *  - it combines the advantages of an ordered array and a linked list. 
 *  - You can search a tree quickly, as you can an ordered array, and 
 *  - You can also insert and delete items quickly, as you can with a linked list.
 * 
 * An Ordered Array : you can quickly search such an array for a particular value, using a binary search. 
 * 		You check in the center of the array; if the object you’re looking for is greater than what you find there, 
 * 		you narrow your search to the top half of the array; if it’s less, you narrow your search to the bottom half. 
 * 	Applying this process repeatedly finds the object in O(logN) time.
 * 	You can also quickly iterate through an ordered array, visiting each object in sorted order.
 * 
 * On the other hand, 
 *  - Inserting a new object into an ordered array, is a time consuming. 
 *  	you first need to find where the object will go, and then move all the objects 
 *  	with greater keys up one space in the array to make room for it. 
 * 		These multiple moves requires, on the average, moving half the items (N/2 moves). 
 * - Deletion involves the same multimove operation and is thus equally slow. 
 * If you’re going to be doing a lot of insertions and deletions, an ordered array is a bad choice.
 * 
 * Linked List 
 *  - insertions and deletions are quick to perform on a linked list. They are accomplished simply by 
 * 		changing a few references. These operations require O(1) time (the fastest Big O time).
 * However, finding a specified element in a linked list is not so easy. 
 * You must start at the beginning of the list and visit each element until you find the one you’re looking for. 
 * Thus, you will need to visit an average of N/2 objects, comparing each one’s key with the desired value. 
 * This process is slow, requiring O(N) time.
 * 
 * Tree
 * 	- a data structure with the quick insertion and deletion of a linked list, 
 * 	- and also the quick searching of an ordered array.
 * 
 * An Analogy : 
 * One commonly encountered tree is the hierarchical file structure in a computer system. 
 * The root directory of a given device (as in C:\, on many systems) is the tree’s root. 
 * The directories one level below the root directory are its children. 
 * There may be many levels of subdirectories. 
 * Files represent leaves; they have no children of their own.
 * 
 * Terminology :
 * Root Parent Child Leaf SubTree
 * Path
 * Traversing
 * Levels
 * Binary Trees
 * 
 * 
 * Operations :
 * Traversals - PreOrder, PostOrder, InnOrder
 * Insertion, Deletion, Finding a node, Max, Min
 * 
 * Uses :
 * 	- As a search tool
 * 	- The Huffman Code

 *
 */
/*
Duplicate Keys
As in other data structures, the problem of duplicate keys must be addressed. In the
code shown for insert(), and in the Workshop applet, a node with a duplicate key
will be inserted as the right child of its twin.
The problem is that the find() routine will find only the first of two (or more) duplicate
nodes. The find() routine could be modified to check an additional data item,
to distinguish data items even when the keys were the same, but this would be (at
least somewhat) time-consuming.
 */

public class BinarySearchTree {

	public static void main(String[] args) {
		personData person1 = new personData("Manish1", 23);
		Tree bst = new Tree();
		bst.insert(person1);
		bst.insert(new personData("Manish1", 17));
		bst.insert(new personData("Manish2", 43));
		bst.insert(new personData("Manish3", 5));
		bst.insert(new personData("Manish4", 24));

		System.out.println("inOrder Traversing ->");
		bst.inOrder(bst.root);	
		System.out.println();
		System.out.println("preOrder Traversing ->");
		bst.preOrder(bst.root);
		System.out.println();
		System.out.println("postOrder Traversing ->");
		bst.postOrder(bst.root);

		bst.find(4);
		System.out.println("Searching 4 : " +bst.find(4));
		System.out.println("Searching 14 : " +bst.find(14));
		System.out.println("Searching 23 : " +bst.find(23));
		System.out.println("Searching 5 : " +bst.find(5));

	}
}

class Tree {
	Node root;

	public boolean find(int key){
		if (root.data.age == key ){
			return true;
		}
		Node current = root; // start at root
		while(current!=null){
			if (key>current.data.age ){
				current = current.rightChild;
			}else if (key<current.data.age){
				current = current.leftChild;
			}else {
				return true;
			}
		}

		return false;
	}

	public void insert(personData person){
		Node newNode = new Node(person); // mnake new node
		int age = person.getAge(); // insert data  
		//	newNode.data.Name = name;

		if(root == null) {// no node in root
			root = newNode;
		}else{ // root occupied

			Node current = root; // start at root
			Node parent;

			while(true) {
				parent = current;
				if(age < current.data.age){ // go left?
					current = current.leftChild;
					if(current == null){ // if end of the line,
						// insert on left
						parent.leftChild = newNode;
						return;
					}
				} else{ // or go right?
					current = current.rightChild;
					if(current == null){ // if end of the line
						// insert on right
						parent.rightChild = newNode;
						return;
					}
				} // end else go right
			} // end while
		} // end else not root	

	}
	public void delete(int id){

	}

	public void inOrder (Node localRoot) {		
		if(localRoot != null){
			inOrder(localRoot.leftChild);
			System.out.print(localRoot.data.age + " ");
			inOrder(localRoot.rightChild);
		}
	}

	public void preOrder (Node localRoot) {		
		if(localRoot != null){
			System.out.print(localRoot.data.age + " ");
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}

	public void postOrder (Node localRoot) {		
		if(localRoot != null){
			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			System.out.print(localRoot.data.age + " ");

		}
	}
}

class Node {
	personData data;
	Node leftChild; // this node’s left child
	Node rightChild; // this node’s right child

	public Node (personData person) {
		data = person;
		leftChild=null;
		rightChild=null;
	}

	public void displayNode()
	{
		// (see Listing 8.1 for method body)
	}
}


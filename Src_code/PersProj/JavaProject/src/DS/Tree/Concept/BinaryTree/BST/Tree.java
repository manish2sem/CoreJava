package DS.Tree.Concept.BinaryTree.BST;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import DS.SampleObj.personData;


/**
 * The first node[i.e. first insertion] is a root node. - See the insert code.
 * 
 * BST have mostly four type of operations : 
 * 1. Insert -> input is "DATA TO BE INSERTED". 
 * 2. find -> input is "DATA/part_of_data TO BE FOUND".
 * 3. Traversal -> Inorder, Preorder, Postorder. Input is root node. or 
 * 		it can be any node, but then traversal will happen to that sub-tree assuming input node as root.
 *
 */
public class Tree {
	public Node root;

	public boolean find(int key){
		if (root.data.age == key ){
			return true;
		}
		Node current = root; // start at root
		while(current!=null){
			if (key > current.data.age ){
				current = current.rightChild;
			}else if (key < current.data.age){
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
	
	public void insertAll(personData persons[]){
		
		for(personData person : persons){
			insert(person);
		}
		
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
	
	public void inOrderLoop (Node localRoot) {		
		while(localRoot.leftChild  != null){
			localRoot = localRoot.leftChild;
		}
		System.out.print(localRoot.data.age + " ");

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
	
	/**
	 * Post order Traversal:
	 * 	Node(Not processed) is pushed into stack for revisit.
	 * 		- first right and then left (this order is must why?)
	 * 		- In this way when we pop we get left node first.
	 *  post-ordered Nodes are inserted into the List.
	 *  Point is when to insert into the list:
	 *  	- when both the children are null.
	 *  	 	This make sense.
	 *  	- it's children are already visited.
	 *  		How to get this point?
	 *  		 - we keep the track of previously(just last) visited node.
	 *  		 - and pop the node from stack and compare it's child is  
	 *    
	 * @param localRoot
	 */
	
	public void postOrderLoop (Node localRoot) {	
		if(localRoot==null)
			return;
		
		Stack<Node> postStk = new Stack<Node>();
		List<Node> arrList = new ArrayList<Node>();
		postStk.push(localRoot);
		
		Node prev = null;
		Node current = localRoot;
		while(!postStk.isEmpty()){
			 prev = current;
			 current = postStk.pop();
			if(current.rightChild == null && current.leftChild == null){
				arrList.add(current);
			} else if(current.leftChild == prev || current.rightChild == prev ){
				arrList.add(current);
			}else{
				postStk.push(current);
				if(current.rightChild!=null){
					postStk.push(current.rightChild);

				}
				if(current.leftChild!=null){
					postStk.push(current.leftChild);

				}
			}
		}
		
		for(Node node : arrList){			
			System.out.print(node.data.age + " ");
			
		}
	}
}
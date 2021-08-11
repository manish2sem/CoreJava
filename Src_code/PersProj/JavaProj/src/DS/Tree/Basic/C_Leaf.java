package DS.Tree.Basic;

import DS.SampleObj.personData;
import DS.Tree.Concept.BinaryTree.BST.Node;
import DS.Tree.Concept.BinaryTree.BST.Tree;

/**
 * A node is a leaf node if both left and right child nodes of it are NULL.
 * 
 * Leaf count of a tree = Leaf count of left subtree + Leaf count of right subtree.
 * Stoping cond -> If left and right child nodes are NULL return 1.
 * @author Samrat
 *
 */
public class C_Leaf {
	
	public static void main(String[] args) {

		Tree bst = new Tree();

		bst.insertAll(new personData[] {new personData("Manish1", 15), 
				new personData("Manish2", 23), 
				new personData("Manish3", 8),
				new personData("Manish4", 5), 
				new personData("Manish5", 20), 
				new personData("Manish6", 26)});

		System.out.println("Leaf of the tree " +getLeafReucursive(bst.root)) ;
	}

	
	private static int getLeafReucursive(Node root){
		if(root == null){
			return 0;
		}
		if(root.leftChild == null && root.rightChild ==null){
			return 1;
		}
		return getLeafReucursive(root.leftChild) + getLeafReucursive(root.rightChild) ;
	}

}

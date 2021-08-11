package DS.Tree.Basic;

import DS.SampleObj.personData;
import DS.Tree.Concept.BinaryTree.BST.Node;
import DS.Tree.Concept.BinaryTree.BST.Tree;

/**
 * Height of a Tree is it's Maximum Depth.
 * 	Height of tree - MAx(MaxHeight(left subtree),   MaxHeight(right subtree)) + 1
 * 
 * Recursively calculate height of left and right subtrees of a node and assign height to the node as max of the heights of two children plus 1.

 * @author Samrat
 *
 */
public class B_Height {

	public static void main(String[] args) {

		Tree bst = new Tree();

		bst.insertAll(new personData[] {new personData("Manish1", 15), 
				new personData("Manish2", 23), 
				new personData("Manish3", 8),
				new personData("Manish4", 5), 
				new personData("Manish5", 20), 
				new personData("Manish6", 26), new personData("Manish6", 3)});

		System.out.println("Size of the tree " +getHeighReucursive(bst.root));
	}

	private static int getHeighReucursive(Node root){
		if(root == null){
			return 0;
		}
		int leftHt =  getHeighReucursive(root.leftChild);
		int rightHt =  getHeighReucursive(root.rightChild);
		if(leftHt > rightHt){
			return leftHt+1;
		}else {
			return rightHt+1;
		}
		
	}
}

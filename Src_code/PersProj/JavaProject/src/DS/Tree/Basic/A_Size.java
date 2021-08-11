package DS.Tree.Basic;

/**
 * Size of a tree is the number of elements(Node) present in the tree.
 * 	Size of a tree = Size of left subtree + 1 + Size of right subtree. 
 * Size() function recursively calculates the size of a tree. 
 * @author Samrat
 *
 */
import DS.SampleObj.personData;
import DS.Tree.Concept.BinaryTree.BST.Node;
import DS.Tree.Concept.BinaryTree.BST.Tree;

public class A_Size {
	
	public static void main(String[] args) {
		
		Tree bst = new Tree();
		
		bst.insertAll(new personData[] {new personData("Manish1", 15), 
				new personData("Manish2", 23), 
				new personData("Manish3", 8),
				new personData("Manish4", 5), 
				new personData("Manish5", 20), 
				new personData("Manish6", 26)});
		
		System.out.println("Size of the tree " +getSizeReucursive(bst.root));
		
		
	}
	
	private static int getSizeReucursive(Node root){
		if(root == null){
			return 0;
		}
		return getSizeReucursive(root.leftChild) + getSizeReucursive(root.rightChild) + 1;
	}
	
	//Using loop
	private static int getSize(Node root){
		if(root == null){
			return 0;
		}
		return getSize(root.leftChild) + getSize(root.rightChild) + 1;
	}

}

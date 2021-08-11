package DS.Tree.Basic;

import DS.SampleObj.personData;
import DS.Tree.Concept.BinaryTree.BST.Tree;



public class D_Path {
	public static void main(String[] args) {

		Tree bst = new Tree();

		bst.insertAll(new personData[] {new personData("Manish1", 15), 
				new personData("Manish2", 23), 
				new personData("Manish3", 8),
				new personData("Manish4", 5), 
				new personData("Manish5", 20), 
				new personData("Manish6", 26)});

		System.out.println("Leaf of the tree " +printPath(bst.root)) ;
	}
}

package DS.Tree.Concept.BinaryTree.BST;

import DS.SampleObj.personData;


public class BSTmain {
	public static void main(String[] args) {
		personData person1 = new personData("Manish1", 23);
		Tree bst = new Tree();
		
		bst.insertAll(new personData[] {new personData("Manish1", 15), 
				new personData("Manish2", 23), 
				new personData("Manish3", 8),
				new personData("Manish4", 5), 
				new personData("Manish5", 20), 
				new personData("Manish6", 26)});
		/*bst.insert(person1);
		bst.insert(new personData("Manish1", 17));
		bst.insert(new personData("Manish2", 43));
		bst.insert(new personData("Manish3", 5));
		bst.insert(new personData("Manish4", 24));
		*/

		System.out.println("inOrder Traversing ->");
		bst.inOrder(bst.root);	
		System.out.println();
		System.out.println("preOrder Traversing ->");
		bst.preOrder(bst.root);
		System.out.println();
		System.out.println("postOrder Traversing ->");
		bst.postOrder(bst.root);
		System.out.println();
		System.out.println("postOrder loop Traversing ->");
		bst.postOrderLoop(bst.root);
		

		bst.find(4);
		System.out.println("Searching 4 : " +bst.find(4));
		System.out.println("Searching 14 : " +bst.find(14));
		System.out.println("Searching 23 : " +bst.find(23));
		System.out.println("Searching 5 : " +bst.find(5));

	}

}

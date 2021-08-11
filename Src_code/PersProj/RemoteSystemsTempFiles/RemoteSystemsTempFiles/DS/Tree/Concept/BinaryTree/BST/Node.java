package DS.Tree.Concept.BinaryTree.BST;

import DS.SampleObj.personData;
/**
 * This node is used by Tree class.
 * Node will be created each time when new data is inserted through insert method of tree.
 *
 */
public class Node {
	public personData data;
	public Node leftChild; // this node’s left child
	public Node rightChild; // this node’s right child

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


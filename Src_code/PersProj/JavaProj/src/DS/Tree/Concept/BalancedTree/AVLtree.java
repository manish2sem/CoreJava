package DS.Tree.Concept.BalancedTree;

/**
 * 
 * The AVL tree is the earliest kind of balanced tree. 
 * It’s named after its inventors: Adelson-Velskii and Landis. 
 * In AVL trees each node stores the difference between the heights of its left and right subtrees. 
 * This difference may not be larger than 1.
 * That is, the height of a node’s left subtree may be no more than one level different from the height of its right subtree. 
 * Following insertion, the root of the lowest subtree into which the new node was inserted is checked. 
 * If the height of its children differs by more than 1, a single or double rotation is performed to equalize their heights. 
 * The algorithm then moves up and checks the node above, equalizing heights if necessary. 
 * This check continues all the way back up to the root.
 * 
 * AVL trees are not as efficient as red-black trees and are not used as often.
 * @author Manish
 *
 */

public class AVLtree {

}

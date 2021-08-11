package DS.Tree.Concept.BalancedTree;

/**
 * Binary search trees appear to be the ideal data storage structure.
 * 	- You can quickly search for an item with a given key, and 
 * 	- you can also quickly insert or delete an item.
 * 
 * Binary search trees work well if the data is inserted into the tree in random order. 
 * However, they become much slower if  data is inserted in already-sorted order or inversely sorted order.
 * When the values to be inserted are already ordered, a binary tree becomes (practically linked list) unbalanced. 
 * With an unbalanced tree, the ability to quickly find (or insert or delete) a given element is lost.
 * the speed of searching is reduced toO(N), instead of O(logN) as it is for a balanced tree. 
 * 1) Searching through 10,000 items n such an unbalanced tree would require an average of 5,000 comparisons,
 * whereas for a balanced tree with random insertions it requires only 14.
 * 2) a very small or very large key value can cause an unbalanced tree by not allowing the insertion of many nodes 
 * on one side or the other of its node. 
 * A root of 3, for example, allows only two more nodes to be inserted to its left.
 * 
 * To guarantee the quick O(log N) search times a tree is capable of, we need to ensure 
 * that our tree is always balanced (or at least almost balanced).
 * In a red-black tree, balance is achieved during insertion (and also deletion). 
 * As an item is being inserted, the insertion routine checks that certain characteristics of the tree are not violated. 
 * If they are, it takes corrective action, restructuring the tree as necessary.
 * 
 * 
 * the red-black tree (a binary search tree with some added features) is used to solve the problem of unbalanced trees.
 *  	- Searching works the same way in a red-black tree as it does in an ordinary binary tree. 
 * 		- insertion and deletion, while based on the algorithms in an ordinary tree, are extensively modified. 
 * @author Manish
 *
 */

public class RedBlackTree {

}

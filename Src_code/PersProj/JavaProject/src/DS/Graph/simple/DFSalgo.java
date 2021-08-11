package DS.Graph.simple;

/**
 * Searching in graph. you need an algorithm that provides 
 * a systematic way to start at a specified vertex and then move along edges to other 
 * vertices in such a way that, when it’s done, you are guaranteed that it has visited 
 * every vertex that’s connected to the starting vertex. 
 * Note : graph is a collection of connected and unconnected vertex.
 * 
 * The depth-first search uses a stack to remember where it should go when it reaches a dead end.
 * 
 * To carry out the DFS, pick a starting node then do three things: 
 * visit this vertex, push it onto a stack so you can remember it, and mark it so you won’t visit it again.
 * Next, you go to any vertex adjacent to A that hasn’t yet been visited and do the same thing as before: go to an adjacent
vertex that hasn’t been visited. This leads you to F. We can call this process Rule 1.
If you can’t follow Rule 1, then, if possible, pop a vertex off the stack.
If you can’t follow Rule 1 or Rule 2, you’re done.
 * @author Manish
 *
 */

public class DFSalgo {
	
	public static void main(String args[]){
		B_Graph graph = new B_Graph(6);
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 4);
		graph.addEdge(1, 3);
		graph.addEdge(1, 5);
		graph.addEdge(2, 3);
		graph.addEdge(2, 5);
		graph.addEdge(3, 4);
		
		graph.displayGraph();
		
	}
	
	public void dfs(Vertex startPoint){ 
		
	}
	
	

}

package DS.Graph.simple;

/**
 * Graph is a collections of vertices and edges.
 * Adjacency : Two vertices are said to be adjacent to one another if they are connected by a single edge.
 * Paths : A path is a sequence of edges.
 * 		There can be more than one path between two vertices;
 * Connected Graphs : If there is at least one path from every vertex to every other vertex.
 * 
 * Directed Graphs : you can go in only one direction along an edge—from A to B but not from B to A, as on a one-way street.
 * The allowed direction is typically shown with an arrowhead at the end of the edge
 * Non-directed Graph : edges don’t have a direction; you can go either way on them.  
 * 
 * Weighted Graphs : when edges are given a weight. distance between two vertices, or the time it takes to get 
 * 
 * Representing a Graph in a Program : 
 * 	- Vertices : Generally represented by a class with attribute label and isVisited.
 * 	- Edges : in a graph each vertex may be connected to an arbitrary number of other vertices.
 * 			To model this sort of free-form organization, a following two different approach are used to represent edges.
 * 		- The Adjacency Matrix : A two-dimensional(NxN) array in which the elements indicate whether an edge is present between two vertices. 
 * 		- The Adjacency List : an adjacency list is an array of lists (or sometimes a list of lists). 
 * 		  Each individual list shows what vertices a given vertex is adjacent to.
 * 
 * 				Vertex List Containing Adjacent Vertices
					A 			B—>C—>D
					B 			A—>D
					C 			A
					D 			A—>B
 *
 * 		Don’t confuse the contents of adjacency lists with paths.
 * 		The adjacency list shows which vertices are adjacent to—that is,
 * 		one edge away from—a given vertex, not paths from vertex to vertex.
 * 
 * Operations on Graph : 
 *  - Adding Vertices and Edges :
 *  	Create a new vertex object with new and insert it into your vertex array, vertexList.
 *  		vertexList[nVerts++] = new Vertex(‘F’);
 * To add an edge (between vertices 1 and 3)to a graph using an adjacency matrix 
 * When you first created the adjacency matrix adjMat, you filled it with 0s. 
 * To insert the edge, between vertices 1 and 3 you say 
 * 					adjMat[1][3] = 1;
 * 					adjMat[3][1] = 1;
 * If you were using an adjacency list, you would add a 1 to the list for 3, and a 3 to the list for 1.
 * 
 * Note that you are inserting redundant info and this redundancy may seem inefficient, 
 * but there’s no convenient way to create a triangular 
 * array in most computer languages, so it’s simpler to accept the redundancy. 
 * Consequently, when you add an edge to the graph, you must make two entries in the adjacency matrix rather than one.
 */

public class A_GraphBasics {
	
	
	public static void main(String args[]){
		B_Graph graph = new B_Graph(5);
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(1, 3);
		
		graph.displayGraph();

	}
	
	
}


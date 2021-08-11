package DS.Graph.simple;

public class B_Graph {
	private final int MAX_VERTS;
	private Vertex[] vertexList;
	private int vertexCount;
	private boolean adjMatrix[][]; 
	
	public B_Graph(int maxVertex) {
		this.MAX_VERTS = maxVertex;
		this.vertexList = new Vertex[MAX_VERTS];
		adjMatrix = new boolean[MAX_VERTS][MAX_VERTS];
		for (int i=0; i<MAX_VERTS; i++ ) {
			for (int j=0; j<MAX_VERTS; j++ ) {
				adjMatrix[i][j]=false;
			}
		}
	}
	
	public void addVertex(String label){
		
		if (validateInsert(label)) {
			this.vertexList[vertexCount++] = new Vertex(label);
		}
	}
	
	public void addEdge(int startNode, int endNode){
		adjMatrix[startNode][endNode]=true;
		adjMatrix[endNode][startNode]=true;
	}
	
	public void displayVertex() {
		for (int i =0; i< vertexCount; i++) {
			System.out.println(vertexList[i].getLabel());
		}		
	}
	
	private boolean validateInsert(String label){
		if (vertexCount >= MAX_VERTS){
			System.out.println("Can not insert node : " +label);
			return false;
		}
		return true;
	}
	
	public void displayGraph() {
		for (int i=0; i<vertexCount; i++ ) {
			System.out.print(vertexList[i].getLabel() + " :  ");
			for (int j=0; j<vertexCount; j++ ) {
				System.out.print(adjMatrix[i][j] + "   ");
			}
			System.out.println();
		}
		
	}
}

class Vertex {
	String label;
	boolean isVisited;	
	
	Vertex(String label){
		this.label = label;
		isVisited=false;		
	}
	
	String getLabel() {
		return this.label;
	}
	
	
}

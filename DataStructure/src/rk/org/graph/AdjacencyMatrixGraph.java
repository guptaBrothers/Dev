package rk.org.graph;

/**
 * Graph represented as Adjecency Matrix.
 * ADTs are
 * 1. Add an edge 
 * 2. Remove an edge 
 * 3. check is edge exists between two  vertexes.
 * 
 * Note this is an Directed graph
 * 
 * 
 * @author rahul
 *
 */
public class AdjacencyMatrixGraph {
	private int vertexCount;
	private boolean[][] adjMat ;
	
	public AdjacencyMatrixGraph(int vertexCount){
		this.vertexCount =vertexCount;
		this.adjMat =new boolean[vertexCount][vertexCount];
	}
	
	public void addEdge(int source,int destination){
		if(source<vertexCount && destination<vertexCount && source>-1 && destination>-1){
			adjMat[source][destination]=true;
		}
	}
	
	public void removeEdge(int source,int destination){
		if(source<vertexCount && destination<vertexCount && source>-1&& destination>-1){
			adjMat[source][destination]=false;
		}
	}
	
	public boolean isAnEdge(int source, int destination){
		if(source<vertexCount && destination<vertexCount && source>-1 && destination>-1 && adjMat[source][destination]){
			return true;
		}
		return false;
	}

}

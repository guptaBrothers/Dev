package rk.org.graph;

/**
 * Graph represented as Adjecency Matrix.
 * ADTs are
 * 1. Add an edge 
 * 2. Remove an edge 
 * 3. check is edge exists between two  vertexes.
 * 
 * Note this is an Undirected graph
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
	
	public void addEdge(int i,int j){
		if(i<vertexCount && j<vertexCount && i>-1 && j>-1){
			adjMat[i][j]=true;
		}
	}
	
	public void removeEdge(int i,int j){
		if(i<vertexCount && j<vertexCount && i>-1&& j>-1){
			adjMat[i][j]=false;
		}
	}
	
	public boolean isAnEdge(int i, int j){
		if(i<vertexCount && j<vertexCount && i>-1 && j>-1 && adjMat[i][j]){
			return true;
		}
		return false;
	}

}

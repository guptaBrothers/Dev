package rk.org.graph;

import java.util.ArrayList;
import java.util.List;

import rk.org.linkedList.LinkedListADT;

public class AdjacencyListGraph {
	private List<Integer> vertices;
	private LinkedListADT[] edges;
	
	public AdjacencyListGraph(int vertexCount){
		this.vertices = new ArrayList<>();
		this.edges = new LinkedListADT[vertexCount];
		for(int i=0;i<vertexCount;i++){
			edges[i]= new LinkedListADT();           // at each indexed edge node an adjacent list is created.
		}
	}
	public void addEdge(int source, int destination){
		int i =vertices.indexOf(source);
		int j =vertices.indexOf(destination);
		if(i!=-1 && j!=-1){
			edges[i].insertAtBegenning(destination);
			edges[j].insertAtBegenning(source);
		}
	}
	
	
}

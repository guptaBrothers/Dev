package rk.org.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WeightedGraph {
	private int vCount;
	private List<WeightedGraphNode> adj[];
	
	public WeightedGraph(int v){
		this.vCount = v;
		this.adj = new LinkedList[v];
		for(int i=0;i<v;i++){
			this.adj[i] = new LinkedList<WeightedGraphNode>();
		}
	}
	
	public int getvCount() {
		return vCount;
	}

	public void setvCount(int vCount) {
		this.vCount = vCount;
	}

	public List[] getAdj() {
		return adj;
	}

	public void setAdj(List[] adj) {
		this.adj = adj;
	}
	
	public void addEdge(int source , WeightedGraphNode destination){
		if(source > -1 && source < this.getvCount() && destination.getVertex() > -1 && destination.getVertex() < this.vCount){
			this.getAdj()[source].add(destination);
		}
	}

}

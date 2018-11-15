package rk.org.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WeightedGraph {
	private int vCount;
	private List adj[];
	private Map<Integer ,Integer> weightMap ;
	
	public WeightedGraph(int v , Map<Integer ,Integer> weightMap){
		this.vCount = v;
		this.adj = new LinkedList[v];
		for(int i=0;i<v;i++){
			this.adj[i] = new LinkedList<WeightedGraphNode>();
		}
		this.weightMap = new HashMap<>(weightMap);
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

	public Map<Integer, Integer> getWeightMap() {
		return weightMap;
	}


	public void setWeightMap(Map<Integer, Integer> weightMap) {
		this.weightMap = weightMap;
	}

}

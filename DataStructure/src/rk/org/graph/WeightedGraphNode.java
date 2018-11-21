package rk.org.graph;

import java.util.Comparator;

public class WeightedGraphNode {
		public Integer vertex ;
		public Integer edgeWeight ;
		
		public WeightedGraphNode(){}
		
		public WeightedGraphNode(int vertex , int weight){
			this.vertex = vertex;
			this.edgeWeight = weight;
		}
		
		@Override
		public boolean equals(Object obj){
			
			if(obj instanceof WeightedGraphNode){
				if(this.getVertex() == ((WeightedGraphNode)obj).getVertex()){
					return true;
				}
			}
			return false;
		}

		public int getVertex() {
			return vertex;
		}

		public void setVertex(int vertex) {
			this.vertex = vertex;
		}

		public int getEdgeWeight() {
			return edgeWeight;
		}

		public void setEdgeWeight(int edgeWeight) {
			this.edgeWeight = edgeWeight;
		}
	}
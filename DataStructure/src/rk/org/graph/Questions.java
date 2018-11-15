package rk.org.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Questions {
	
	
	private void findAllPathsBwTwoNodes(Graph g,int source, int destination){
		List<Integer> path = new LinkedList<>();
		boolean visitedForCycle[] = new boolean[g.getvCount()];
		boolean recStack[] = new boolean[g.getvCount()];
		//visitedForCycle[source] = true;
		//recStack[source] = true;
		if(!isCycleInGraph(g,source,visitedForCycle,recStack)){
			boolean visited[] = new boolean[g.getvCount()];
			Queue<Integer> q = new LinkedList<>();
			q.offer(source);
			dfs(g,source,path,visited,destination);
		}
		
	}
	
	
	private void dfs(Graph g, int source, List<Integer> path, boolean[] visited, int destination) {
		// TODO Auto-generated method stub
		
		Iterator<Integer>itr = g.getAdj()[source].iterator();
		int prevEdge = source;
		while(itr.hasNext()){
			int edge = itr.next();
			if(edge==destination){
				path.add(destination);
				displayPath(path);
				path.remove((Object)destination);
				path.remove((Object)prevEdge);
			}
			else if(!visited[edge]){
				path.add(edge);
				prevEdge=edge;
				visited[edge] = true;
				dfs(g,edge,path,visited,destination);
			}
		}
	}


	private void displayPath(List<Integer> path) {
		System.out.println("\n Path is : ");
		path.stream()
			.forEach(edge -> System.out.print(" " + edge));
	}


	/**
	 * To detect cycle in graph, proceed with DFS
	 * Maintain a recurtion stack array to keep track of visited vetex in the recurtion stack
	 * 
	 * @param g
	 * @param source
	 * @param recStack 
	 * @param recStack2 
	 * @return
	 * 
	 * source +----+---
	 *      	   -  -
	 *      	   ----
	 */
	private boolean isCycleInGraph(Graph g,int source, boolean[] visited, boolean[] recStack){
		
		// traverse the graph(BFS*/DFS) and check if the vertex is already visited
		
		if(!visited[source]){
			// Mark the current node as visited and part of recursion stack
			visited[source] = true;
			recStack[source] = true;
			
			Iterator<Integer>itr = g.getAdj()[source].iterator();
			while(itr.hasNext()){
				int edge = itr.next();	

				if(!visited[edge] && isCycleInGraph(g,edge,visited,recStack))
					return true;
				else if(recStack[edge])
					return true;
			}
		} 
		recStack[source] =false;  // remove the vertex from recursion stack
		return false;
	}
	
	
	
	/**
	 * Practical applications
	 * 1. Dependency resolution
	 * 2. Build sequence in multi-tier application,jenkins
	 * 3. Scheduling of jobs in sequence
	 * 4. formula evaluation
	 * 
	 * 
	 * @param g
	 */
	public void topologicalSort(Graph g){
		boolean visited[] = new boolean[g.getvCount()];
		for(int i=0;i<g.getvCount();i++)
			visited[i] = false;
		
		Stack s = new Stack<Integer>();
		
		for(int i=0;i<g.getvCount();i++){
			if(!visited[i])
				topologicalSortUtil(g,i,visited,s);
		}
		
		while(!s.isEmpty()){
			System.out.println(" " + s.pop());
		}
	}

	/**
	 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices 
	 * such that for every directed edge uv, vertex u comes before v in the ordering.
	 * Topological Sorting for a graph is not possible if the graph is not a DAG.
	 * 
	 * 
	 * 
	 * @param g
	 * @param i
	 * @param visited
	 * @param s
	 */
	private void topologicalSortUtil(Graph g, int i, boolean[] visited, Stack<Integer> s) {
		
		visited[i] = true;
		Iterator<Integer> itr = g.getAdj()[i].listIterator();
		while(itr.hasNext()){
			int edge = itr.next();
			if(!visited[edge]){
				topologicalSortUtil(g, edge, visited, s);
			}
		}
		s.push(new Integer(i));
	}
	
	
	
	/**
	 * Find distance of each node from source in unweighted graph(i.e each edge of 
	 * weight 1 unit) 
	 * 
	 * Perform BFS
	 * Maintain a queue that tracks bfs order
	 * At each node get the adjacency list , for each check if not visited
	 * update its distance as distance of current source/node plus one
	 * 
	 * As the traversal is lavel of bredth wise hence minimum distance for each node 
	 * from source is found for unweighted graph
	 * 
	 * @param g
	 * @param source
	 */
	private void findDistanceOfEachNodeFromSource(Graph g , int source){
		Queue<Integer> q = new LinkedList<>();
		int path[] = new int[g.getvCount()];
		int distance[] = new int[g.getvCount()];
		for(int i = 0 ; i< distance.length ;i++)
			distance[i] = -1;
		path[source] = source;
		distance[source] = 0;
		q.offer(source);
		
		while(!q.isEmpty()){
			int s = q.poll();
			List<Integer> adj = g.getAdj()[s];
			adj.stream()
			   .forEach(e ->{
				   if(distance[e] == -1){
					   distance[e] = distance[s] +1;
					   path[e] = s;
					   q.offer(e);
					  }
			   	});
		}
		
		Arrays.stream(distance).forEach(System.out :: println);
	}
	
	
	/**
	 * Find sorted path from source to each node for weighted graph
	 * 
	 * @param g
	 * @param source
	 */
	private void dijkstraAlgo(WeightedGraph g , int source ){
		PriorityQueue<WeightedGraphNode> pQ = new PriorityQueue<>();
		WeightedGraphNode sourceNode = new WeightedGraphNode(source , g.getWeightMap().get(source));
		pQ.offer(sourceNode);
		int path[] = new int[g.getvCount()];
		int distance[] = new int[g.getvCount()];
		for(int i = 0 ; i< distance.length ;i++)
			distance[i] = -1;
		path[source] = source;
		distance[source] = 0;
		
		while(!pQ.isEmpty()){
			WeightedGraphNode tempSource = pQ.poll();
			List<WeightedGraphNode> adjNode = g.getAdj()[source]; 
			adjNode.stream()
				   .forEach(node -> {
					   int currVertex = node.getVertex();
					   int tempVertex = tempSource.getVertex();
					   int newDistance = distance[tempVertex] + node.getEdgeWeight();
					   if(distance[currVertex] == -1){
						   distance[currVertex] = newDistance;
						   pQ.offer(node);
						   path[currVertex] = tempVertex;
					   }
					   else if(distance[currVertex] >  newDistance){
						   distance[currVertex] = newDistance;
						   Iterator<WeightedGraphNode> itr = pQ.iterator();
						   while(itr.hasNext()){
							   WeightedGraphNode dummyNode = itr.next();
							   if(dummyNode.getVertex() == currVertex){
								   dummyNode.setEdgeWeight(newDistance);
							   }
						   }
						   path[currVertex] = tempVertex;
						   
					   }
					   
					});
		}
		
		Arrays.stream(distance).forEach(System.out :: println);
		
		
	}
	
	private class WeightGraphNode implements Comparator{
		public Integer vertex ;
		public Integer edgeWeight ;
		
		@Override
		public int compare(Object obj1, Object obj2) {
			if (obj1 instanceof WeightGraphNode && obj2 instanceof WeightGraphNode) {
				return ((WeightGraphNode)obj1).edgeWeight.compareTo(((WeightGraphNode)obj2).edgeWeight);
			}
			else{
				System.out.println(" Invalid type");
				return 0;
			}
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


	public static void main(String[] args) {
		int vertexCount = 5;
		Graph g = new Graph(vertexCount);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 4);
		g.addEdge(1, 4);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		
		g.setvCount(vertexCount);
		
		Questions obj = new Questions();
		//obj.findAllPathsBwTwoNodes(g,0, 4);
		//obj.topologicalSort(g);
		//obj.findDistanceOfEachNodeFromSource(g, 1);
		Map<Integer,Integer> weightMap = new HashMap<>();
		weightMap.put(0, 0);
		weightMap.put(1, 1);
		weightMap.put(2, 2);
		weightMap.put(3, 3);
		weightMap.put(4, 8);
		
		WeightedGraph wGraph = new WeightedGraph(vertexCount, weightMap);
		obj.dijkstraAlgo(wGraph, 0);

	}

}

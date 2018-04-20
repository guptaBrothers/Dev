package rk.org.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Questions {
	
	
	private void findAllPathsBwTwoNodes(Graph g,int source, int destination){
		List<Integer> path = new LinkedList<>();
		boolean visitedForCycle[] = new boolean[g.getvCount()];
		boolean recStack[] = new boolean[g.getvCount()];
		visitedForCycle[source] = true;
		recStack[source] = true;
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
	 */
	private boolean isCycleInGraph(Graph g,int source, boolean[] visited, boolean[] recStack){
		
		// traverse the graph(BFS*/DFS) and check if the vertex is already visited
		
		if(visited[source]==false){
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

	public static void main(String[] args) {
		int vertexCount = 5;
		Graph g = new Graph(vertexCount);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 4);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(2, 4);
		
		g.setvCount(vertexCount);
		
		Questions obj = new Questions();
		obj.findAllPathsBwTwoNodes(g,0, 4);

	}

}

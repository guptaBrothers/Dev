package rk.org.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Graph {
	private int vCount;
	private List adj[];
	
	public Graph(int v){
		this.vCount = v;
		this.adj = new LinkedList[v];
		for(int i=0;i<v;i++){
			this.adj[i] = new LinkedList<Integer>();
		}
	}
	
	public List[] getAdj() {
		return adj;
	}

	public void setAdj(List[] adj) {
		this.adj = adj;
	}

	public int getvCount() {
		return vCount;
	}

	public void setvCount(int vCount) {
		this.vCount = vCount;
	}



	public void addEdge(int sourceVertex,int destinationVertex){
		if(sourceVertex <= this.vCount && destinationVertex <= this.vCount && sourceVertex!=-1 && destinationVertex!=-1){
			// for directed graph
			this.adj[sourceVertex].add(destinationVertex);
		}
	}
	
	public void DFSUtil(int v,boolean visited[])
	    {
	        visited[v] = true;         // Mark the current node as visited and print it
	        System.out.print(v+" ");
	        Iterator<Integer> i = adj[v].listIterator();     // Recur for all the vertices adjacent to this vertex
	        while (i.hasNext())
	        {
	            int n = i.next();
	            if (!visited[n])
	                DFSUtil(n, visited);
	        }
	    }
	 
	/**
	 * The function to do DFS traversal. It uses recursive DFSUtil()
	 * @param v
	 */
	public void DFS(int v)
	    {
	        boolean visited[] = new boolean[vCount];       // Mark all the vertices as not visited(set as false by default in java)
	        DFSUtil(v, visited);						   // Call the recursive helper function to print DFS traversal
	    }
	
	
	
	 void BFS(int s)
	    {
	        boolean visited[] = new boolean[vCount];		// Mark all the vertices as not visited(By default set as false)
	        for(int i=0;i<visited.length;i++){
	        	visited[i]=false;
	        }
	 
	        // Create a queue for BFS
	        LinkedList<Integer> queue = new LinkedList<Integer>();
	        visited[s]=true;		// Mark the current node as visited and enqueue it
	        queue.add(s);
	        while (queue.size() != 0)
	        {
	            s = queue.poll();		// Dequeue a vertex from queue and print it
	            System.out.print(s+" ");
	          
	            Iterator<Integer> i = adj[s].listIterator();
	            while (i.hasNext())
	            {
	                int n = i.next();
	                if (!visited[n])
	                {
	                    visited[n] = true;
	                    queue.add(n);
	                }
	            }
	        }
	    }
	
	
	
	
	 public static void main(String args[])
	    {
		 Graph g = new Graph(4);
	 
	        g.addEdge(0, 1);
	        g.addEdge(0, 2);
	        g.addEdge(1, 2);
	        g.addEdge(2, 0);
	        g.addEdge(2, 3);
	        g.addEdge(3, 3);
	 
	        System.out.println("Following is Depth First Traversal "+
	                           "(starting from vertex 2)");
	 
	        g.DFS(2);
	    }

}

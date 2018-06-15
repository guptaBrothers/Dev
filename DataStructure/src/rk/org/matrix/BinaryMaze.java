package rk.org.matrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryMaze {
	
	/*
	 * Find all possible path from source to destination
	 * Find shortest path to destination
	 * 
	 * */
	int mat[][] = {{1,0,1,1},
			   	   {1,1,0,1},
			       {1,1,0,1},
			       {1,1,1,1}};
	int rowSize = 4;
	int colSize = 4;
	int[] neighbourRow = {-1,0,0,1};
	int[] neighbourCol = {0,-1,1,0};
	
	
	private boolean isValidRowCol(int row,int col){
		
		return (row >=0 && row < rowSize) && (col >=0 && col< colSize);
	}
	
	

	/**
	 * Finds the shortest distance
	 * 
	 * Actually it interpolates each neighbouring non visited cell with incremental distance with help of queue.
	 * At each next node either same distance node is picked of 1 greater hence it helps to get shortest distance 
	 * 
	 * Steps
	 * 
	 * 1. We LOOP till queue is not empty
	 * 2. Dequeue front cell from the queue
	 * 3. Return if the destination coordinates have reached.
	 * 4. For each of its four adjacent cells, if the value is 1 and they are not visited yet,
	 *    we enqueue it in the queue and also mark them as visited.
	 * 
	 * @param mat
	 * @param rowSize
	 * @param colSize
	 * @param src
	 * @param dest
	 */
	private void pathFinder(int[][] mat, int rowSize, int colSize,Point src, Point dest) {
		
		boolean visitedMat[][] =new boolean[rowSize][colSize];
		visitedMat[src.x][src.y] = true;
		List<MazeCell> path = new ArrayList<>();
		
		Queue<MazeCell> q = new LinkedList<>();
		MazeCell source = new MazeCell(src,0);
		q.offer(source);
		
		while(!q.isEmpty()){
			MazeCell currCell = q.poll();
			Point pt = currCell.pt;
			if(pt.x == dest.x && pt.y == dest.y){
				System.out.println("path exist with distance "+ currCell.dist +"\n");
				for(int i=0 ; i< rowSize;i++){
					for(int j=0;j<colSize;j++){
						System.out.print(visitedMat[i][j]);
					}
					System.out.println();
				}
				return;
			}
			for(int i =0;i<4;i++){                  // add each adjacent valid cell to queue 
				int row = pt.x + neighbourRow[i];
				int col = pt.y + neighbourCol[i];
				
				if(isValidRowCol(row, col) && mat[row][col] == 1 && !visitedMat[row][col]){
					Point p = new Point(row,col);
					MazeCell newCell = new MazeCell(p,currCell.dist+1);
					
					visitedMat[row][col] =true;
					q.offer(newCell);
				}
			}
			
		}
		
		System.out.println("No path exists");
		
	}
	
	
	public static void main(String[] args) {
			
			Point dest = new Point(1,3);
			Point src = new Point(0,0);
			
			BinaryMaze obj = new BinaryMaze();
			obj.pathFinder(obj.mat,obj.rowSize,obj.colSize,src,dest);
		}
	}

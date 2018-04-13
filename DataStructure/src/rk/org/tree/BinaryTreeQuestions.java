package rk.org.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeQuestions {
	
	/*
	 *  1. Find the diameter of the tree (diameter = longest path between two nodes)
	 *  2. 
	 * */
	
	public static BinaryTreeNode createBinaryTree(int arr[]){
		if(arr.length==0){
			return null;
		}
		BinaryTreeNode root = new BinaryTreeNode(arr[0]);
		generateBT(root,arr,2);
		return root;
	}
	
	private static void generateBT(BinaryTreeNode root, int[] arr, int i) {
		if(i<=arr.length){
			BinaryTreeNode leftNode = new BinaryTreeNode(arr[i-1]);   // index of array is one less then the natural position of tree
			root.setLeft(leftNode);
			generateBT(leftNode,arr,2*i);
		}
		if(i+1<=arr.length){
			BinaryTreeNode rightNode = new BinaryTreeNode(arr[(i+1)-1]);
			root.setRight(rightNode);
			generateBT(rightNode,arr,2*(i+1));
			
		}
	}
	
	private static  void displayBTLevelWise(BinaryTreeNode root){
		BinaryTreeNode current =null;
		current = root;
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(current);
		while(!q.isEmpty()){
			current = q.remove();
			System.out.print(current.getData() + " ");
			if(current.getLeft()!=null)
				q.offer(current.getLeft());
			if(current.getRight() !=null)
				q.offer(current.getRight());
		}
	}

	public static void main(String args[]){
		int arr[] = {2,5,3,7,6,9,11,10,1,4,8};
		BinaryTreeNode root = createBinaryTree(arr);
		displayBTLevelWise(root);
		
	}

}

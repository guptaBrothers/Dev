package rk.org.tree.bst;

import java.util.ArrayList;
import java.util.List;

public class BSTQuestions {
	
	public BSTNode buildBST(int arr[]){
		
		return null;
	}
	
	public int findDistanceBetweenTwoNodesInBST(BSTNode root ,BSTNode a , BSTNode b){
		int count = 0;
		List<BSTNode> path = new ArrayList<>();
		if(root == null){
			System.out.println("Node not found");
			return -1;
		}
		if(b.getData() == a.getData())
			return 0;
		if(root.getData() == a.getData()){
			path.add(a);
			count = findPathBetweenNode(root , b , count , path);
		}
		else{
			path.add(b);
			findPathBetweenNode(root , a , count , path);
		}
		
		return count;
	}

	private int findPathBetweenNode(BSTNode root, BSTNode x, int count, List<BSTNode> path) {
		if(root == null){
			System.out.println(" Node " +x.getData() + " not present");
			return -1;
		}
		if(x.getData() == root.getData()){
			path.add(x);
			count++;
		}
		else if(x.getData() < root.getData() ){
			path.add(root.getLeft());
			findPathBetweenNode(root.getLeft(), x , ++count , path);
		}
		else{
			path.add(root.getRight());
			findPathBetweenNode(root.getRight(), x , ++count , path);
		}
		
		return count;
	}
	

}

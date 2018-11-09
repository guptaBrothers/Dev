package rk.org.tree.avl;

import rk.org.tree.BinaryTreeNode;
import rk.org.tree.BinaryTreeQuestions;

public class AVLOperations {
	
	public AVLTreeNode insertInAVLTree(AVLTreeNode root,int data){
		if(root == null){
			AVLTreeNode newNode = new AVLTreeNode(data);
			newNode.setHeight(0);
			root = newNode;
		}
		else if(data < root.getData()){
				root.setLeft(insertInAVLTree(root.getLeft,data));
				if(Math.abs(root.getLeft().height - root.getRight().height) > 1){
					if(data < root.getLeft().data)
						SingleRotateLeft(root.getLeft());
					else
						DoubleRotateLeft(root.getLeft());
				
				}
			}
			else {
				root.setRight(insertInAVLTree(root.getRight(),data));
				if(Math.abs(root.getLeft().height -root.getRight().height) > 1)
					if(data > root.getright().data)
						SingleRotateRight(root.getRight());
					else
						DoubleRotateRight(root.getRight());
			}
		return root;
	}
	
	
	
	public static void main(String[] args) {
		int arr[] = {2,5,3,7,6,9,11,10,1,4,8};
		BinaryTreeNode root = BinaryTreeQuestions.createBinaryTree(arr);
		AVLOperations obj = new AVLOperations();
		//obj.insertInAVLTree(root, null, 12);
	}

}

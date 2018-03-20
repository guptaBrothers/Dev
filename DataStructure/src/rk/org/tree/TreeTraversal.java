package rk.org.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversal {

	BinaryTreeNode root;
	// create a tree
	/*
	 * traverse 1. PreOrder-recurcive,iterative 2. PostOrder-recurcive,iterative
	 * 3. InOrder - recurcive,iterative 4. LevelOrderTraversal
	 * 
	 */

	public static void main(String args[]) {
		TreeTraversal sampleBinaryTree = new TreeTraversal();
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		sampleBinaryTree.root = sampleBinaryTree.createBinaryTree(array);
		BinaryTreeNode current = sampleBinaryTree.root;
		System.out.print("PreOrder : ");
		sampleBinaryTree.preOrder(current);
		System.out.print("\nInOrder : ");
		sampleBinaryTree.inOrder(current);
		System.out.print("\nPostOrder : ");
		sampleBinaryTree.postOrder(current);
		System.out.print("\nPreOrder Iterative : ");
		sampleBinaryTree.preOrderIterative(current);
		System.out.print("\nInOrder Iterative : ");
		sampleBinaryTree.inOrderIterative(current);
		System.out.print("\nPostOrder Iterative ");
		sampleBinaryTree.postOrderTraversalIterative(current);
		System.out.print("\nLevelOrder \n");
		sampleBinaryTree.levelOrderTraversal(current);

	}

	public BinaryTreeNode createBinaryTree(int[] array) {
		// TODO Auto-generated method stub
		int arraylength = array.length;
		boolean isRoot = true;
		boolean balancedTreeFlag = false;
		BinaryTreeNode root = null;
		BinaryTreeNode currentNode = new BinaryTreeNode();
		boolean leftChild = true;
		boolean rightChild = true;
		for (int i = 0; i < arraylength; i++) {

			if (isRoot) {
				currentNode.setData(array[i]);
				root = currentNode;
				isRoot = false;
			} else if (i < arraylength - 1 && leftChild) {
				BinaryTreeNode left = new BinaryTreeNode(array[i]);
				currentNode.setLeft(left);
				if (balancedTreeFlag) {
					currentNode = left;
					balancedTreeFlag = false;
				}
				rightChild = true;
				leftChild = false;
			} else if (i < arraylength - 1 && rightChild) {
				BinaryTreeNode right = new BinaryTreeNode(array[i]);
				currentNode.setRight(right);
				if (!balancedTreeFlag) {
					currentNode = right;
					balancedTreeFlag = true;
				}
				leftChild = true;
				rightChild = false;
			}

		}
		return root;
	}

	public void preOrder(BinaryTreeNode root) {
		if (root != null) {
			System.out.print(root.getData() + ",");
			preOrder(root.getLeft());
			preOrder(root.getRight());
		}
	}

	public void inOrder(BinaryTreeNode root) {
		if (root != null) {
			inOrder(root.getLeft());
			System.out.print(root.getData() + ",");
			inOrder(root.getRight());
		}
	}

	public void postOrder(BinaryTreeNode root) {
		if (root != null) {
			postOrder(root.getLeft());
			postOrder(root.getRight());
			System.out.print(root.getData() + ",");
		}
	}

	public void preOrderIterative(BinaryTreeNode root) {
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		if (root == null)
			return;
		s.push(root);
		BinaryTreeNode temp = null;
		while (!s.isEmpty()) {
			temp = s.pop();
			System.out.print(temp.getData() + ",");
			if (temp.getRight() != null) { // note order in which left and right
											// child should be pushed to stack
											// should be opposite to NLR order
				s.push(temp.getRight());
			}
			if (temp.getLeft() != null) {
				s.push(temp.getLeft());
			}
		}

	}

	public void inOrderIterative(BinaryTreeNode root) {
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		boolean done = false;
		BinaryTreeNode current = root;
		while (!done) {
			if (current != null) {
				s.push(current);
				current = current.getLeft();
			} else {
				if (s.isEmpty())
					done = true;
				else {
					current = s.pop();
					System.out.print(current.getData() + " ");
					current = current.getRight();
				}
			}
		}
	}

	
	/*
	 * For Post order LRN , we need to put root node at start of the stack , also keep  track of 
	 * previous element .
	 * For case of previous element 
	 * 1. if (prev== null -> at start || prev.left== current || prev.right==current -> the child are not visited
	 *  then added the respective left child, if not then right child)
	 * 2. if (current.left == prev -> that left node is already visited hence traverse the right node of current)
	 * 3. if (current =prev) -> check this after the left nodes are visited
	 *     the  pop the current node as all its left and right child are visited.(and add the node to traversal list) 
	 * */
	public void postOrderTraversalIterative(BinaryTreeNode root) {
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		if(root == null)
			return;
		
		s.push(root);
		BinaryTreeNode prev = null;
		while (!s.isEmpty()) {
			BinaryTreeNode current = s.peek();
			if (prev == null || prev.getLeft() == current || prev.getRight() == current) // top to bottom (prev < current)
			{
				if (current.getLeft() != null) {
					s.push(current.getLeft());
				} else if (current.getRight() != null) {
					s.push(current.getRight());
				}
			} else if (current.getLeft() == prev) {
				if (current.getRight() != null) {
					s.push(current.getRight());
				}
			} else {              // bottom to top (current < prev)
				s.pop();
				System.out.print(" " + current.getData());
			}
			prev = current;	
		}
	}

	public void levelOrderTraversal(BinaryTreeNode root) {
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		List<Integer> levelOrderList = new ArrayList<Integer>();
		List<Integer> levelElements = new ArrayList<Integer>();
		q.offer(root);
		q.offer(null);
		int level = 0;
		while (!q.isEmpty()) {
			BinaryTreeNode temp = q.poll();
			if (temp != null) {
				levelElements.add(temp.getData());
				if (temp.getLeft() != null) {
					q.offer(temp.getLeft());
				}
				if (temp.getRight() != null) {
					q.offer(temp.getRight());
				}
			} else {
				System.out.println("Level " + level++ + " elements are " + levelElements);
				levelOrderList.addAll(levelElements);
				levelElements.clear();
				if (!q.isEmpty()) {
					q.offer(null); // to detect level
				}
			}

		}
	}

}

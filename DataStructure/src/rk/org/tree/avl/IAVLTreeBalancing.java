package rk.org.tree.avl;

public interface IAVLTreeBalancing {
	//un-balance at left - left
	public AVLTreeNode SingleRotationLeft(AVLTreeNode root);
	//right-right
	public AVLTreeNode SingleRotationRight(AVLTreeNode root);
	
	//left-right
	public AVLTreeNode DoubleRotationLeft(AVLTreeNode root);
	//right-left
	public AVLTreeNode DoubleRotationRight(AVLTreeNode root);

}

package rk.org.tree.avl;

public class AVLTreeBalancing implements IAVLTreeBalancing {
	
	
	
 /*       X  --->root node where insertion has occurred causing in balance
         / \
        /   \
       W     right
     /  \
    /    \
   left   right
*/

	@Override
	public AVLTreeNode SingleRotationLeft(AVLTreeNode root) {
		AVLTreeNode x = root;
		AVLTreeNode w = x.getLeft();
		x.setLeft(w.getRight());
		w.setRight(x);
		x.setHeight(x.getHeight()+1);    // check if it need calculation of height Max(left,right)+1
		w.setHeight(w.getHeight()-1);
		return w;
	}

	
/*       X  --->root node where insertion has occurred causing in balance
       /  \
      /    \
     left   W
           /  \
          /    \
        left   right
*/
	
	
	@Override
	public AVLTreeNode SingleRotationRight(AVLTreeNode root) {
		AVLTreeNode x = root;
		AVLTreeNode w = x.getRight();
		x.setRight(w.getLeft());
		w.setLeft(x);
		x.setHeight(x.getHeight()+1);
		w.setHeight(w.getHeight()-1);
		return w;
	}
	
	/* 
	 *              Z
	 *             /  \  
	 *            /    \
		         X  --->root node where insertion has occurred causing in balance
			    /  \
			   /    \
			  left   W
			        /  \
			       /    \
			     left   right
	*/		

	@Override
	public AVLTreeNode DoubleRotationLeft(AVLTreeNode root) {
		root.setLeft(SingleRotationRight(root.getLeft()));
		return SingleRotationLeft(root);
	}

	@Override
	public AVLTreeNode DoubleRotationRight(AVLTreeNode root) {
		root.setRight(SingleRotationLeft(root.getRight()));
		return SingleRotationRight(root);
	}
	
	

}

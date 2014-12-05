package tree;

public class CheckFoldableTree {
	public static boolean IfFoldable(BinaryTree root){
		if(root == null)
			return true;
		
		return IfFoldable(root.left, root.right);
	}
	
	public static boolean IfFoldable(BinaryTree left, BinaryTree right){
		if(left == null && right == null)
			return true;
		
		if(left == null || right == null)
			return false;
		
		return IfFoldable(left.right, right.left) && IfFoldable(left.left, right.right);
	}
}

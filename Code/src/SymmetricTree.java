import utility.*;

public class SymmetricTree {
	//Recursion and non-recursion...
	public static boolean isSymmetric(TreeNode root){
		if(root == null)
			return true;
		if(root.left == null && root.right == null)
			return true;
		if(root.left == null || root.right == null)
			return false;
		
		return isSymmetric(root.left, root.right);
	}
	
	public static boolean isSymmetric(TreeNode l, TreeNode r){
		if(l == null && r == null)
			return true;
		if(l == null || r == null)
			return false;
		
		if(l.val != r.val)
			return false;
		
		if(!isSymmetric(l.left, r.right))
			return false;
		
		if(!isSymmetric(l.right, r.left))
			return false;
		
		return true;
	}
	
	public static boolean isSymmetricNonRecursion(TreeNode root){
		return false;//hmm. not a good solution
	}
}

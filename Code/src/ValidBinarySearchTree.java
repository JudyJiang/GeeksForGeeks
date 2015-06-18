import utility.*;


public class ValidBinarySearchTree {
	public static boolean isValidBST(TreeNode root){
		if(root == null)
			return true;
		
		return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
	}
	
	public static boolean isValidBST(TreeNode root, double min, double max){
		if(root == null)
			return true;
		
		if(root.val >= max || root.val <= min)
			return false;
		
		boolean left = isValidBST(root.left, min, root.val);
		if(!left)
			return false;
		
		boolean right = isValidBST(root.right, root.val, max);
		if(!right)
			return false;
		
		return true;
	}
	
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(1);
//		TreeNode root = new TreeNode(8);
//		root.left = new TreeNode(3);
//		root.left.left = new TreeNode(1);
//		root.left.right = new TreeNode(6);
//		root.left.right.left = new TreeNode(4);
//		root.left.right.right = new TreeNode(7);
//		root.right = new TreeNode(10);
//		root.right.right = new TreeNode(14);
//		root.right.right.left = new TreeNode(13);
		System.out.println(isValidBST(root));
	}
}

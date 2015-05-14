import utility.*;

public class BalancedBinaryTree {
	
	public static int getHeight(TreeNode root){
		if(root == null)
			return 0;
		
		int left = getHeight(root.left);
		if(left == -1)
			return -1;
		int right = getHeight(root.right);
		if(right == -1)
			return -1;
		int abs = Math.abs(left - right);
		if(abs > 1)
			return -1;
		return Math.max(left,  right) + 1;
	}
	
	public static boolean isBalanced(TreeNode root){
		if(root == null)
			return true;
		
		return getHeight(root) != -1;
	}
	
	public static void main(String[] args){
		
	}
}

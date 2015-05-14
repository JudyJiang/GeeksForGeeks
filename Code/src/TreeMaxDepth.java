import utility.*;


public class TreeMaxDepth {
	public static int maxDepth(TreeNode root){
		if(root == null)
			return 0;
		
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
	public static void main(String[] args){
		
	}
}

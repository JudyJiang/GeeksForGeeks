import utility.*;

public class MaximumPathSum {
	public static int maximuPathSum(TreeNode root){
		if(root == null){
			return 0;
		}
		
		int[] res = new int[3];
		res[0] = Integer.MIN_VALUE;
		//res[0] current max value; res[1] single line value; res[2] cross-line values
		res = maximumPathSum(root, res);
		return res[0];
	}
	
	public static int[] maximumPathSum(TreeNode root, int[] res){
		if(root == null){
			return res;
		}
		
		int left = maximumPathSum(root.left, res)[1];
		int right = maximumPathSum(root.right, res)[1];
		int cross = left + root.val + right;
		
		
		return res;
	}
}

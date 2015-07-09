import utility.*;

public class MaximumPathSum {
	public static int maximuPathSum(TreeNode root){

		if(root == null){
			return 0;
		}
		

		int[] res = new int[1];
		res[0] = Integer.MIN_VALUE;
		maximumPathSum1(root, res);
		return res[0];
	}
	
	public static int maximumPathSum1(TreeNode root, int[] res){
		if(root == null){
			return 0;
		}

		int left = maximumPathSum1(root.left, res);
		int right = maximumPathSum1(root.right, res);
		
		int singleLine = Math.max(Math.max(left, right) + root.val, root.val);
		int crossLine = left + right + root.val;
		res[0] = Math.max(res[0], Math.max(singleLine, crossLine));
		return singleLine;
	}
	
	
	
}

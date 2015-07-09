import utility.*;


public class MaximumPathSum {
	public static int maximumPathSum(TreeNode root){
		if(root == null){
			return 0;
		}
		
		int[] res = new int[1];
		res[0] = Integer.MIN_VALUE;
		maximumPathSum(root, res);
		return res[0];
	}
	
	public static int maximumPathSum(TreeNode root, int[] res){
		if(root == null){
			return 0;
		}

		int left = maximumPathSum(root.left, res);
		int right = maximumPathSum(root.right, res);
		
		int singleLine = Math.max(Math.max(left, right) + root.val, root.val);
		int crossLine = left + right + root.val;
		res[0] = Math.max(res[0], Math.max(singleLine, crossLine));
		return singleLine;
	}
	
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		int res = maximumPathSum(root);
		System.out.println(res);
	}
}

import utility.*;

<<<<<<< HEAD

public class MaximumPathSum {
	public static int maximumPathSum(TreeNode root){
=======
public class MaximumPathSum {
	public static int maximuPathSum(TreeNode root){
>>>>>>> cd462dd042a79088893d58a5bbb18a885368ffde
		if(root == null){
			return 0;
		}
		
<<<<<<< HEAD
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
=======
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
>>>>>>> cd462dd042a79088893d58a5bbb18a885368ffde
	}
}

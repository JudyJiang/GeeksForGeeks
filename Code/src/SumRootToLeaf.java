import utility.*;

public class SumRootToLeaf {
	public static int sumNumbers(TreeNode root, int prevSum) {
		if (root == null)
			return 0; /*This part is also important! Otherwise for case (1,0) will return 11 instead of 10*/

		if (root.left == null && root.right == null) {
			return root.val + prevSum * 10;
		}
		
		prevSum = prevSum * 10 + root.val;
		return sumNumbers(root.left, prevSum)
				+ sumNumbers(root.right, prevSum);
	}

	public static int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;
		
		/*
		 * This part is important!
		 */
		if(root.left == null && root.right == null)
			return root.val;
		return sumNumbers(root.left, root.val)
				+ sumNumbers(root.right, root.val);
	}
	
	public static void main(String[] args){
		
	}
}

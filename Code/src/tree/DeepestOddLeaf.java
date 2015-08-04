package tree;

import utility.TreeNode;

public class DeepestOddLeaf {
	public static int depthOddLeaf(TreeNode root) {
		TreeNode dummy = new TreeNode(-1);
		int[] max = new int[1];
		max[0] = Integer.MIN_VALUE;
		int res = depthOddLeaf(root, 1, dummy, max);
		System.out.println(dummy.val);
		return res;
	}

	public static int depthOddLeaf(TreeNode root, int level, TreeNode dummy,
			int[] max) {
		if (root == null)
			return 0;

		if (root.left == null && root.right == null && level % 2 != 0) {
			//System.out.println(root.val + " " + level);
			if (level >= max[0]) {
				max[0] = level;
				dummy.val = root.val;
			}
			return level;
		}

		if (root.left == null && root.right == null && level % 2 == 0)
			return -1;

		int left = depthOddLeaf(root.left, level + 1, dummy, max);
		int right = depthOddLeaf(root.right, level + 1, dummy, max);

		return Math.max(left, right);
	}

	public static void main(String[] args) {
		TreeNode root = SampleTrees.root5;
		System.out.println(depthOddLeaf(root));
	}
}

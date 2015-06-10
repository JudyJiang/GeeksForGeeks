import utility.*;
import java.util.*;

public class RecoverBinarySearchTree {
	/*
	 * This solution use O(n) space and O(n) time...
	 * Trying to reduce space to constant space
	 */
	public static void recoverTree(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return;
		List<TreeNode> list = BSTToArray.bstToInOrderArray(root);
		TreeNode first = null, second = null;
		int size = list.size();
		for (int i = 0; i < size; i++) {
			if (i == 0 && list.get(i).val > list.get(i + 1).val)
				first = list.get(i);
			else if (i == size - 1
					&& list.get(size - 1).val < list.get(size - 2).val)
				second = list.get(size - 1);
			else if ((i > 0 && i < size - 1)
					&& (list.get(i).val > list.get(i + 1).val || list.get(i).val < list
							.get(i - 1).val)) {
				if (first == null)
					first = list.get(i);
				else
					second = list.get(i);
			}
		}
		if (first != null && second != null) {
			int tmp = first.val;
			first.val = second.val;
			second.val = tmp;
		}
	}
	
	public static void recoverTreeConstantT(TreeNode root){
		
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(6);
		root.left.right.right = new TreeNode(7);
		root.right = new TreeNode(10);
		root.right.right = new TreeNode(14);
		root.right.right.left = new TreeNode(13);
		List<TreeNode> res = BSTToArray.bstToInOrderArray(root);
		for (TreeNode node : res)
			System.out.print(node.val + " ");
		System.out.println();
		recoverTree(root);
		res = BSTToArray.bstToInOrderArray(root);
		for (TreeNode node : res) {
			System.out.print(node.val + " ");
		}
	}
}

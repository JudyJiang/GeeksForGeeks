import java.util.*;

import utility.*;


public class BinaryTreeInorderTraversal {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(3);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(6);
		root.left.right.left = new TreeNode(4);
		root.left.right.right = new TreeNode(7);
		root.right.right = new TreeNode(14);
		root.right.right.left = new TreeNode(13);

		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode p = root.left;
		s.push(root);
		while (!s.isEmpty()) {
			while (p != null) {
				s.push(p);
				p = p.left;
			}
			p = s.pop();
			System.out.println(p.val);
			if (p.right != null) {
				s.push(p.right);
				p = p.right.left;
			}
			else
				p = null;
		}
	}
}

package tree;

/**
 * given two nodes of a binary tree, find number of nodes on the path between
 * the two nodes. 1 2 3 4 5
 * 
 * 4, 3 -> (4-2-1-3): 4
 * 
 * @author FengjiaoJiang would be easier with parent node installed?
 * First find the lowest common ancestor of the two nodes, say 'p' and 'q'
 * Then find the path from root to p and root to q separately.
 * Add the two distances.
 */

import java.util.List;
import java.util.ArrayList;

public class FindTreePath {
	public static int NodeToNodePath(BinaryTree<?> root,
			BinaryTree<Integer> node) {
		return NodeToNodePath(root, node, 0) - 1;
	}

	public static int NodeToNodePath(BinaryTree root, BinaryTree node,
			int length) {
		if (root == null)
			return 0;

		if (root.rootElement == node.rootElement) {
			length += 1;
			return length;
		}

		int left = NodeToNodePath(root.left, node, length);
		if (left != 0) {
			return left + 1;
		}

		int right = NodeToNodePath(root.right, node, length);
		if (right != 0) {
			return right + 1;
		}

		return 0;
	}

	public static List<BinaryTree> FindRootToNode(BinaryTree root,
			BinaryTree node) {
		if (root == null)
			return null;

		if (root.rootElement == node.rootElement) {
			List<BinaryTree> list = new ArrayList<BinaryTree>();
			list.add(root);
			return list;
		}

		List<BinaryTree> left = FindRootToNode(root.left, node);

		if (left != null) {
			left.add(0, root);
			return left;
		}
		List<BinaryTree> right = FindRootToNode(root.right, node);

		if (right != null) {
			right.add(0, root);
			return right;
		}

		return null;
	}

	public static void main(String[] args) {
		BinaryTree<?> root = TreeUtility.GetSampleTree();
		BinaryTree<Integer> p = new BinaryTree<Integer>(9);
		BinaryTree<Integer> q = new BinaryTree<Integer>(3);

		BinaryTree<Integer> ancestor = LowestCommonAncestor
				.FindLowestCommonAncestor(root, p, q);
		
		int left = NodeToNodePath(ancestor, p);
		int right = NodeToNodePath(ancestor, q);
		
		System.out.println(left + right);
	}
}

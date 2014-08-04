package Tree;

public class LowestCommonAncestor {

	public static boolean FindLocation(BinaryTree root, BinaryTree node) {
		if (root == null && node == null)
			return true;

		else if (root == null || node == null)
			return false;

		else if (root.rootElement == node.rootElement)
			return true;

		return FindLocation(root.left, node) || FindLocation(root.right, node);
	}

	public static BinaryTree FindLowestCommonAncestor(BinaryTree root, BinaryTree p,
			BinaryTree q) {
		if (root == null)
			return null;

		if (p == null)
			return q;

		if (q == null)
			return p;

		if (root.rootElement == p.rootElement
				|| root.rootElement == q.rootElement)
			return root;

		boolean pOnLeft = FindLocation(root.left, p);
		boolean qOnLeft = FindLocation(root.left, q);

		if (pOnLeft != qOnLeft)
			return root;

		BinaryTree subTree = pOnLeft ? root.left : root.right;

		return FindLowestCommonAncestor(subTree, p, q);
	}

	public static void main(String[] args) {
		BinaryTree root = TreeUtility.GetSampleTree();
		BinaryTree p = new BinaryTree(2);
		BinaryTree q = new BinaryTree(3);
		System.out.println(FindLowestCommonAncestor(root, p, q).rootElement);
	}
}

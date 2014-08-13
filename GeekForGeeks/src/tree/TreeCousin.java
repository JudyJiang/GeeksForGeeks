package tree;

/**
 * Two nodes are cousin within a binary tree if:
 * 1. They're on the same level;
 * 2. They have different parents.
 * @author FengjiaoJiang
 *
 */

import java.util.LinkedList;

public class TreeCousin {
	public static class AncestorWithDepth {
		BinaryTree ancestor;
		int depth;

		public AncestorWithDepth(){
			super();
		}

		public AncestorWithDepth(BinaryTree ancestor, int newDepth){
			this();
			this.ancestor = ancestor;
			this.depth = newDepth;
		}
	}

	public static boolean IsCousin(BinaryTree root, BinaryTree p, BinaryTree q) {
		AncestorWithDepth ansp = new AncestorWithDepth();
		AncestorWithDepth ansq = new AncestorWithDepth();

		ansp = IsCousin(root, p, root, 0);
		ansq = IsCousin(root, q, root, 0);
		
		

		if(ansp == null || ansq == null){
			System.out.println("Why Null!");
			return false;
		}
		
		System.out.println(ansp.depth + " " + ansq.depth);

		if(ansp.ancestor != ansp.ancestor && ansp.depth == ansq.depth)
			return true;

		return false;
	}
	

	public static AncestorWithDepth IsCousin(BinaryTree root, BinaryTree node, BinaryTree ancestor, int depth){
		if(root == null){
			return null;
		}
		
		if(root.rootElement == node.rootElement){
			return new AncestorWithDepth(ancestor, depth);
		}
		
		AncestorWithDepth left = IsCousin(root.left, node, root, depth + 1);
		if(left != null)
			return left;
		
		AncestorWithDepth right = IsCousin(root.right, node, root, depth + 1);
		if(right != null)
			return right;
		
		return null;
	}







	/*
	 * return Integer number: 0, no match; 1, find one; 2, sameParent;
	 */
	public static int isSameParent(BinaryTree root, BinaryTree p, BinaryTree q) {
		
		if (root.left == null && root.right == null) {
			return 0;
		}
		
		else if(root.left == null || root.right == null){
			BinaryTree tempNode = root.left == null ? root.right : root.left;
			if(tempNode.rootElement == p.rootElement || tempNode.rootElement == q.rootElement)
				return 1;
		}
		
		else if ((root.left.rootElement == p.rootElement && root.right.rootElement == q.rootElement)
				|| (root.left.rootElement == q.rootElement && root.right.rootElement == p.rootElement)) {
			return 2;
		}

		else if (root.left.rootElement == p.rootElement
				|| root.right.rootElement == p.rootElement
				|| root.left.rootElement == q.rootElement
				|| root.right.rootElement == q.rootElement) {
			return 1;
		}

		return 0;
	}

	public static boolean IsCousinNonRecursion(BinaryTree root, BinaryTree p,
			BinaryTree q) {
		if (root == null) {
			return false;
		}

		else if (p == null || q == null) {
			return true;
		}

		LinkedList<BinaryTree> queue = new LinkedList<BinaryTree>();
		queue.add(root);
		queue.add(null);

		boolean finishOneLevel = false, findOne = false, isSameParent = false;

		while (true) {
			BinaryTree top = queue.peek();

			if (top == null) {
				finishOneLevel = true;
				findOne = false;
				queue.poll();
				if (queue.isEmpty()) {
					break;
				}
				queue.add(null);
			}

			else {
				int res = isSameParent(top, p, q);
				if (res == 2) {
					return false;
				}

				if (res == 1 && findOne) {
					return true;
				}

				findOne = res == 0 ? false : true;
				if(top.left != null)
					queue.add(top.left);
				if(top.right != null)
					queue.add(top.right);
				queue.poll();
			}
		}
		return false;
	}


/**
* Or check during the pop procedure, still level order. 
* If the top one equals p or q's rootElement, then search the nodes within the same level if find one then return false. 
* fi not go ot the next iteration.
* Still use the boolean value "FindOne";
* Still need to add "Null" when each level ends.
*/

	public static void main(String[] args) {
		BinaryTree root = TreeUtility.GetSampleTree();
		IsCousin(root, root.left, root.right);
//		System.out.println(IsCousinNonRecursion(root, root.left, root.right));
//		System.out.println(IsCousinNonRecursion(root, root.left.right.right, root.right.right.left));
//		System.out.println(IsCousinNonRecursion(root, root.left.left, root.right.right));
	}
}

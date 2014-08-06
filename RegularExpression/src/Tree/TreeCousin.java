package Tree;

/**
 * Two nodes are cousin within a binary tree if:
 * 1. They're on the same level;
 * 2. They have different parents.
 * @author FengjiaoJiang
 *
 */

import java.util.LinkedList;

public class TreeCousin {
	public static class AncestorWithDepth{
		BinaryTree ancestor;
		int depth;
	}
	
	public static boolean IsCousin(BinaryTree root, BinaryTree p, BinaryTree q){
		return true;
	}
	
	public static AncestorWithDepth isCounsin(BinaryTree root, BinaryTree node){
		return null;
	}


/*
* return Integer number: 0, no match; 1, find one; 2, sameParent;
*/
	public static int isSameParent(BinaryTree root, BinaryTree p, BinaryTree q){
		if(root.left == null && root.right == null){
			return 0;
		}

		else if((root.left.rootElement == p.rootElement && root.right.rootElement == q.rootElement) || 
			(root.left.rootElement == q.rootElement && root.right.rootElement == p.rootElement)){
			return 2;
		}

		else if(root.left.rootElement == p.rootElement || root.right.rootElement == p.rootElement ||
			root.left.rootElement == q.rootElement || root.right.rootElement == q.rootElement){
			return 1;
		}

		else {
			return 0;
		}
	}


	public static boolean IsCousinNonRecursion(BinaryTree root, BinaryTree p, BinaryTree q){
		if(root == null){
			return false;
		}

		else if(p == null || q == null){
			return true;
		}


		LinkedList<BinaryTree> queue = new LinkedList<BinaryTree>();
		queue.add(root);

		boolean finishOneLevel = false, findOne = false, isSameParent = false;

		while(true){
			BinaryTree top = queue.peek();

			if(top == null){
				finishOneLevel = true;
				queue.poll();
				if(queue.isEmpty()){
					break;
				}
			}

			else{
				int res = isSameParent(top, p, q);
				if(res == 2){
					return false;
				}

				if(res == 1 && findOne){
					return true;
				}

				findOne = res == 0 ? false : true;
				queue.add(top.left);
				queue.add(top.right);
				queue.poll();
			}
		}
		return false;
	}

	public static void main(String[] args){
		/*
		* TODO: Test the function
		*/
	}
}

//import utility.*;
//import java.util.*;
//
//public class RecoverBinarySearchTree {
//	/*
//	 * This solution use O(n) space and O(n) time...
//	 * Trying to reduce space to constant space
//	 */
//	public static void recoverTree(TreeNode root) {
//		if (root == null || (root.left == null && root.right == null))
//			return;
//		List<TreeNode> list = BSTToArray.bstToInOrderArray(root);
//		TreeNode first = null, second = null;
//		int size = list.size();
//		for (int i = 0; i < size; i++) {
//			if (i == 0 && list.get(i).val > list.get(i + 1).val)
//				first = list.get(i);
//			else if (i == size - 1
//					&& list.get(size - 1).val < list.get(size - 2).val)
//				second = list.get(size - 1);
//			else if ((i > 0 && i < size - 1)
//					&& (list.get(i).val > list.get(i + 1).val || list.get(i).val < list
//							.get(i - 1).val)) {
//				if (first == null)
//					first = list.get(i);
//				else
//					second = list.get(i);
//			}
//		}
//		if (first != null && second != null) {
//			int tmp = first.val;
//			first.val = second.val;
//			second.val = tmp;
//		}
//	}
//	
//	public static void recoverTreeConstantT(TreeNode root){
//		if(root == null || (root.left == null && root.right == null))
//			return ;
//		TreeNode[] tmp = new TreeNode[3];
//		//tmp[0], tmp[1] for the two swapt nodes, tmp[2] is always the 
//		//current node going down left branch and right branch for comparison. 
//		tmp = recoverTreeConstantT(root, tmp);
//		if(tmp[0] != null && tmp[1] != null){
//			int t = tmp[0].val;
//			tmp[0].val = tmp[1].val;
//			tmp[1].val = t;
//		}
//	}
//	
//	public static TreeNode[] recoverTreeConstantT(TreeNode root, TreeNode[] tmp){
//		if(root == null)
//			return tmp;
//		
//		tmp = recoverTreeConstantT(root.left, tmp);
//		if(tmp[2] != null && tmp[2].val > root.val){ // this is returns from the left and tmp[2] should always
//			//be smaller than the current!
//			if(tmp[0] == null)
//				tmp[0] = tmp[2];
//			tmp[1] = root; // this is a nice step
//			//cause tmp[2] is always changing records the current comparison node
//			//tmp[1] is the current node being compared. 
//		}
//		tmp[2] = root;
//		tmp = recoverTreeConstantT(root.right, tmp);
//		return tmp;
//	}
//
//	public static void main(String[] args) {
//		TreeNode root = new TreeNode(8);
//		root.left = new TreeNode(3);
//		root.left.left = new TreeNode(1);
//		root.left.right = new TreeNode(4);
//		root.left.right.left = new TreeNode(6);
//		root.left.right.right = new TreeNode(7);
//		root.right = new TreeNode(10);
//		root.right.right = new TreeNode(14);
//		root.right.right.left = new TreeNode(13);
//		List<TreeNode> res = BSTToArray.bstToInOrderArray(root);
//		for (TreeNode node : res)
//			System.out.print(node.val + " ");
//		System.out.println();
//		recoverTreeConstantT(root);
//		res = BSTToArray.bstToInOrderArray(root);
//		for (TreeNode node : res) {
//			System.out.print(node.val + " ");
//		}
//	}
//}

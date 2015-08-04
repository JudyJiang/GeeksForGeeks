package tree;

import utility.TreeNode;

public class NodeCousin {
	public static boolean isCousin(TreeNode root, TreeNode a, TreeNode b){
		return isCousin(root, a, b, 0) != -1;
	}
	
	public static int isCousin(TreeNode root, TreeNode a , TreeNode b, int level){
		if(root == null)
			return 0;
		if(root.left != null && root.right != null){
			if(root.left == a && root.right == b ||
					root.left == a && root.right == a){
				return -1;
			}
		}
		
		if(root.left != null && (root.left == a || root.left == b)){
			return level + 1;
		}
		
		int findL = isCousin(root.left, a, b, level + 1);
		if(findL == -1)
			return -1;
		
		int findR = isCousin(root.right, a, b, level + 1);
		if(findL != findR)
			return -1;
		else
			return findR;
	}
	
	public static void main(String[] args){
		TreeNode root = SampleTrees.root4;
		System.out.println(isCousin(root, root.left.left, root.right.left));
	}
}

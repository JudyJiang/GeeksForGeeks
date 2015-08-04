package tree;


import utility.TreeNode;

public class NodeLevel {
	public static int getNodeLevel(TreeNode root, TreeNode node){
		if(root == null)
			return 0;
		
		return getNodeLevel(root, node, 1);
	}
	
	public static int getNodeLevel(TreeNode root, TreeNode node, int level){
		if(root == null){
			return 0;
		}
		
		if(root.val == node.val){
			return level;
		}
		
		int res = getNodeLevel(root.left, node, level + 1);
		if(res != 0)
			return res;
		
		return getNodeLevel(root.right, node, level + 1);
	}
}

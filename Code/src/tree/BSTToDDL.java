package tree;


import utility.*;

public class BSTToDDL {
	public static TreeNode convertDDL(TreeNode root){
		TreeNode[] augs = new TreeNode[2];
		convertDDL(root, augs);
		//augs[0] is head, augs[1] is tail
		return augs[0];
	}
	
	public static void convertDDL(TreeNode root, TreeNode[] augs){
		if(root == null)
			return ;
		
		if(root.left != null)
			convertDDL(root.left, augs);
		
		root.left = augs[1];
		if(augs[1] != null){
			augs[1].right = root;
		}
		else{
			augs[0] = root;
		}
		
		augs[1] = root;
		
		if(root.right != null)
			convertDDL(root.right, augs);
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(-13);
		root.right = new TreeNode(14);
		root.left.right = new TreeNode(-8);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(15);
		TreeNode res = convertDDL(root);
		System.out.print(res.val);
	}
}

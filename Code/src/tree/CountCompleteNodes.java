package tree;

import utility.*;

public class CountCompleteNodes {
	public static int getHeight(TreeNode root, boolean left){
		if(root == null)
			return 0;
		
		int height = 0;
		TreeNode p = root;
		while(p != null){
			height++;
			p = left? p.left : p.right;
		}
		return height;
	}
	
	public static int countCompleteNodes(TreeNode root){
		if(root == null)
			return 0;
		
		int left = getHeight(root, true);
		int right = getHeight(root, false);
		if(left == right){
			return (int) ((Math.pow(2, left) - 2)*2);
		}
		
		else{
			return countCompleteNodes(root.left) + countCompleteNodes(root.right)+1;
		}
	}
	
	public static void main(String[] args){
		
	}
}

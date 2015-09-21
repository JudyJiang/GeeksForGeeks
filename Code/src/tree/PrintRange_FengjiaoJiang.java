package tree;

import utility.TreeNode;

public class PrintRange_FengjiaoJiang {
	public static void printRange(TreeNode root, int start, int end){
		if(root == null)
			return;
		
		if(root.val < start){
			printRange(root.right, start, end);
		}
		
		else if(root.val > end){
			printRange(root.left, start, end);
		}
		
		else if(root.val <= end && root.val >= start){
			System.out.println(root.val);
			printRange(root.left, start, end);
			printRange(root.right, start, end);
		}
	}
	
	public static void main(String[] args){
		TreeNode root = SampleTrees.root7;
		printRange(root, 10, 22);
	}
}

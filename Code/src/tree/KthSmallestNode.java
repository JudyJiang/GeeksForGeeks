package tree;


import java.util.*;

import utility.*;

public class KthSmallestNode {
	public static int kthSmallestNode(TreeNode root, int k){
		if(root == null || k <= 0)
			return -1;
		
		int count = 0;
		TreeNode prev = null, curr = root;
		while(curr != null){
			if(curr.left == null){
				count += 1;
				if(count == k){
					return curr.val;
				}
				curr = curr.right;
			}
			else{
				prev = curr.left;
				while(prev.right != null && prev.right != curr){
					prev = prev.right;
				}
				
				if(prev.right == null){
					prev.right = curr;
					curr = curr.left;
				}
				
				else{//prev.right == curr, this is done previously to thread the binary tree up
					prev.right = null;
					count += 1;
					if(count == k)
						return curr.val;
					curr = curr.right;
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(8);
		root.right = new TreeNode(22);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(12);
		root.left.right.left = new TreeNode(10);
		root.left.right.right = new TreeNode(14);
		int res = kthSmallestNode(root, 5);
		System.out.println(res);
	}
}

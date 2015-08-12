package tree;

import java.util.*;
import utility.TreeNode;

public class KDistanceFromNode {
	public static void goDownK(TreeNode root, int k){
		if(root == null || k < 0)
			return ;
		if(k == 0){
			System.out.println(root.val);
			return;
		}
		
		goDownK(root.left, k - 1);
		goDownK(root.right, k - 1);
	}
	public static int kDistanceFromNode(TreeNode root, TreeNode node, int k){
		if(root == null){
			return -1; // not found
		}
		
		if(root == node){
			//go down from there
			return 0;
		}
		
		//get current node level
		int left = kDistanceFromNode(root.left, node, k);
		if(left != -1){
			//find node on left subtree
			if(left + 1 == k)
				System.out.println(root.val);
			else
				kDistanceFromNode(root.right, node, k - left - 2);
			return left + 1;
		}
		
		int right = kDistanceFromNode(root.right, node, k);
		if(right != - 1){
			if(right + 1 == k)
				System.out.println(root.val);
			else
				kDistanceFromNode(root.left, node, k - right - 2);
			return right + 1;
		}
		
		return -1;
	}
}

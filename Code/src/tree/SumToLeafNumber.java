package tree;

import utility.TreeNode;
import java.util.*;

public class SumToLeafNumber {
	public static List<Integer> sumRootToLeaf(TreeNode root){
		List<Integer> res = new LinkedList<Integer>();
		if(root == null)
			return res;
		
		sumRootToLeaf(root, res, 0);
		return res;
	}
	
	public static void sumRootToLeaf(TreeNode root, List<Integer> res, int prev){
		if(root == null){
			res.add(prev);
			return ;
		}
		
		
		int curr = prev * 10 + root.val;
		if(root.left == null && root.right == null){
			res.add(curr);
			return ;
		}
		if(root.left != null)
			sumRootToLeaf(root.left, res, curr);
		if(root.right != null)
			sumRootToLeaf(root.right, res, curr);
	}
	
	public static void main(String[] argrs){
		TreeNode root = SampleTrees.root1;
		List<Integer> res = sumRootToLeaf(root);
		System.out.println(res.size());
		for(Integer i : res)
			System.out.println(i);
	}
}

package tree;


import utility.*;
import java.util.*;

public class AllPossibleTrees {
	public static List<TreeNode> allBST(int N){
		List<TreeNode> res = new LinkedList<TreeNode>();
		if(N == 0)
			return res;
		
		res = allBST(1, N);
		return res;
	}
	
	public static List<TreeNode> allBST(int left, int right){
		List<TreeNode> list = new LinkedList<TreeNode>();
		if(left > right){
			list.add(null);
			return list;
		}
		
		for(int i = left; i <= right; i++){
			List<TreeNode> leftSub = allBST(left, i - 1);
			List<TreeNode> rightSub = allBST(i + 1, right);
			TreeNode root = new TreeNode(i);
			for(TreeNode l : leftSub){
				root.left = l;
				for(TreeNode r : rightSub){
					root.right = r;
					list.add(root);
				}
			}
		}
		return list;
	}
	
	public static void main(String[] args){
		List<TreeNode> roots = allBST(3);
		System.out.println(roots.size());
		for(TreeNode root : roots)
			System.out.println(root.val);
	}
}

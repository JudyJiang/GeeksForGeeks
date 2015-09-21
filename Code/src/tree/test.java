package tree;

import utility.*;
import java.util.*;
public class test {
	public static List<List<Integer>> allPaths(TreeNode root){
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		if(root == null){
			return res;
		}

		List<Integer> list = new LinkedList<Integer>();
		allPaths(root, res, list);
		return res;
	}


	public static void allPaths(TreeNode root, List<List<Integer>> res, List<Integer> list){
		if(root == null){
			List<Integer> copy = new LinkedList<Integer>(list);
			res.add(copy);
			return ;
		}


		list.add(root.val);
		allPaths(root.left, res, list);
		if(root.right != null)
			allPaths(root.right, res, list);
		list.remove(list.size() - 1);
	}
	
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(8);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(2);
		List<List<Integer>> res = allPaths(root);
		System.out.println(res.size());
		for(List<Integer> list : res){
			for(Integer i : list)
				System.out.print(i + " ");
			System.out.println();
		}
	}
}

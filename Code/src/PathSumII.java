import utility.*;
import java.util.*;

public class PathSumII {
	public static List<List<Integer>> pathSum(TreeNode root, int sum){
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		if(root == null)
			return res;
		List<Integer> list = new LinkedList<Integer>();
		pathSum(root, res, list, sum, 0);
		return res;
	}
	
	public static void pathSum(TreeNode root, List<List<Integer>> res, List<Integer> list, int sum, int tmpSum){
		if(root == null)
			return;
		
		if((root.left == null && root.right == null) && (tmpSum + root.val == sum)){
			System.out.println("yes");
			list.add(root.val);
			List<Integer> copy = new LinkedList<Integer>();
			copy.addAll(list);
			res.add(copy);
			list.remove(list.size() - 1);
			return ;
		}
		
		list.add(root.val);
		pathSum(root.left, res, list, sum, tmpSum + root.val);
		pathSum(root.right, res, list, sum, tmpSum + root.val);
		list.remove(list.size() - 1);
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		List<List<Integer>> res = pathSum(root, 1);
		System.out.println(res.size());
//		TreeNode root = new TreeNode(5);
//		root.left = new TreeNode(4);
//		root.right = new TreeNode(8);
//		root.left.left = new TreeNode(11);
//		root.left.left.left = new TreeNode(7);
//		root.left.left.right = new TreeNode(2);
//		root.right.left = new TreeNode(13);
//		root.right.right = new TreeNode(4);
//		root.right.right.left = new TreeNode(5);
//		root.right.right.right = new TreeNode(1);
//		List<List<Integer>> res = pathSum(root, 22);
//		System.out.println(res.size());
//		for(List<Integer> list : res){
//			for(Integer e : list)
//				System.out.print(e + " ");
//			System.out.println();
//		}
	}
}

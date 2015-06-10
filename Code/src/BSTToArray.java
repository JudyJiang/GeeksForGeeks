import java.util.*;
import utility.*;


public class BSTToArray {
	public static List<TreeNode> bstToInOrderArray(TreeNode root){
		List<TreeNode> res = new LinkedList<TreeNode>();
		if(root == null)
			return res;
		bstToInOrderArray(root, res);
		return res;
	}
	
	public static void bstToInOrderArray(TreeNode root, List<TreeNode> list){
		if(root == null)
			return ;
		
		bstToInOrderArray(root.left, list);
		list.add(root);
		bstToInOrderArray(root.right, list);
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right = new TreeNode(5);
		List<TreeNode> res = bstToInOrderArray(root);
		for(TreeNode i : res){
			System.out.print(i.val + " ");
		}
	}
}

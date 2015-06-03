import utility.*;
import java.util.*;

/*
 * Pay attention to situation as:
 *      1
 *    2   3
 *      4
 * Nicely done
 */
public class BinaryTreeRightView {
	public static List<Integer> rightSideView(TreeNode root){
		List<Integer> res = new LinkedList<Integer>();
		if(root == null)
			return res;
		
		int prev;
		LinkedList<TreeNode> tmp = new LinkedList<TreeNode>();
		tmp.add(root);
		tmp.add(null);
		prev = root.val;
		while(true){
			TreeNode node = tmp.removeFirst();
			if(node == null){
				if(tmp.isEmpty()){
					break;
				}
				res.add(prev);
				tmp.add(null);
			}
			else{
				prev = node.val;
				if(node.left != null)
					tmp.add(node.left);
				if(node.right != null)
					tmp.add(node.right);
			}
		}
		res.add(prev);
		return res;
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
//		root.left = new TreeNode(2);
//		root.left.right = new TreeNode(5);
//		root.right = new TreeNode(3);
//		root.right.right = new TreeNode(4);
		List<Integer> res = rightSideView(root);
		System.out.println(res.size());
		for(Integer r : res){
			System.out.print(r + " ");
		}
	}
}

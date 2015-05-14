import java.util.*;
import utility.*;

public class TreePreOrder {
	public static List<Integer> inorderTraversal(TreeNode root){
		List<Integer> res = new LinkedList<Integer>();
		if(root == null){
			return res;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(root);
		res.add(root.val);
		boolean done = false;
		
		while(!stack.isEmpty()){
			TreeNode top = stack.peek();
			if(top != null){
				if(done){
					stack.pop();
					stack.add(top.right);
					if(top.right!=null)
						res.add(top.right.val);
					done = false;
				}
				else{
					stack.add(top.left);
					if(top.left!=null)
						res.add(top.left.val);
				}
			}
			else{
				stack.pop();
				done = true;
			}
		}
		return res;
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		List<Integer> res = inorderTraversal(root);
		System.out.println(res.size()+" "+res.toString());
	}
}

import java.util.*;
import utility.*;

public class BinaryTreePostorderTraverse {
	public static List<Integer> postorderTraversal(TreeNode root){
		List<Integer> list = new LinkedList<Integer>();
		if(root == null)
			return list;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode prev = null, curr = null;
		stack.push(root);
		while(!stack.isEmpty()){
			curr = stack.peek();
			if(prev == null || curr == prev.left || curr == prev.right){
				if(curr.left != null){
					stack.push(curr.left);
				}
				else if(curr.right != null){
					stack.push(curr.right);
				}
				else{
					list.add(curr.val);
					stack.pop();
				}
			}
			
			else if(prev == curr.left){
				if(curr.right != null){
					stack.push(curr.right);
				}
				else{
					stack.pop();
					list.add(curr.val);
				}
			}
			
			else if(prev == curr.right){
				stack.pop();
				list.add(curr.val);
				//prev = curr;
			}
			prev = curr;
		}
		
		return list;
	}
}

import java.util.*;
import utility.*;

/*
 * Attention, it's actully a traverse of BST using pre-order, smallest - largest....
 */
public class BSTIterator {
	Stack<TreeNode> stack;
	public BSTIterator(TreeNode root){
		stack = new Stack<TreeNode>();
		while(root != null){
			stack.push(root);
			root = root.left;
		}
	}
	
	public boolean hasNext(){
		return !stack.isEmpty();
	}
	
	public int next(){
		TreeNode node = stack.pop();
		int res = node.val;
		
		if(node.right != null){
			node = node.right;
			while(node != null){
				stack.push(node);
				node = node.left;
			}
		}
		return res;
	}
}

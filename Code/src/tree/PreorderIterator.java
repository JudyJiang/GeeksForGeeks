package tree;
import java.util.*;
import utility.*;


public class PreorderIterator {
	private Stack<TreeNode> s;
	
	public PreorderIterator(TreeNode root){
		TreeNode p = root;
		s = new Stack<TreeNode>();
		s.push(p);
	}
	
	public boolean hasNext(){
		return !s.isEmpty();
	}
	
	public TreeNode next(){
		TreeNode top = s.pop();
		if(top.right != null)
			s.push(top.right);
		if(top.left != null)
			s.push(top.left);
		return top;
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);
		PreorderIterator it = new PreorderIterator(root);
		while(it.hasNext())
			System.out.print(it.next().val + " ");
	}
}

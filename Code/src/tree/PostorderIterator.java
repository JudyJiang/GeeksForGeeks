package tree;

import java.util.*;
import utility.*;

public class PostorderIterator {
	private Stack<TreeNode> s;
	
	public PostorderIterator(TreeNode root){
		s = new Stack<TreeNode>();
		TreeNode p = root;
		while(p != null){
			s.push(p);
			p = p.left;
		}
	}
	
	public boolean hasNext(){
		return !s.isEmpty();
	}
	
	public TreeNode next(){
		TreeNode pop = s.pop();
		if(!s.isEmpty()){
			TreeNode top = s.peek();
			if(pop == top.left){
				TreeNode p = top.right;
				while(p != null){
					s.push(p);
					p = p.left;
				}
			}
//			
//			else if(top == top.right){
//				
//			}
		}
		return pop;
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);
		PostorderIterator it = new PostorderIterator(root);
		while(it.hasNext()){
			System.out.print(it.next().val + " ");
		}
	}
}

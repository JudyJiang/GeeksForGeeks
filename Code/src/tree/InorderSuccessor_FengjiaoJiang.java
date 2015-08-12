package tree;

import utility.TreeNode;
import java.util.*;

public class InorderSuccessor_FengjiaoJiang {
	public static class pNode{
		pNode parent;
		pNode left;
		pNode right;
		int val;
		
		public pNode(){
			this.parent = this.left = this.right = null;
		}
		
		public pNode(int v){
			this();
			this.val = v;
		}
	}
	
	public static pNode findRightMost(pNode root, boolean left){
		if(root == null)
			return null;
		pNode p = root;
		if(left){
			while(p.left != null){
				p = p.left;
			}
		}
		
		else{
			while(p.right != null)
				p = p.right;
		}
		return p;
	}
	
	public static pNode inorderSuccessor(pNode root, pNode node){
		if(root == null){
			return null;
		}
		
		if(root.val == node.val){
			if(root.right == null){
				if(root.parent == null)
					return null;
				else{
					if(root.parent.left == root)
						return root.parent;
					else{
						pNode p = root.parent, q = root;
						
						while(p != null && p.right == q){
							q = p;
							p = p.parent;
						}
						if(p == null)
							return null;
						return p;
					}
				}
			}
			else{
				return findRightMost(root.right, true);
			}
		}
		
		else if(root.val > node.val){
			return inorderSuccessor(root.left, node);
		}
		
		else
			return inorderSuccessor(root.right, node);
	}
	
	
	public static TreeNode findRightMost(TreeNode root){
		if(root == null)
			return root;
		TreeNode p = root;
		while(p.left != null){
			p = p.left;
		}
		return p;
	}
	
	public static TreeNode successor(TreeNode root, TreeNode node){
		if(root == null){
			return null;
		}
		
		TreeNode p = root;
		Stack<TreeNode> s = new Stack<TreeNode>();
		while(p != null){
			if(p.val == node.val){
				if(p.right == null)
					return null;
				return findRightMost(p.right);
			}
			
			else if(p.val > node.val){
				//go left, stack store value 
				if(p.left == null)
					return null;
				
				if(p.left == node){
					if(p.left.right == null)
						return p;
					else{
						return findRightMost(p.left.right);
					}
				}
				else{
					s.push(p);
					p = p.left;
				}
			}
			
			else if(p.val < node.val){
				if(p.right == null)
					return null;
				if(p.right == node){
					TreeNode curr = findRightMost(p.right.right);
					if(curr != null)
						return curr;
					else{
						if(s.isEmpty())
							return null;
						TreeNode top = s.pop();
						return top;
//						if(top.right == null)
//							return top;
//						else
//							return findRightMost(top.right);
					}
				}
				else
					p = p.right;
			}
		}
		return null;
	}
	
	
	public static void main(String[] args){
//		pNode root = new pNode(20);
//		root.left = new pNode(8);
//		root.left.parent = root;
//		root.right = new pNode(22);
//		root.right.parent = root;
//		
//		root.left.left = new pNode(4);
//		root.left.left.parent = root.left;
//		root.left.right = new pNode(12);
//		root.left.right.parent = root.left;
//		
//		root.left.right.left = new pNode(10);
//		root.left.right.left.parent = root.left.right.left;
//		root.left.right.right = new pNode(14);
//		root.left.right.right.parent = root.left.right;
//		
//		System.out.println(inorderSuccessor(root, root.right).val);
		TreeNode root = SampleTrees.root6;
		System.out.println(successor(root, root.left.right.right).val);
	}
}

package tree;

import utility.*;

public class TreeToList {
	static class Node{
		int val;
		Node prev;
		Node next;
		
		public Node(){
			this.prev = this.next = null;
		}
		
		public Node(int val){
			this();
			this.val = val;
		}
	}
	
	public static Node treeToList(TreeNode root){
		if(root == null)
			return null;
		
		Node left = treeToList(root.left);
		Node curr = new Node(root.val);
		curr.prev = left;
		if(left != null)
			left.next = curr;
		Node right = treeToList(root.right);
		curr.next = right;
		if(right != null)
			right.prev = curr;
		
		return right == null ? curr : right;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right = new TreeNode(5);
		Node res = treeToList(root);
		System.out.println(res.prev.prev.prev.prev.prev.val);
	}

}

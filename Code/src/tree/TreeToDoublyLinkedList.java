package tree;

import utility.*;

public class TreeToDoublyLinkedList {
	/*
	 * This is the naive way to construct a binary tree from doubly linked list
	 * Time O(nlogn)
	 */
	public static TreeNode DoubleListNodeToTree(DoubleListNode head){
		if(head == null)
			return null;
		
		if(head.next == null)
			return new TreeNode(head.val);
		DoubleListNode slow = head, fast = head;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		
		TreeNode root = new TreeNode(slow.val);
		if(slow.prev != null)
			slow.prev.next = null;
		slow.prev = null;
		root.left = DoubleListNodeToTree(head);
		root.right = DoubleListNodeToTree(slow.next);
		return root;
	}
	
	
	/*
	 * Bottom up solution. The dummy is very important. if use head only...
	 * will only be the first node..
	 */
	public static TreeNode DoubleListNodeToTreeII(DoubleListNode head){
		if(head == null)
			return null;
		int len = head.getLength();
		DoubleListNode dummy = new DoubleListNode();
		dummy.next = head;
		return DoubleListNodeToTreeII(dummy, 0, len - 1);
	}
	
	public static TreeNode DoubleListNodeToTreeII(DoubleListNode head, int start, int end){
		if(start > end)
			return null;
		
		int mid = start + (end - start) / 2;
		
		TreeNode left = DoubleListNodeToTreeII(head, start, mid - 1);
		TreeNode root = new TreeNode(head.next.val);
		head.next = head.next.next;
		TreeNode right = DoubleListNodeToTreeII(head, mid + 1, end);
		root.left = left;
		root.right = right;
		return root;
	}
	

	
	public static void main(String[] args){
		DoubleListNode head = new DoubleListNode(new int[]{1, 2, 3, 4, 5, 6});
//		TreeNode root = DoubleListNodeToTree(head);
//		System.out.println(root.right.left.val);
		TreeNode root = DoubleListNodeToTreeII(head);
		System.out.println(root.right.left.val);
	}
}

package tree;


import utility.TreeNode;

public class DDLToBST_FengjiaoJiang {
	static class DDL{
		DDL prev;
		DDL next;
		int val;
		
		public DDL(int v){
			this.val = v;
			this.prev = this.next = null;
		}
	}
	
	/*
	 * Be careful about the pointer... prev & next
	 */
	public static TreeNode ddlToTree(DDL head){
		if(head == null)
			return null;
		if(head.next == null)
			return new TreeNode(head.val);
		DDL slow = head, fast = head;
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		fast = slow.next;
		slow.next = null;
		TreeNode root = new TreeNode(slow.val);
		slow = slow.prev;
		if(slow == null)
			root.left = null;
		else{
			slow.next = null;
			root.left = ddlToTree(head);
		}
		if(fast == null)
			root.right = null;
		else{
			fast.prev = null;
			root.right= ddlToTree(fast);
		}
		return root;
	}
	
	
	public static TreeNode tricky(DDL head){
		DDL dummy = new DDL(-1);
		dummy.next = head;
		int len = getLen(head);
		return tricky(dummy, 0, len-1);
	}
	
	public static TreeNode tricky(DDL head, int start, int end){
		if(start > end)
			return null;
		
		int mid = start + (end - start) / 2;
		TreeNode left = tricky(head, start, mid - 1);
		TreeNode root = new TreeNode(head.next.val);
		head.next = head.next.next;
		TreeNode right = tricky(head, mid + 1, end);
		root.left = left;
		root.right = right;
		return root;
	}
	
	public static int getLen(DDL head){
		int count = 0;
		DDL p = head;
		while(p != null){
			p = p.next;
			count += 1;
		}
		return count;
	}
	
	
	public static void main(String[] args){
		DDL head = new DDL(1);
		head.prev = null;
		head.next = new DDL(2);
		head.next.prev = head;
		head.next.next = new DDL(3);
		head.next.next.prev = head.next;
		head.next.next.next = new DDL(4);
		head.next.next.next.prev = head.next.next;
		head.next.next.next.next = new DDL(5);
		head.next.next.next.next.prev = head.next.next.next;
//		
//		TreeNode root = ddlToTree(head);
		TreeNode root = tricky(head);
		System.out.println(root.val);
	}
}

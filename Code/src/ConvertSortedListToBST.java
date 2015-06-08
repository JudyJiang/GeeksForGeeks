import utility.*;


public class ConvertSortedListToBST {
	public static ListNode h;// this is necessary otherwise recursive call won't return 
	// correctly
	public static TreeNode sortedListToBST(ListNode head){
		if(head == null)
			return null;
		
		int len = getLen(head);
		h = head;
		return sortedListToBST(0, len - 1);
	}
	
	public static TreeNode sortedListToBST(int start, int end){
		if(start > end)
			return null;
		
		int mid = (start + end) / 2;
		TreeNode left = sortedListToBST(start, mid - 1);
		TreeNode root = new TreeNode(h.val);
		h = h.next;
		TreeNode right = sortedListToBST(mid + 1, end);
		root.left = left;
		root.right = right;
		return root;
	}
	
	public static int getLen(ListNode head){
		if(head == null)
			return 0;
		ListNode curr = head;
		int count = 0;
		while(curr != null){
			count += 1;
			curr = curr.next;
		}
		return count;
	}
	
	
	public static TreeNode sortedListToBSTII(ListNode head){
		if(head == null)
			return null;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		int len = getLen(head);
		return sortedListToBSTII(dummy, len);
	}
	
	public static TreeNode sortedListToBSTII(ListNode dummy, int len){
		if(dummy.next == null || len <= 0)
			return null;
		int mid = len / 2;
		TreeNode root = new TreeNode(0);
		root.left = sortedListToBSTII(dummy, mid);
		dummy.next = dummy.next.next;
		root.right = sortedListToBSTII(dummy, len - mid - 1);
		//This is the total length, minus the left side, minus the middle..
		return root;
	}
	
	public static void main(String[] args){
		
	}
}

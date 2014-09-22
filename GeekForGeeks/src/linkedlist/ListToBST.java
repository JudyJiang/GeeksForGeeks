package linkedlist;

/**
 * http://www.geeksforgeeks.org/sorted-linked-list-to-balanced-bst/
 * @author FengjiaoJiang
 * 
 * Pay attention to the second solution:
 * 1. Sometimes you don't need an array to 
 * hold the node value but a dummy node! It's pretty useful
 * 
 * 2. Also!! The first solution (mine) is root -> leaf;
 *    The second solution is bottom up! 
 */
import tree.BinaryTree;
import tree.TreeUtility;

public class ListToBST {
	public static BinaryTree ListToBSTUtil(ListNode list){
		if(list == null){
			return null;
		}
		
		return ListToBSTUtil(list, null);
	}
	
	public static BinaryTree ListToBSTUtil(ListNode start, ListNode end){
		if(start == end){
			return null;
		}
		if(start == null || start.next == end){
			BinaryTree root = new BinaryTree(start.value);
			return root;
		}
		
		ListNode slow = start, fast = start;
		
		while(fast.next != null && fast.next.next != null && fast.next != end && fast.next.next != end){
			slow = slow.next;
			fast = fast.next.next;
		}
		
		
		if(fast.next.next == end)
			slow = slow.next;
		fast = slow.next;
		
		BinaryTree root = new BinaryTree(slow.value);
		root.left = ListToBSTUtil(start, slow);
		root.right = ListToBSTUtil(fast, end);
		
		return root;
	}
	
	
	public static BinaryTree LeafToRoot(ListNode head){
		if(head == null)
			return null;
		
		int n = CountNodeNum(head);
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		return LeafToTree(dummy, n);
	}
	
	public static BinaryTree LeafToTree(ListNode dummy, int len){
		if(dummy.next == null || len <= 0){
			return null;
		}
		
		int mid = len / 2;
		BinaryTree root = new BinaryTree(0);
		root.left = LeafToTree(dummy, mid);
		root.rootElement = dummy.next.value;
		dummy.next = dummy.next.next;
		root.right = LeafToTree(dummy, len - mid - 1);
		return root;
	}
	
	
	
	public static int CountNodeNum(ListNode head){
		int count = 0;
		ListNode p = head;
		while(p != null){
			count++;
			p = p.next;
		}
		
		return count;
	}
	
	public static void main(String[] args){
		ListNode l1 = new ListNode();
		l1.GetSampleList(new Integer[]{1, 2, 3, 4, 5, 6});
		BinaryTree root = LeafToRoot(l1);
		
		TreeUtility.TraverseTreeLeverOrder(root);
	}
}

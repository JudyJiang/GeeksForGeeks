package linkedlist;

/**
 * http://www.geeksforgeeks.org/merge-sort-for-linked-list/
 * Needs practise on List's recursion
 * @author FengjiaoJiang
 *
 */

public class ListMergeSort {
	public static ListNode Sort(ListNode<Integer> head){
		if(head == null || head.next == null)
			return head;
		ListNode slow = head, fast = head;
		
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		fast = slow.next;
		slow.next = null;
		
		slow = Sort(head);
		fast = Sort(fast);
		
		return Merge(slow, fast);
	}
	
	public static ListNode Merge(ListNode<Integer> l1, ListNode<Integer> l2){
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		
		ListNode head = new ListNode(), p = head;
		while(l1 != null && l2 != null){
			if(l1.value <= l2.value){
				p.next = l1;
				l1 = l1.next;
			}
			else{
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
		}
		
		p.next = l1 == null ? l2 : l1;
		return head.next;
	}
	
	public static void main(String[] args){
		ListNode<Integer> head = new ListNode<Integer>();
		head.GetSampleList(new Integer[]{15, 10, 5, 20, 3, 2});
		head = Sort(head);
		head.PrintList();
	}
}

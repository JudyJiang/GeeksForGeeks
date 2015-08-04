package sorting;

import utility.*;

public class MergeSortLinkedList {
	public static ListNode mergeSort(ListNode head){
		if(head == null || head.next == null)
			return head;
		
		ListNode slow = head, fast = head;
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		
		fast = slow.next;
		slow.next = null;
		
		slow = mergeSort(head);
		fast = mergeSort(fast);
		return merge(slow, fast);
	}
	
	public static ListNode merge(ListNode l1, ListNode l2){
		ListNode dummy = new ListNode();
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		ListNode p = dummy;
		while(l1 != null && l2 != null){
			if(l1.val < l2.val){
				p.next = l1.next;
				p = p.next;
				l1 = l1.next;
			}
			else if(l1.val > l2.val){
				p.next = l2.next;
				p = p.next;
				l2 = l2.next;
			}
			else{
				p.next = l1.next;
				p = p.next;
				l1 = l1.next;
				p.next = l2.next;
				p = p.next;
				l2 = l2.next;
			}
		}
		if(l1 != null)
			p.next = l1;
		if(l2 != null)
			p.next = l2;
		return dummy.next;
	}
}

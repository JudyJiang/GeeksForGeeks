package linkedlist;


/**
 * http://www.geeksforgeeks.org/rotate-a-linked-list/
 * Although figured out how to do this, but spent some time, so notice the staff of different nodes exchange.
 * Or maybe this morning you're so disturbed
 * 09/22/2014
 * @author FengjiaoJiang
 *
 */
public class RotateLinkedList {
	public static ListNode RotateList(ListNode head, int k){
		if(head == null || head.next == null || k <= 0){
			return head;
		}
		ListNode newHead = new ListNode(), p = head, previous = newHead, lastHead = null, comingHead = head;
		newHead.next = head;
		
		int count = 1;
		while(p != null){
			ListNode next = p.next;
			previous = p;
			
			if(count == k){
				previous.next = lastHead;
				lastHead = newHead.next;
				newHead.next = next;
				comingHead = next;
				count = 0;
			}
			
			count++;
			p = next;
		}
		/*
		 * Don't forget the last update!!!!
		 */
		
		previous.next = lastHead;
		newHead.next = comingHead;
		
		//newHead.next.PrintList();
		return newHead.next;
	}
	
	public static void main(String[] args){
		ListNode head = new ListNode();
		head.GetSampleList(new Integer[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100});
		int k = 3;
		
		ListNode res = RotateList(head, k);
		res.PrintList();
	}
}

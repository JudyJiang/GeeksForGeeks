package linkedlist;

/**
 * Split a circular into two lists;
 * Detailed description posted below;
 * http://www.geeksforgeeks.org/split-a-circular-linked-list-into-two-halves/
 * @author FengjiaoJiang
 */

public class SplitCircularList {
	public static void SplitCircularList(ListNode head, ListNode p, ListNode q){
		if(head == null || head.next == null)
			return ;
		ListNode slow = head, fast = head;
		
		while(fast.next != head && fast.next.next != head){
			slow = slow.next;
			fast = fast.next.next;
		}
		p = head;
		q = slow.next;
		slow.next = p;
		
		if(fast.next == head)
			fast.next = q;
		if(fast.next.next ==  head)
			fast.next.next = q;
		PrintCircular(p);
		PrintCircular(q);
	}
	
	public static void PrintCircular(ListNode head){
		if(head == null || head.next == null){
			System.out.println("It's a empty list or one node list");
			return ;
		}
		
		ListNode p = head;
		while(p.next != head){
			System.out.print(p.value + " ");
			p = p.next;
		}
		System.out.println(p.value);
	}
	
	
	public static void main(String[] args){
		ListNode head = new ListNode();
		head.GetSampleList(new Integer[]{1, 2, 3, 4});//, 5, 6, 7, 8});
		head.GetTail().next = head;
		ListNode p = new ListNode(), q = new ListNode();
		PrintCircular(head);
		SplitCircularList(head, p, q);
		
	}
}

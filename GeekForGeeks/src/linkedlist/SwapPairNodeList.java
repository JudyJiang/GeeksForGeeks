package linkedlist;

/**
 * I'm also very proud of this solution! You used to fail on this problem! Improve your LinkedList Skills!
 * http://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list/
 * 1->2->3->4 => 2->1->4->3
 * 1->2->3->4->5 => 2->1->4->3->5
 * Noted: Well, seems like a one time luck. So, make sure use more than one pointers here, like problems in this kind.
 * @author FengjiaoJiang
 *
 */
public class SwapPairNodeList {
	
	public static ListNode SwapPairNode(ListNode head){
		if(head == null || head.next == null)
			return head;
		
		ListNode newHead = new ListNode();
		newHead.next = head;
		
		ListNode previous = newHead, p = head, q, k;
		while(p != null && p.next != null){
			q = p.next;
			k = q.next;
			
			previous.next = q;
			q.next = p;
			p.next = k;
			previous = previous.next.next;
			p = previous.next;//This step is actually very important.
		}
		return newHead.next;
	}
	
	//head->1->2->3->4
	//head->1->2->3->4->5
	
	

	public static void main(String[] args){
		ListNode head = new ListNode();
		head.GetSampleList(new Integer[]{1, 2, 3, 4, 5, 6});
		head = SwapPairNode(head);
		head.PrintList();
	}
}

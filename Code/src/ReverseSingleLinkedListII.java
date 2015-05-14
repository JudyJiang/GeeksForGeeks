import java.util.Arrays;

import utility.*;

public class ReverseSingleLinkedListII {
	
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if(head == null || (m >= n))
			return head;
		
		ListNode fakeHead = new ListNode(-1);
		fakeHead.next = head;
		ListNode prev = fakeHead, curr = head;
		int count = 1;
		while(count < m){
			prev = curr;
			curr = curr.next;
			count++;
		}
		
		ListNode next;
		
		while(count < n){
			next = curr.next;
			curr.next = next.next;
			next.next = prev.next;//This step is important, otherwise will lose the "next.next" link and 
			//only points the "current curr". middle nodes will be missing;
			prev.next = next;
			count++;
		}
		return fakeHead.next;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
		ListNode res = reverseBetween(head, 2, 4);
		res.printList();
	}
}

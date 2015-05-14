import utility.*;


public class SwapPairNodes {
	public static ListNode swapPairs(ListNode head){
		ListNode fakeHead = new ListNode(-1);
		fakeHead.next = head;
		
		ListNode curr = head, prev = fakeHead, next;
		while(curr != null && curr.next != null){
			next = curr.next;
			curr.next = next.next;
			next.next = prev.next;
			prev.next = next;
			prev = curr;
			curr = curr.next;
		}
		return fakeHead.next;
	}
	
	public static void main(String[] args){
		ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
		ListNode res = swapPairs(head);
		res.printList();
	}
}

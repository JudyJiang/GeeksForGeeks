import utility.*;

public class RemoveListDuplicates {
	public static ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null)
			return head;
		
		ListNode fakeHead = new ListNode(-1), prev = head, curr;
		fakeHead.next = head;
		while(prev != null){
			curr = prev.next;
			while(curr != null && curr.val == prev.val){
			//	System.out.println(prev.val + " " + curr.val);
				curr = curr.next;
			}
			if(curr == null){
				prev.next = curr;
				break;
			}
			ListNode next = curr.next;
			prev.next = curr;
			prev = curr;
			curr = next;
		}
		return fakeHead.next;
	}
	
	public static void main(String[] args){
		ListNode head = new ListNode(new int[]{1, 2, 2});
		ListNode res = deleteDuplicates(head);
		res.printList();
	}
}

import utility.ListNode;

public class ReverseSingleLinkedList {
	public static ListNode reverseList(ListNode head){
		ListNode tail = null, curr = head, next;
		while(curr != null){
			next = curr.next;
			curr.next = tail;
			tail = curr;
			curr = next;
		}
		return tail;
	}
	
	public static void main(String[] args){
		ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
		ListNode res = reverseList(head);
		res.printList();
	}
}

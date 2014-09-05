package linkedlist;

public class ReverseLinkedList {
	public static void reverseLinkedList(ListNode head){
		ListNode prev = null, current = head, next;
		
		while(current != null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		
		prev.PrintList();
	}
	
	public static void main(String[] args){
		ListNode head = new ListNode();
		head.GetSampleList(new Integer[]{1, 2, 3, 4, 5, 6, 7});
		reverseLinkedList(head);
	}
}

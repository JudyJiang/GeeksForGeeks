package linkedlist;

public class MiddleOfLinkedList {
	public static void LinkedListMiddle(ListNode head){
		if(head == null || head.next == null)
			return ;
		
		ListNode slow = head, fast = head;
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		
		System.out.println(slow.value);
	}
	
	public static void main(String[] args){
		ListNode head = new ListNode();
		head.GetSampleList(new Integer[]{1, 2, 3, 4, 5});
		LinkedListMiddle(head);
	}
}

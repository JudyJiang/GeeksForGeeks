package linkedlist;

public class MoveLastNodeToFront {
	public static ListNode MoveToFront(ListNode head){
		ListNode p = head, previous = null;
		while(p.next != null){
			previous = p;
			p = p.next;
		}
		
		p.next = head;
		previous.next = null;
		return p;
	}
	public static void main(String[] args){
		ListNode head = new ListNode();
		head.GetSampleList(new Integer[]{1, 2, 3, 4, 5, 6});
		ListNode p = MoveToFront(head);
		p.PrintList();
	}
}

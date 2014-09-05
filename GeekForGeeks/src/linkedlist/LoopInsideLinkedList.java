package linkedlist;

public class LoopInsideLinkedList {
	public static boolean DetectLoop(ListNode head){
		if(head == null || head.next == null)
			return false;
		
		if(head.next == head)
			return true;
		
		ListNode slow = head, fast = head;
		
		while(true){
			slow = slow.next;
			fast = fast.next;
			
			if(fast == null || fast.next == null)
				return false;
			
			fast = fast.next;
			if(slow == fast)
				return true;
		}
	}
	
	public static void main(String[] args){
		ListNode head = new ListNode();
		head.GetSampleList(new Integer[]{1, 2, 3, 4, 5});
	//	head.GetTail().next = head.next.next;
		
		System.out.println(DetectLoop(head));
	}
}

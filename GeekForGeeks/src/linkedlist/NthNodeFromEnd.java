package linkedlist;

public class NthNodeFromEnd {
	public static void NNodeFromEnd(ListNode head, int n){
		if(head == null || head.next == null && n > 1)
			return ;
		
		ListNode fast = head, slow = head;
		int count = 0;
		while(count < n){
		//	slow = slow.next;
			fast = fast.next;
			if(fast == null || fast.next == null)
				break;
			
			count++;
		}
		
		while(fast.next != null){
			fast = fast.next;
			slow = slow.next;
		}
		
		System.out.println(slow.value);
	}
	
	public static void main(String[] args){
		ListNode head = new ListNode();
		head.GetSampleList(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11});
		NNodeFromEnd(head, 3);
	}
}

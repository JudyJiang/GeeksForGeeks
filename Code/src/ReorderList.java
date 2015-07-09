import utility.*;

public class ReorderList {
	 public void reorderList(ListNode head) {
	        if(head == null || head.next == null){
	            return ;
	        }
	        
	        ListNode fast = head, slow = head;
	        while(fast.next != null && fast.next.next != null){
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        fast = slow.next;
	        slow.next = null;
	        ListNode tail = null;
	        while(fast != null){
	            ListNode next = fast.next;
	            fast.next = tail;
	            tail = fast;
	            fast = next;
	        }
	        
	        slow = head;
	        while(tail != null){
	            ListNode next = tail.next;
	            tail.next = slow.next;
	            slow.next = tail;
	            tail = next;
	            slow = slow.next.next;
	        }
	    }
}

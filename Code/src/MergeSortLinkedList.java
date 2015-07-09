import utility.*;

public class MergeSortLinkedList {
	public static ListNode sortList(ListNode head){
		if(head == null || head.next == null)
			return head;
		
		ListNode slow = head, fast = head;
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		
		fast = slow.next;
		slow.next = null;
		
		slow = sortList(head);
		fast = sortList(fast);
		
		return merge(slow, fast);
	}
	
	public static ListNode merge(ListNode slow, ListNode fast){
		ListNode dummyHead = new ListNode(0);
		ListNode curr = dummyHead;
		
		while(slow != null && fast != null){
			if(slow.val < fast.val){
				curr.next = slow;
				slow = slow.next;
				curr = curr.next;
			}
			else if(slow.val > fast.val){
				curr.next = fast;
				fast = fast.next;
				curr = curr.next;
			}
			else{
				curr.next = slow;
				slow = slow.next;
				curr = curr.next;
				curr.next = fast;
				fast = fast.next;
				curr = curr.next;
			}
		}
		
		if(slow != null)
			curr.next = slow;
		
		if(fast != null)
			curr.next = fast;
		return dummyHead.next;
	}
	
	public static void main(String[] args){
		ListNode head = new ListNode(new int[]{3, 1, 4, 5, 7, 6, 8, 2});
		ListNode res = sortList(head);
		while(res != null){
			System.out.print(res.val + " ");
			res = res.next;
		}
	}
}

import utility.*;

/*
 */
public class InsertionSortLinkedList {
	public static ListNode insertionSortList(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		
		ListNode dummyHead = new ListNode(-1);
		dummyHead.next = head;
		ListNode curr = dummyHead.next;
		while(curr != null){
			ListNode runner = curr.next;
			while(runner != null){
				if(runner.val < curr.val){
					int tmp = curr.val;
					curr.val = runner.val;
					runner.val = tmp;
					//runner = runner.next;
				}
				runner = runner.next;
			}
			curr = curr.next;
		}
		return dummyHead.next;
	}
	
	public static ListNode insertionSortListII(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		
		ListNode fast = head;
		while(fast != null){
			ListNode slow = head;
			while(slow != fast){
				if(slow.val > fast.val){
					int tmp = slow.val;
					slow.val = fast.val;
					fast.val = tmp;
				}
				slow = slow.next;
			}
			fast = fast.next;
		}
		return head;
	}
	
	public static void main(String[] argrs){
		ListNode head = new ListNode(new int[]{3, 1, 4, 8, 6, 5, 7, 2});
		ListNode res = insertionSortListII(head);
		while(res != null){
			System.out.print(res.val + " ");
			res = res.next;
		}
		
	}
}

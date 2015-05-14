import utility.*;

public class MergeTwoList {
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
		if(l1 == null && l2 == null)
			return null;
		if(l1 == null || l2 == null)
			return l1 == null ? l2 : l1;
		ListNode head = new ListNode(-1), curr = head;
		while(l1 != null && l2 != null){
			if(l1.val <= l2.val){
				curr.next = l1;
				l1 = l1.next;
				curr = curr.next;
			}
			else{
				curr.next = l2;
				l2 = l2.next;
				curr = curr.next;
			}
		}
		
		ListNode remain = l1 == null? l2 : l1;
		while(remain != null){
			curr.next = remain;
			remain = remain.next;
			curr = curr.next;
		}
		return head.next;
	}
	
	public static void main(String[] args){
		
	}
}

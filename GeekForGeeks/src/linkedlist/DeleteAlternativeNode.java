package linkedlist;


/**
 * http://www.geeksforgeeks.org/delete-alternate-nodes-of-a-linked-list/
 * @author FengjiaoJiang
 *
 */
public class DeleteAlternativeNode {
	
	public static void DeleteAlternative(ListNode head){
		if(head == null || head.next == null)
			return ;
		ListNode p = head;
		while(p != null){
			ListNode q = p.next == null? null : p.next.next;
			p.next = q;
			p = q;
		}
	}
	
	
	public static void main(String[] args){
		ListNode head = new ListNode();
		head.GetSampleList(new Integer[]{1, 2, 3, 4, 5});
		DeleteAlternative(head);
		head.PrintList();
	}
}

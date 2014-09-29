package linkedlist;

/**
 * http://www.geeksforgeeks.org/delete-n-nodes-after-m-nodes-of-a-linked-list/
 * Really need to pay attention the counting problem (also the runner pointer)
 * @author FengjiaoJiang
 *
 */
public class DeleteNAfterM {
	
	/*
	 * Made a mistake, this only delete once.
	 */
	public static ListNode NAfterM(ListNode head, int m, int n){
		if(head == null || head.next == null || n == 0)
			return head;
		
		int count = 0;
		ListNode p = head, previous1 = null;
		while(count < m){
			count++;
			previous1 = p;
			p = p.next;
		}
		
		count = 0;
		while(count < n){
			count++;
			p = p.next;
		}
		
		previous1.next = p;//previous2;
		return head;
	}
	
	public static ListNode NAfterMMore(ListNode head, int m, int n){
		if(head == null || head.next == null || n == 0)
			return head;
		
		ListNode p = head, previous = null;
		int count = 0;
		
		while(p != null){
			count = 0;
			while(count < m){
				count++;
				previous = p;
				p = p.next;
			}
			
			count = 0;
			
			while(count < n && p != null){
				count++;
				p = p.next;
			}
			previous.next = p;
			previous = previous.next;
			//p = p == null ? null : p.next;
		}
		return head;
	}
	
	public static void main(String[] args){
		ListNode head = new ListNode();
		head.GetSampleList(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
		NAfterMMore(head, 2, 2).PrintList();
	}
}

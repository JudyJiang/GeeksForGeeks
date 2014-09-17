package linkedlist;

import java.util.Hashtable;

public class RemoveDuplicateFromUnsortedList {

	public static void RemoveWithTwoLoop(ListNode head){
		ListNode p = head;
		ListNode q, current;
		while(p != null){
			q = p;
			while(q.next != null){
				if(q.next.value == p.value){
					q.next = q.next.next;
				}
				q = q.next;
				if(q == null)
					break;
			}
			p = p.next;
		}
	} 
	
	public static void RemoveWithHashTable(ListNode head){
		if(head == null || head.next == null)
			return ;
		Hashtable table = new Hashtable();
		ListNode p = head, previous = null;
		
		while(p != null){
			if(table.containsKey(p.value)){
				previous.next = p.next;
			}
			
			else{
				table.put(p.value, true);
				previous = p;
			}
			p = p.next;
		}
	}
	
	
	
	//12->11->12->21->41->43->21
	public static void main(String[] args){
		ListNode head = new ListNode();
		head.GetSampleList(new Integer[]{12, 11, 12, 21, 41, 43, 21});
		//RemoveWithTwoLoop(head);
		RemoveWithHashTable(head);
		head.PrintList();
	}
}

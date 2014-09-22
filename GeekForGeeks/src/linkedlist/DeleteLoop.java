package linkedlist;

import java.util.Hashtable;
/**
 * Right Answer;
 * http://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/
 * @author FengjiaoJiang
 *
 */
public class DeleteLoop {
	public static void DeleteLoop(ListNode head){
		if(head == null || head.next == null)
			return;
		
		Hashtable<ListNode, Boolean> table = new Hashtable<ListNode, Boolean>();
		ListNode p = head;
		
		while(true){
			if(!table.containsKey(p)){
				table.put(p, true);
			}
			if(table.containsKey(p.next)){
				break;
			}
			p = p.next;
		}
		p.next = null;
	}
	
	public static void CheckOneByOne(ListNode head){
		if(head == null || head.next == null)
			return ;
		
		ListNode slow = head, fast = head;
		
		while(true){
			slow = slow.next;
			fast = fast.next.next;//So stupid I am! Back to the loop node not the head! Loop 
			//Doesn't have to begin from the head!!!
			if(slow == fast){
				RemoveLoop(slow, head);
				break;
			}
		}
	}
	
	public static void RemoveLoop(ListNode loop, ListNode head){
		ListNode p, q;
		p = head;
		while(true){
			q = loop;
			while(q.next != loop && q.next != p)
				q = q.next;
			
			if(q.next.value == p.value){
				break;
			}
			
			else
				p = p.next;
		}
		q.next = null;	
	}
	/* I got the strategy now, the point is not "find the point to cause the loop, but to find the loop itself"
	 * Once find the loop, start from a node inside the loop cause there should be one node who causes the loop.
	 * Iterative each node until it reaches "p" node who runs start from the beginning.
	 */
	
	
	public static void main(String[] args){
		ListNode head = new ListNode();
		head.GetSampleList(new Integer[]{10, 4, 15, 20, 50});
		head.next.next.next.next.next = head;
		DeleteLoop(head);
		head.PrintList();
	}
}

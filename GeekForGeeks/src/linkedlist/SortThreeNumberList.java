package linkedlist;

/**
 * http://www.geeksforgeeks.org/sort-a-linked-list-of-0s-1s-or-2s/
 * I love myself.
 * Adorable.
 * @author FengjiaoJiang
 *
 */
public class SortThreeNumberList {
	
	public static ListNode Sort(ListNode<Integer> head){
		ListNode<Integer> newHead = new ListNode(), end = null, p = head;
		newHead.next = head;
		ListNode<Integer> previous = newHead;
		
		while(p != null){
			ListNode<Integer> next = p.next;
			if(p.value == 2){
				previous.next = p.next;
				p.next = end;
				end = p;
			}
			
			else if(p.value == 0){
				previous.next = p.next;
				p.next = newHead.next;
				newHead.next = p;
			}
			
			else{
				previous = previous.next;
			}
			p = next;
		}
		
		previous.next = end;
		return newHead.next;
	}
	
	public static void main(String[] args){
		ListNode head = new ListNode();
		head.GetSampleList(new Integer[]{2, 1, 2, 1, 1, 2, 0, 1, 0});
		head = Sort(head);
		head.PrintList();
	}
}

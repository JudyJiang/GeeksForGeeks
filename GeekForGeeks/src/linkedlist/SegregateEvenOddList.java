package linkedlist;


/**
 * http://www.geeksforgeeks.org/segregate-even-and-odd-elements-in-a-linked-list/
 * @author FengjiaoJiang
 *
 */
public class SegregateEvenOddList {
	
	public static ListNode EvenOddChange(ListNode<Integer> head){
		ListNode oddHead = new ListNode(), evenHead = new ListNode();
		ListNode oddEnd = oddHead, evenEnd = evenHead;
		ListNode<Integer> p = head;
		
		while(p != null){
			if(p.value % 2 == 0){
				evenEnd.next = p;
				evenEnd = evenEnd.next;
			}
			
			else{
				oddEnd.next = p;
				oddEnd = oddEnd.next;
			}
			p = p.next;
		}
		
		evenEnd.next = oddHead.next;
		oddEnd.next = null;
		//oddHead.PrintList();
		//evenHead.PrintList();
		return evenHead.next;
	}
	
	public static ListNode EvenOddChangeII(ListNode<Integer> head){
		if(head == null || head.next == null)
			return head;
		
		ListNode<Integer> newHead = new ListNode(), p = head;
		newHead.next = head;
		
		while(p.next != null)
			p = p.next;
		
		ListNode<Integer> previous = newHead, current = head, start = p;
		newHead.next = head;
		
		while(current != p){
			ListNode<Integer> next = current.next;
			if(current.value % 2 == 0){
				previous = current;
			}
			
			else{
				previous.next = current.next;
				start.next = current;
				current.next = null;
				start = start.next;
			//	previous = previous.next;
				
			}
			current = next;
		}
		
		if(p.value % 2 != 0){
			previous.next = p.next;
			start.next = p;
			p.next = null;
		}
		return newHead.next;
	}
	
	public static void main(String[] args){
		ListNode<Integer>[] lists = new ListNode[5];
		for(int i = 0; i < lists.length; i++)
			lists[i] = new ListNode<Integer>();
		
		lists[0].GetSampleList(new Integer[]{17, 15, 8, 12, 10, 5, 4, 1, 7, 6});
		lists[1].GetSampleList(new Integer[]{8, 12, 10, 5, 4, 1, 6});
		lists[2].GetSampleList(new Integer[]{8, 12, 10});
		lists[3].GetSampleList(new Integer[]{1, 3, 5, 7});
		lists[4].GetSampleList(new Integer[]{1, 3, 4, 9, 18, 20, 6, 11});
		
		for(int i = 0; i < lists.length; i++){
			//lists[i] = EvenOddChange(lists[i]);
			lists[i] = EvenOddChangeII(lists[i]);
			lists[i].PrintList();
		}
		
		
	}
}

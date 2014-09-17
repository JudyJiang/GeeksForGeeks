package linkedlist;

public class RemoveDuplicateFromSortedList {
	
	public static void RemoveDuplicate(ListNode head){
		ListNode current = head, previous = null;
		
		while(current != null){
			if(previous != null && current.value == previous.value){
				previous.next = current.next;
				current = current.next;
			}
			else{
				previous = current;
				current = current.next;
			}
		}
	}
	
	public static void main(String[] args){
		ListNode head = new ListNode();
		// 11->11->11->21->43->43->60 
//		head.GetSampleList(new Integer[]{11, 11, 11, 21, 43, 43, 60});
//		RemoveDuplicate(head);
//		head.PrintList();
		head.GetSampleList(new Integer[]{1, 1, 1, 1, 1, 1, 1, 2});
		RemoveDuplicate(head);
		head.PrintList();
	}
}

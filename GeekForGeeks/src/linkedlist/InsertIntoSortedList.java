package linkedlist;

public class InsertIntoSortedList {
	public static void InsertIntoSorted(ListNode<Integer> head, ListNode<Integer> node){
		if(head == null){
			head = node;
			return ;
		}
		
		else if(head.value >= node.value){
			node.next = head;
			head = node;
			return ;
		}
		
		ListNode<Integer> p = head, previous = null;
		while(p != null){
			if(p.value > node.value)
				break;
			previous = p;
			p = p.next;
		}
		
		previous.next = node;
		node.next = p;
	}
	
	public static void main(String[] args){
		ListNode<Integer> head = new ListNode<Integer>(2);
		head.GetSampleList(new Integer[]{5, 7, 10, 15});
		InsertIntoSorted(head, new ListNode<Integer>(9));
		head.PrintList();
	}
}

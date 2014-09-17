package linkedlist;

public class ReverseDoublyList {
	
	public static DoubleListNode ReverseDoubleList(DoubleListNode head){
		DoubleListNode p = head;
		DoubleListNode end = null;
		
		while(p != null){
			DoubleListNode next = p.next;
			p.next = end;
			if(end != null)
				end.previous = p;
			end = p;
			p = next;
		}
		end.previous = null;
		return end;
	}
	
	public static void main(String[] args){
		DoubleListNode head = new DoubleListNode();
		head.GetSampleDoubleList(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
		DoubleListNode p = ReverseDoubleList(head);
		p.PrintList();
	}
}

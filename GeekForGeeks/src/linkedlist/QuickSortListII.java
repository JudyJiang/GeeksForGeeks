package linkedlist;

public class QuickSortListII {
	
	public static ListNode<Integer> GetTail(ListNode<Integer> head){
		if(head == null || head.next == null)
			return head;
		
		ListNode<Integer> p = head;
		while(p.next != null)
			p = p.next;
		return p;
	}
	
	public static ListNode<Integer> QuickSort(ListNode<Integer> head){
		return QuickSort(head, GetTail(head));
	}
	
	public static ListNode<Integer>[] Partition(ListNode<Integer> head, ListNode<Integer> tail){
		ListNode<Integer>[] list = new ListNode[3];
		ListNode<Integer> pivot = tail, newHead = new ListNode<Integer>(), newEnd = new ListNode<Integer>();

		ListNode<Integer> p = head;
		
		return list;
	}
	
	public static ListNode<Integer> QuickSort(ListNode<Integer> head, ListNode<Integer> tail){
		if(head == null || head == tail)
			return head;
		ListNode<Integer> newHead = new ListNode<Integer>();
		ListNode<Integer> newEnd = new ListNode<Integer>();
		
		ListNode<Integer>[] lists = Partition(head, tail);
		
//		if(newHead != pivot && newHead.value != null){
//			System.out.println("Here");
//			ListNode<Integer> tmp = newHead;
//			while(tmp.next != pivot)
//				tmp = tmp.next;
//			tmp.next = null;
//			newHead = QuickSort(newHead, tmp);
//			tmp = GetTail(newHead);
//			tmp.next = pivot;
//		}
//		
//		
//		if(newHead.value == null){
//			newHead = pivot;
//		}
//		pivot.next = QuickSort(pivot.next, newEnd);
		
		return newHead;
	}
	
	public static void main(String[] args){
		ListNode<Integer> head = new ListNode();
		head.GetSampleList(new Integer[]{5, 20, 4, 3, 1, 7, 8, 11});
		head = QuickSort(head);
		head.PrintList();
	}
}

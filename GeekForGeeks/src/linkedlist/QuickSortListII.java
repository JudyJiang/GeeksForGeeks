package linkedlist;


/**
 * THIS REALLY TAKES ME A LONG TIME....
 * 
 * @author FengjiaoJiang
 *
 */
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
		ListNode<Integer> previous = newHead, p = head;
		newHead.next = head;
		
		while(p != pivot){
			if(p.value < pivot.value){
				previous = p;
				p = p.next;
			}
			
			else{
				ListNode<Integer> next = p.next;
				previous.next = p.next;
				tail.next = p;
				p.next = null;
				tail = tail.next;
				p = next;
			}
		}
		
		newHead = newHead.next;
		newEnd = tail;
		
		list[0] = newHead;
		list[1] = newEnd;
		list[2] = pivot;
		
		return list;
	}
	
	public static ListNode<Integer> QuickSort(ListNode<Integer> head, ListNode<Integer> tail){
		if(head == null || head == tail)
			return head;
		
		ListNode<Integer>[] lists = Partition(head, tail);
		ListNode<Integer> newHead = lists[0], newEnd = lists[1], pivot = lists[2];
		

		if(newHead != pivot){//Previous I set this to "while" ... maybe that's the reason..
			ListNode<Integer> tmp = newHead;
			while(tmp.next != pivot)
				tmp = tmp.next;
			tmp.next = null;
			newHead = QuickSort(newHead, tmp);
			tmp = GetTail(newHead);
			tmp.next = pivot;
		}
		pivot.next = QuickSort(pivot.next, newEnd);
		return newHead;
	}
	
	public static void main(String[] args){
		ListNode<Integer> head = new ListNode();
		head.GetSampleList(new Integer[]{5, 20, 4, 3, 30});
		head = QuickSort(head);
		head.PrintList();
	}
}

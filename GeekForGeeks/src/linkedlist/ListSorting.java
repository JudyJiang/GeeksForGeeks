package linkedlist;

public class ListSorting {
	public static ListNode<Integer> MergeSort(ListNode<Integer> head){
		return MergeSort(head, true);
	}
	
	public static ListNode<Integer> MergeSort(ListNode<Integer> head, boolean ascendent){
		if(head == null || head.next == null){
			return head;
		}
		
		ListNode<Integer> slow = head, fast = head;
		
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		
		fast = slow.next;
		slow.next = null;
		
		slow = MergeSort(head, ascendent);
		fast = MergeSort(fast, ascendent);
		
		return Merge(slow, fast, ascendent);
	}
	
	public static ListNode<Integer> Merge(ListNode<Integer> l1, ListNode<Integer> l2, boolean ascendent){
		if(l1 == null)
			return l2;
		
		if(l2 == null)
			return l1;
		
		ListNode<Integer> head = new ListNode<Integer>(), p = head;
		while(l1 != null && l2 != null){
			if(ascendent){
				if(l1.value < l2.value){
					p.next = l1;
					l1 = l1.next;
				}
				else{
					p.next = l2;
					l2 = l2.next;
				}
				p = p.next;
			}
			
			if(!ascendent){
				//System.out.println(l1.value + " " + l2.value);
				if(l1.value > l2.value){
					p.next = l1;
					l1 = l1.next;
				}
				else{
					p.next = l2;
					l2 = l2.next;
				}
				p = p.next;
			}
		}
		
		p.next = l1 == null ? l2 : l1;
		
		return head.next;
	}
	
	public static void main(String[] args){
		ListNode<Integer> head = new ListNode<Integer>();
		head.GetSampleList(new Integer[]{10, 12, 6, 29});
		head = MergeSort(head, false);
		head.PrintList();
	}
	
	
}

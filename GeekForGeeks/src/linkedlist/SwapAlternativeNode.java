package linkedlist;

/**
 * Given a linked list, reverse alternative nodes and append them to end of the
 * list. Extra allowed space is O(1)
 * 
 * Example: 1->2->3->4->5->6 1->3->5->6->4->2
 * Should pay attention here is that, since different LinkedList has different implementations.
 * Should ask about the LinkedList methods of "AddNode" & if it has a tail or a head.
 * (Most likely they already give you the structure
 * 
 * @author FengjiaoJiang
 * 
 */
public class SwapAlternativeNode {
	
	public static ListNode SwapAlternative(ListNode list){
		if(list == null || list.next == null || list.next.next == null)
			return list;
		
		ListNode head = new ListNode();
		head.next = list;
		
		ListNode even = list.next;
		list.next = list.next.next;
		list = list.next;
		even.next = null;
		
		while(list != null && list.next != null){
			ListNode temp = list.next.next;
			list.next.next = even;
			even = list.next;
			list.next = temp;
			if(temp != null)
				list = temp;
		}
		
		list.next = even;
		return head.next;
	}
	

	public static void main(String[] args) {
		Integer[] array = {1, 2, 3, 4, 5, 6};
		ListNode list = new ListNode<Integer>();
		list.GetSampleList(array);
		list.PrintList();
		ListNode res = SwapAlternative(list);
		res.PrintList();
	}
}

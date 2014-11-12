package linkedlist;

/**
 * http://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-lists/
 * @author FengjiaoJiang
 *
 */
public class AddList {
	public static ListNode AddingList(ListNode<Integer> l1, ListNode<Integer> l2){
		if(l1 == null)
			return l2;
		
		if(l2 == null)
			return l1;
		
		ListNode<Integer> head = new ListNode(), p = l1, q = l2, current = head;
		int addIn = 0;
		
		while(p != null && q != null){
			int value = p.value + q.value + addIn;
			current.next = new ListNode(value % 10);
			current = current.next;
			addIn = value / 10;
			p = p.next;
			q = q.next;
		}
		
		if(p == null && q == null){
			if(addIn != 0){
				current.next = new ListNode(addIn);
			}
			return head.next;
		}
		
		ListNode<Integer> rest = p == null ? q : p;
		while(rest != null){
			int value = rest.value + addIn;
			current.next = new ListNode(value % 10);
			current = current.next;
			addIn = value / 10;
			rest = rest.next;
		}
		
		if(addIn != 0)
			current.next = new ListNode(addIn);
		
		return head.next;
	}
	
	public static ListNode RecursiveAddList(ListNode<Integer> l1, ListNode<Integer> l2){
		return null;
	}
	
	public static void main(String[] args){
		ListNode<Integer> l1 = new ListNode(), l2 = new ListNode();
	
		//l1.GetSampleList(new Integer[]{5, 6, 3});
		//l2.GetSampleList(new Integer[]{8, 4, 2});
		l1.GetSampleList(new Integer[]{7, 5, 9, 4, 6});
		l2.GetSampleList(new Integer[]{8, 4});
		ListNode head = AddingList(l1, l2);
		head.PrintList();
	}
}

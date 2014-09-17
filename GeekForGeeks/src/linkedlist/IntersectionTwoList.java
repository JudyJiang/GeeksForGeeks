package linkedlist;

/**
 * http://www.geeksforgeeks.org/intersection-of-two-sorted-linked-lists/
 * @author FengjiaoJiang
 * List1: 1->2->3->4->6
 * List2: 2->4->6->8
 * Return: 2->4->6
 * Er.. Seems a simple one
 *
 */
public class IntersectionTwoList {
	public static ListNode IntersectionTwoLists(ListNode<Integer> l1, ListNode<Integer> l2){
		ListNode l = new ListNode(), p = l;
		while(l1 != null && l2 != null){
			if(l1.value == l2.value){
				p.next = new ListNode(l1.value);
				p = p.next;
				l1 = l1.next;
				l2 = l2.next;
			}
			
			else if(l1.value > l2.value){
				l2 = l2.next;
			}
			
			else{
				l1 = l1.next;
			}
		}
		return l.next;
	}
	
	public static void main(String[] args){
		ListNode l1 = new ListNode(), l2 = new ListNode();
		l1.GetSampleList(new Integer[]{1, 2, 3, 4, 6});
		l2.GetSampleList(new Integer[]{2, 4, 6, 8});
		ListNode l = IntersectionTwoLists(l1, l2);
		l.PrintList();
	}
}

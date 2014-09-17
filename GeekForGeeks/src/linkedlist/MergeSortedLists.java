package linkedlist;

/**
 * http://www.geeksforgeeks.org/merge-two-sorted-linked-lists/
 * 5->10->15
 * 2->3->20
 * 2->3->5->10->15->20
 * @author FengjiaoJiang
 *
 */
public class MergeSortedLists {
	
	public static ListNode MergeList(ListNode<Integer> l1, ListNode<Integer> l2){
		if(l1 == null)
			return l2;
		else if(l2 == null)
			return l1;
		
		ListNode head = new ListNode();
		ListNode<Integer> p = l1, q = l2, k = head;
		while(p != null && q != null){
			if(p.value == q.value){
				k.next = new ListNode(p.value);
				p = p.next;
				q = q.next;
			}
			
			else if(p.value < q.value){
				k.next = new ListNode(p.value);
				p = p.next;
			}
			
			else{
				k.next = new ListNode(q.value);
				q = q.next;
			}
			k = k.next;
		}
		k.next = p == null ? q : p;
		return head.next;
	}
	
	public static void main(String[] args){
		ListNode l1 = new ListNode(), l2 = new ListNode();
		l1.GetSampleList(new Integer[]{5, 10, 15});
		l2.GetSampleList(new Integer[]{2, 3, 20});
		ListNode head = MergeList(l1, l2);
		head.PrintList();
	}
}

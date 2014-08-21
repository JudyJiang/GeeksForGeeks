package linkedlist;

/**
 * Merge the second linked list into the first one at alternative position.
 * 5->7->17->13->11 
 * 12->10->2->4->6
 * 5->12->7->10->17->2->13->4->11->6
 * And second list should become empty
 * 
 * If:
 * 1->2->3
 * 4->5->6->7->8
 * Combined is: 1->4->2->5->3->6
 * second is:7->8
 * @author FengjiaoJiang
 *
 */
public class MergeIntoAlternative {
	
	//java by reference.
	public static ListNode<Integer>[] mergeAlternative(ListNode<Integer> list1, ListNode<Integer> list2){
		if(list1 == null || list2 == null)
			return list1 == null? new ListNode[]{null, list2} : new ListNode[]{list1, null};
		
		ListNode<Integer> l1 = list1, l2 = list2, next1 = null, next2 = null;
		while(l1 != null && l2 != null){
			next1 = l1.next;
			next2 = l2.next;
			
			l2.next = next1;
			l1.next = l2;
			
			l1 = next1;
			l2 = null;
			l2 = next2;
		}
		list2 = l2;
		return new ListNode[]{list1, list2};
	}
	
	public static void main(String[] args){
		ListNode<Integer> l1 = new ListNode<Integer>();
		ListNode<Integer> l2 = new ListNode<Integer>();
		l1.GetSampleList(new Integer[]{1, 2, 3, 4});
		l2.GetSampleList(new Integer[]{5, 6, 7, 8, 9, 10});
		ListNode[] res = mergeAlternative(l1, l2);
		res[0].PrintList();
		res[1].PrintList();
	}
}

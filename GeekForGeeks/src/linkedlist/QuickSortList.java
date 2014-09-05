package linkedlist;

/**
 * Quick Sort on singly linked list;
 * 
 * @author FengjiaoJiang
 *         http://www.geeksforgeeks.org/quicksort-on-singly-linked-list/
 *         5->2->6->3->7->9->1
 */
public class QuickSortList {

	
	
	/**
	 * TODO: Implement QuickSort on LinkedList
	 */
	/**
	 * It's a .. partition & tradition sort
	 * @param head
	 * @return
	 */
	public static ListNode<Integer> SortList(ListNode<Integer> head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode<Integer> compare = head, current = head.next, pre = new ListNode<Integer>(0), next = new ListNode<Integer>(0);
		pre.next = compare;
		next.next = null;

		while (current != null) {
			ListNode<Integer> tempNext = current.next;
			if (current.value < compare.value) {
				if(pre.next.value < current.value){
					ListNode<Integer> temp = pre.next;
					while(temp.next.value < current.value)
						temp = temp.next;
					current.next = temp.next;
					temp.next = current;
				}
				
				else{
					current.next = pre.next;
					pre.next = current;
				}
			}

			else {
				if(next.next == null || next.next.value > current.value){
					current.next = next.next;
					next.next = current;
				}
				
				else{
					ListNode<Integer> temp = next.next;
					while(temp.next != null && (temp.next.value < current.value))
						temp = temp.next;
					current.next = temp.next;
					temp.next = current;
				}
			}
			current = tempNext;
		}
		
		compare.next = null;
		compare.next = next.next;
		
		return pre.next;
	}

	public static void main(String[] args) {
		Integer[] arr = { 5, 2, 6, 3, 7, 9, 1 };
		ListNode<Integer> list = new ListNode<Integer>();
		list.GetSampleList(arr);
		//QuickSort(list, null);
		list = SortList(list);
		list.PrintList();
	}
}

package linkedlist;

/**
 * http://www.geeksforgeeks.org/find-a-triplet-from-three-linked-lists-with-sum-equal-to-a-given-number/
 * Only notice the small sorting trick!
 * @author FengjiaoJiang
 *
 */

public class TripletListSum {
	public static ListNode<Integer>[] TripleSum(ListNode<Integer> a, ListNode<Integer> b, ListNode<Integer> c, int given){
		if(a == null || b == null || c == null)
			return null;
		
		b = ListSorting.MergeSort(b);
		c = ListSorting.MergeSort(c, false);
		ListNode<Integer>[] results = new ListNode[3];
		
		ListNode<Integer> l1 = a, l2 = b, l3 = c;
		boolean find = false;
		
		while(l1 != null){
			l2 = b; l3 = c;
			
			while(l2 != null && l3 != null){
				int sum = l1.value + l2.value + l3.value;
				
				if(sum == given){
					results[0] = l1;
					results[1] = l2;
					results[2] = l3;
					find = true;
					break;
				}
				
				else if(sum < given){
					l2 = l2.next;
				}
				
				else{
					l3 = l3.next;
				}
			}
			
			if(find)
				break;
			l1 = l1.next;

		}
		
		return results;
	}
	
	public static void main(String[] args){
		ListNode<Integer> a = new ListNode<Integer>(), b = new ListNode<Integer>(), c = new ListNode<Integer>();
		a.GetSampleList(new Integer[]{12, 6, 29});
		b.GetSampleList(new Integer[]{23, 5, 8});
		c.GetSampleList(new Integer[]{90, 20, 59});
		
		ListNode<Integer>[] res = TripleSum(a, b, c, 101);
		System.out.println(res[0].value + " " + res[1].value + " " + res[2].value);
	}
}

package linkedlist;

public class IdenticalList {
	public static boolean IdenticalLists(ListNode l1, ListNode l2){
		ListNode p = l1, q = l2;
		while(p != null && q != null){
			if(p.value != q.value)
				return false;
			p = p.next;
			q = q.next;
		}
		
		if(p != null || q != null)
			return false;
		
		return true;
	}
	
	public static boolean RecursiveIdenticalLists(ListNode l1, ListNode l2){
		if(l1 == null || l2 == null)
			return true;
		
		if(l1 == null || l2 == null)
			return false;
		
		if(l1.value != l2.value)
			return false;
		
		return RecursiveIdenticalLists(l1.next, l2.next);
	}
	
	public static void main(String[] args){
		ListNode l1 = new ListNode(), l2 = new ListNode();
		l1.GetSampleList(new Integer[]{1, 2, 3, 4});
		l2.GetSampleList(new Integer[]{1, 2, 3, 4});
		System.out.println(RecursiveIdenticalLists(l1, l2));
	}
}

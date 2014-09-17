package linkedlist;

import java.util.Hashtable;

public class YListIntersection {
	
	public static void GetYList(ListNode head1, ListNode head2){
		head1.GetSampleList(new Integer[]{3, 6, 9, 15, 30});
		head2.GetSampleList(new Integer[]{10});
		head2.next = head1.next.next.next;
		//System.out.println(head1.next.next.next.value + " " + head2.next.value);
	}
	
	public static ListNode FindIntersectionNode(ListNode head1, ListNode head2){
		ListNode p = head1;
		ListNode q, res = null;
		
		while(p != null){
			q = head2;
			while(q != null){
				//System.out.println(p.value + " " + q.value);
				if(q == p){
					res = q;
					break;
				}
				q = q.next;
			}
			if(res != null)
				break;
			p = p.next;
		}
		
		return res;
	}
	
	public static ListNode FindYSection(ListNode head1, ListNode head2){
		ListNode res = null;
		Hashtable<ListNode, Boolean> table = new Hashtable<ListNode, Boolean>();
		ListNode p = head1, q = head2;
		
		while(p != null && q != null){
			if(p == q){
				res = p;
				break;
			}
			
			if(table.containsKey(p) || table.containsKey(q)){
				res = table.containsKey(p) ? p : q;
				break;
			}
			if(!table.containsKey(p)){
				table.put(p, true);
			}
			
			if(!table.containsKey(q)){
				table.put(q,  true);
			}
			p = p.next;
			q = q.next;
		}
		
		if(res == null){
			ListNode remain = p == null? q : p;
			System.out.println(remain.value);
			while(remain != null){
				if(table.containsKey(remain)){
					res = remain;
					break;
				}
				remain = remain.next;
			}
		}
		return res;
	}
	
	public static void main(String[] args){
		ListNode head1 = new ListNode();
		ListNode head2 = new ListNode();
		GetYList(head1, head2);
		ListNode res = FindYSection(head1, head2);
		System.out.println(res.value);
	}
}

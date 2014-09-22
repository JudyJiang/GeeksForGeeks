package linkedlist;

import java.util.Hashtable;

public class UnionInsertionOfList {
	public static ListNode MergeSortList(ListNode<Integer> head){
		if(head == null || head.next == null){//This condition is very important, otherwise may be heap ....you know.
			return head;
		}
		
		ListNode<Integer> slow = head, fast = head;
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		fast = slow.next;
		slow.next = null;//no need to judge if it's "fast.next == null " or "fast.next.next", no need to 
		//give two ends since you can make slow.next = null;
		
		slow = MergeSortList(head);
		fast = MergeSortList(fast);
		
		return Merge(slow, fast);
	}
	
	public static ListNode Merge(ListNode<Integer> slow, ListNode<Integer> fast){
		if(slow == null)
			return fast;
		
		if(fast == null)
			return slow;
		
		ListNode<Integer> head = new ListNode(), p = head;
		
		while(slow != null && fast != null){
			if(slow.value <= fast.value){
				p.next = slow;
				slow = slow.next;
			}
			else{
				p.next = fast;
				fast = fast.next;
			}
			p = p.next;
		}
		p.next = slow == null ? fast : slow;
		
		return head.next;
	}
	
	public static ListNode[] GetUnionIntersectionI(ListNode<Integer> l1, ListNode<Integer> l2){
		l1 = MergeSortList(l1);
		l2 = MergeSortList(l2);
		
		ListNode inter = new ListNode(), union = new ListNode(), p = inter, q = union;
		while(l1 != null && l2 != null){
			if(l1.value == l2.value){
				p.next = l1;
				q.next = l2;
				l1 = l1.next;
				l2 = l2.next;
				p = p.next;
				q = q.next;
			}
			
			else if(l1.value < l2.value){
				q.next = l1;
				l1 = l1.next;
				q = q.next;
			}
			
			else{
				q.next = l2;
				l2 = l2.next;
				q = q.next;
			}
		}
		
		p.next = null;
		q.next = l1 == null ? l2 : l1;
		
		return new ListNode[]{inter.next, union.next};
	}
	
	
	//This part indeed needs a lot of pointers... Not sure it's the most efficient way
	public static ListNode[] GetUnionIntersectionII(ListNode<Integer> l1, ListNode<Integer> l2){
		Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();
		ListNode inter = new ListNode(), union = new ListNode(), p = inter, previous = new ListNode();
		ListNode<Integer> l1Runner = l1, l2Runner = l2;
		previous.next = l2;
		
		while(l1Runner.next != null){
			table.put(l1Runner.value,  true);
			l1Runner = l1Runner.next;
		}
		table.put(l1Runner.value, true);
		
		while(l2Runner != null){
			if(table.containsKey(l2Runner.value)){
				p.next = l2Runner;
				p = p.next;
				previous.next = l2Runner.next;
			}
			else{
				previous = previous.next;
			}
			l2Runner = l2Runner.next;
		}
		
		
		inter.next.PrintList();
		l1Runner.next = l2;
		l1.PrintList();
		
		return new ListNode[]{inter.next, l1};
	}
	
	
	public static void main(String[] args){
		ListNode<Integer> l1 = new ListNode<Integer>(), l2 = new ListNode<Integer>();
		l1.GetSampleList(new Integer[]{10, 15, 4, 20});
		l2.GetSampleList(new Integer[]{8, 4, 2, 10});
		ListNode[] res = GetUnionIntersectionII(l1, l2);
		//res[0].PrintList();
		//res[1].PrintList();
		//MergeSortList(l1).PrintList();
		//MergeSortList(l2).PrintList();
	}
}

package linkedlist;

import org.w3c.dom.Node;

/**
 * http://www.geeksforgeeks.org/sorted-insert-for-circular-linked-list/
 * @author FengjiaoJiang
 *
 */
public class InsertIntoSortedCircualrList {
	
	public static ListNode InsertIntoCircular(ListNode<Integer> head, int value){
		if(head == null){
			head = new ListNode(value);
			head.next = head;
			return head;
		}
		
		ListNode<Integer> p = head;
		boolean inserted = false;
		
		while(p.next != head){
			if(p.value <= value && p.next.value > value){
				ListNode node = new ListNode(value);
				node.next = p.next;
				p.next = node;
				inserted = true;
				break;
			}
			p = p.next;
		}
		
		if(!inserted && head.value >= value){
			ListNode node = new ListNode(value);
			node.next = p.next;
			p.next = node;
			return node;
		}
		
		else if(!inserted){
			p.next = new ListNode(value);
			p.next.next = head;
		}
		
		return head;
	}
	
	

	public static void main(String[] args){
		ListNode<Integer> head = new ListNode<Integer>();
		head.GetSampleList(new Integer[]{2, 5, 8, 10});
		head.GetTail().next = head;
		head = InsertIntoCircular(head, 11);
		head.PrintCircularList();
	}
}

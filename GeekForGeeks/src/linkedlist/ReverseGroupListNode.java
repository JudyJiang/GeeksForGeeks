package linkedlist;


/**
 * 
 * I'm also very proud!
 * You used to fail on this problem! Now you get it all by yourself!!!!
 * 
 * 
 * http://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
 * @author FengjiaoJiang
 *Example:
 *Inputs:  1->2->3->4->5->6->7->8->NULL and k = 3 
 *Output:  3->2->1->6->5->4->8->7->NULL. 
 *
 *Inputs:   1->2->3->4->5->6->7->80->NULL and k = 5
 *Output:  5->4->3->2->1->8->7->6->NULL. 
 *
 */
public class ReverseGroupListNode {
	
	public static ListNode ReverseGroupList(ListNode head, int k){
		if(head == null || head.next == null || k == 0)
			return head;
		
		ListNode newHead = new ListNode(), previous = newHead, p = head, m, n;
		newHead.next = head;
		int count = 1;
		
		while(p != null){
			while(count < k){
				m = p.next;
				n = m == null ? null : m.next;
				p.next = m == null? null : m.next;
				if(m != null)
					m.next = previous.next;
				if(m != null)
					previous.next = m;
				count++;
			}
			//if(p != null)
				previous = p;
			p = p.next;
			count = 1;//One step furtehr
		}
		return newHead.next;
	}
	
	public static void main(String[] args){
		ListNode head = new ListNode();
		head.GetSampleList(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
		head = ReverseGroupList(head, 5);
		head.PrintList();
	}
}

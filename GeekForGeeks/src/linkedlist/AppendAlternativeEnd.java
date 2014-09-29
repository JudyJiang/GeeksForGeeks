package linkedlist;

public class AppendAlternativeEnd {
	public static ListNode AppendAlternative(ListNode head){
		if(head == null || head.next == null)
			return head;
		
		ListNode odd = new ListNode(), even = null, p = head, previous = odd, q, k;
		odd.next = head;
		
		while(p != null && p.next != null){
			q = p.next;
			k = q.next;
			
			previous.next = k;
			previous = previous.next;
			
			q.next = even;
			even = q;
			
			p = k;
		}
		
		odd.PrintList();
		even.PrintList();
		return null;
	}
	
	
	public static void main(String[] args){
		ListNode head = new ListNode();
		head.GetSampleList(new Integer[]{1, 2, 3, 4, 5, 6});
		AppendAlternative(head);
	}
}

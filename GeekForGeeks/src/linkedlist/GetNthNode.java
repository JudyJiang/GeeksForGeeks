package linkedlist;

public class GetNthNode {
	public static ListNode GetNthNode(ListNode head, int n){
		if(head == null && n > 0)
			return null;
		
		int count = 1;
		if(n == 1)
			return head;
		
		while(count < n){
			head = head.next;
			count++;
		}
		return head;
	}
	
	public static void main(String[] args){
		ListNode head = new ListNode(1);//new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
		head.GetSampleList(new Integer[]{2, 3, 4, 5, 6, 7, 8, 9, 10});
	    ListNode N = GetNthNode(head, 5);
	    System.out.println(N.value);
	}
}

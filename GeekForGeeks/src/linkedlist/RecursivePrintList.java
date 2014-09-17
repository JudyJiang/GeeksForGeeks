package linkedlist;

public class RecursivePrintList {
	
	public static void RecursiveCall(ListNode head){
		if(head == null)
			return;
		RecursiveCall(head.next);
		System.out.print(head.value + " ");
	}
	
	public static void main(String[] args){
		ListNode head = new ListNode();
		head.GetSampleList(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
		RecursiveCall(head);
	}
}

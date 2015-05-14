import utility.ListNode;


public class RemoveListElement {
	
	//
	public static ListNode removeElement(ListNode head, int x){
		if(head == null)
			return head;
		
		ListNode fakeHead = new ListNode();
		fakeHead.next = head;
		ListNode curr = fakeHead.next, prev = fakeHead;
		
		while(curr != null){
			ListNode next = curr.next;
			if(curr.val == x){
				prev.next = next;
			}
			else{
				prev = curr;
			}
			curr = next;
		}
		return fakeHead.next;
	}
	
	public static void main(String[] args){
		ListNode head = new ListNode(new int[]{1, 2, 6, 3, 4, 5, 6});
		ListNode res = removeElement(head, 6);
		res.printList();
	}
}

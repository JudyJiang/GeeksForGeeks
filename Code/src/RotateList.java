import utility.*;

//very well...
public class RotateList {
	public static ListNode rotateList(ListNode head, int k){
		if(head == null || head.next == null)
			return head;
		
		ListNode tail = head, curr = head;
		int len = 0, kk = 0;
		while(tail.next != null){
			len++;
			tail = tail.next;
		}
		len++;
		kk = k % len;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		int count = 0;
		while(count < (len - kk)){
			ListNode next = curr.next;
			dummy.next = next;
			tail.next = curr;
			tail = tail.next;
			curr.next = null;
			curr = dummy.next;
			count++;
		}
		return dummy.next;
	}
	
	public static void main(String[] args){
		ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
		head.printList();
		System.out.println();
		ListNode res = rotateList(head, 3);
		res.printList();
	}
}

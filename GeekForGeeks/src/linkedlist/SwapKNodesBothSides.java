package linkedlist;

/**
 * http://www.geeksforgeeks.org/swap-kth-node-from-beginning-with-kth-node-from-end-in-a-linked-list/
 * We'll see.
 * Kind of easy piece but conditions are important.
 * @author FengjiaoJiang
 *
 */
public class SwapKNodesBothSides {
	
	
	/*
	 * Conditions:
	 * 1. K is the last one; (reverse list)
	 * 2. Node is the same from both sides;
	 * 3. K is larger than list length;
	 * 4. (from solution) X and Y are next to each other.
	 */
	public static ListNode SwapKNodes(ListNode head, int k){
		if(head == null || head.next == null || k == 0)
			return head;
		
		//First find the Kth Node from the end.
		ListNode slow = head, fast = head, X, Y, previousX = null, previousY = null;
		int count = 1;//of course should be 1
		
		while(fast != null && fast.next != null){
			previousX = slow;
			slow = slow.next;
			fast = fast.next.next;
			count++;
			if(count < k && fast == null){
				System.out.println("K larger than List Length");
				return head;
			}
			
			if(count == k)
				break;
		}
		X = slow;
		count = 0;
		
		slow = head;
		fast = X;
		
		while(fast.next != null){
			previousY = slow;
			slow = slow.next;
			fast = fast.next;
		}
		
		Y = slow; //Now get previousX, previousY, X and Y
		System.out.println(previousX.value + " " + X.value + " " + previousY.value + " " + Y.value);
		if(X == Y)
			return head;
		
		if(X.next == Y){
			X.next = Y.next;
			previousX.next = Y;
			Y.next = X;
		}
		
		else if(Y.next == X){
			Y.next = X.next;
			previousY.next = X;
			X.next = Y;
		}
		
		else{
			ListNode nextX = X.next;
			ListNode nextY = Y.next;
			X.next = nextY;
			Y.next = nextX;
			previousX.next = Y;
			previousY.next = X;
		}
		return head;
	}
	
	public static void main(String[] args){
		ListNode head = new ListNode();
		head.GetSampleList(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
		head = SwapKNodes(head, 3);
		head.PrintList();
	}
}

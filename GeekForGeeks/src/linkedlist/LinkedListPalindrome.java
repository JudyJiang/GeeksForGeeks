package linkedlist;

import java.util.Stack;

public class LinkedListPalindrome {

	public static boolean CheckPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;

		ListNode fast = head, slow = head;
		Stack<ListNode> stack = new Stack<ListNode>();

		if (fast.next.next == null)
			return fast.next.value == fast.value;

		while (fast.next != null && fast.next.next != null) {
			stack.push(slow);
			slow = slow.next;
			fast = fast.next.next;
		}

		// odd fast.next = null, even fast.next.next = null;
		if(fast.next != null && fast.next.next == null)
			stack.push(slow);
		fast = slow.next;

		while (!stack.empty() && fast != null) {
			if (stack.pop().value != fast.value)
				return false;
			fast = fast.next;
		}

		return true;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode();
		head.GetSampleList(new Integer[] { 1, 3, 3, 1});
		
		System.out.println(CheckPalindrome(head));
	}
}

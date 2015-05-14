import utility.*;

//hints: if the two linked lists are intersected, then 
public class IntersectionLinkedList {

	public static int getListLength(ListNode head) {
		if (head == null)
			return 0;

		ListNode curr = head;
		int len = 0;
		while (curr != null) {
			len++;
			curr = curr.next;
		}
		return len;
	}

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;

		ListNode pointA = headA, pointB = headB, point;
		int lenA = getListLength(pointA), lenB = getListLength(pointB);
		ListNode start, compare;
		if (lenA == lenB) {
			start = pointA;
			compare = pointB;
		}

		else {
			int diff = Math.abs(lenA - lenB), count = 0;
			start = lenA > lenB ? pointA : pointB;
			compare = start == pointA ? pointB : pointA;
			while (count < diff) {
				count++;
				start = start.next;
			}
		}

		while (start != null && compare != null) {
			if (start.val == compare.val)
				return start;
			start = start.next;
			compare = compare.next;
		}

		return start;
	}

	public static void main(String[] args) {
		ListNode headA = new ListNode(new int[] { 1, 2, 6, 7, 8, 9, 10 });
		ListNode headB = new ListNode(new int[] { 11, 12, 14, 15, 16, 6, 7, 8,
				9, 10 });
		// 1,3,5,7,9, 11,13,15,17,19,21,23,25,27,29,31,33,35,37,39,41,42
		// 2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,41,42
		headA = new ListNode(new int[] {1,3,5,7,9, 11,13,15,17,19,21,23,25,27,29,31,33,35,37,39,41,42});
		headB = new ListNode(new int[] { 2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,41,42});
		ListNode res = getIntersectionNode(headA, headB);
		res.printList();
	}
}

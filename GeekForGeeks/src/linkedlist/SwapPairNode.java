package linkedlist;

/**
 * Current understanding of LinkedList:
 * The original structure is still there, the node is actually "runner pointer" that moves around 
 * the LinkedList nodes. 
 * @author FengjiaoJiang
 * 
 * 
 * 
 * 1->2->3->4->5->6->null
 *
 */
public class SwapPairNode {
	public static ListNode<String> SwapPairWiseNode(ListNode<String> list){
		if(list == null || list.next == null)
			return list;
		ListNode<String> head = new ListNode<String>();

		ListNode prev = list;
		ListNode curr = list.next;
		head.next = curr;
		
		while(true){
			ListNode next = curr.next;
			curr.next = prev;
			
			if(next == null || next.next == null){
				System.out.println("Empty Now");
				prev.next = next;//without the assignment, prev (in 1,2,3,4,5,6 example) will always point to 5...
				//no end.
				break;
			}
			
			prev.next = next.next;
			prev = next;
			curr = prev.next;
		}
		
		return head.next;
	}
	
	public static void main(String[] args){
		String[] arr = {"one", "two", "three", "four", "five", "six"};
		ListNode<String> list = new ListNode<String>();
		list.GetSampleList(arr);
		list.PrintList();
		ListNode<String> res = SwapPairWiseNode(list);
		res.PrintList();
	}
}

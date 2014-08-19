package linkedlist;

/**
 * Current understanding of LinkedList:
 * The original structure is still there, the node is actually "runner pointer" that moves around 
 * the LinkedList nodes. 
 * @author FengjiaoJiang
 *
 */
public class SwapPairNode {
	public static ListNode<String> SwapPairWiseNode(ListNode<String> list){
		if(list == null || list.next == null)
			return list;
		
		ListNode<String> head = new ListNode<String>();
		head.next = list;
		
		ListNode<String> prev = list;
		ListNode<String> next = list.next;
		
		while(prev != null){
			ListNode<String> temp = prev.next.next;
			prev.next = next.next;
			next.next = prev;
			
			prev = temp;
			next = prev == null ? null : prev.next;
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

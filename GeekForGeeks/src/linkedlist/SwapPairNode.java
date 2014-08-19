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

		while(){
			
		}
		return null;
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

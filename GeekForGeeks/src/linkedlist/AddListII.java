package linkedlist;

/**
 * http://www.geeksforgeeks.org/sum-of-two-linked-lists/
 * Small change.
 * @author FengjiaoJiang
 *
 */
public class AddListII {
	
	public static class NodeWithAddIn{
		public ListNode<Integer> node;
		public int addInValue;
		
		public NodeWithAddIn(){
			
		}
	}
	
	public static ListNode AddList(ListNode<Integer> l1, ListNode<Integer> l2){
		int len1 = l1.GetListLength(), len2 = l2.GetListLength();
		
		if(len1 > len2){
			AppendingList(l2, len1 - len2);
		}
		
		else{
			AppendingList(l1, len2 - len1);
		}
		
		int len = len1 >= len2 ? len1 : len2; // In java you need something to wrap up the "addIn" value
		
		NodeWithAddIn node = new NodeWithAddIn();
		return AddList(l1, l2, node, len, len).node;
	}
	
	public static NodeWithAddIn AddList(ListNode<Integer> l1, ListNode<Integer> l2, NodeWithAddIn node, int len, int count){
		if(l1 == null && l2 == null){
			node.node = null;
			node.addInValue = 0;
			return node;
		}
		ListNode addNode = AddList(l1.next, l2.next, node, len, count - 1).node;
		int value = l1.value + l2.value + node.addInValue;
		ListNode newNode = new ListNode(value % 10);
		newNode.next = addNode;
		node.node = newNode;
		node.addInValue = value / 10;
		
		if(count == len && node.addInValue != 0){
			ListNode addInNode = new ListNode(node.addInValue);
			addInNode.next = node.node;
			node.node = addInNode;
		}
		
		return node;
	}
	
	
	public static ListNode AppendingList(ListNode<Integer> list, int len){
		int count = 0;
		while(count < len){
			ListNode<Integer> node = new ListNode<Integer>(0);
			node.next = list;
			list = node;
			count++;
		}
		return list;
	}
	
	public static void main(String[] args){
		ListNode<Integer> l1 = new ListNode<Integer>(), l2 = new ListNode<Integer>();
		l1.GetSampleList(new Integer[]{5, 6, 3});//(new Integer[]{3, 6, 5});
		l2.GetSampleList(new Integer[]{8, 4, 2});//2, 4, 8});
		
		ListNode head = AddList(l1, l2);
		head.PrintList();
	}
}

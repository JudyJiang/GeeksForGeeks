package linkedlist;

/**
 * http://www.geeksforgeeks.org/delete-a-node-in-a-doubly-linked-list/
 * There's potential problem, if I don't return a head node, how can I delete the first node..
 * @author fengjiaojiang
 *
 */
public class DeleteDoubleListNode {
	
	public static void DeleteDoubleNode(DoubleListNode head, DoubleListNode node){
		if(head == null)
			return;
		
		if(head.next == null && head.value != node.value)
			return;
		
		if(head.value == node.value){
			System.out.println("Here");
			head = head.next;
			head.previous = null;
			return ;
		}
		
		DoubleListNode p = head;
		while(p.next != null){
			if(p.next.value == node.value){
				if(p.next.next == null){
					p.next = null;
					break;
				}
				else{
					DoubleListNode q = p.next.next;
					p.next = q;
					q.previous = p;
					break;
				}
			}
			p = p.next;
		}
	}
	
	
	public static void main(String[] args){
		DoubleListNode head = new DoubleListNode();
		head.GetSampleDoubleList(new int[]{1, 2, 3, 4, 5, 7});
		DeleteDoubleNode(head, new DoubleListNode(1));
		head.PrintList();
	}
}

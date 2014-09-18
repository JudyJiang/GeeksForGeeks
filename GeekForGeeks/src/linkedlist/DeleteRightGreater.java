package linkedlist;


/**
 * http://www.geeksforgeeks.org/delete-nodes-which-have-a-greater-value-on-right-side/
 * @author FengjiaoJiang
 *
 */
public class DeleteRightGreater {
	
	public static ListNode<Integer> DeleteRightOnGreater(ListNode<Integer> head){
		if(head == null || head.next == null)
			return head;
		
		ListNode<Integer> p = head, newHead = new ListNode(), previous = newHead;
		newHead.next = p;
		
		while(p != null && p.next != null){
			if(p.value < p.next.value){
				previous.next = p.next;
				p = previous.next;
			}
			
			else{
				previous = p;
				p = p.next;
			}
		}
		
		return newHead.next;
	}
	
	public static void main(String[] args){
		ListNode<Integer>[] lists = new ListNode[3];
		for(int i = 0; i < 3; i++){
			lists[i] = new ListNode<Integer>();
		}
		
		lists[0].GetSampleList(new Integer[]{12, 15, 10, 11, 5, 6, 2, 3});
		lists[1].GetSampleList(new Integer[]{10, 20, 30, 40, 50, 60});
		lists[2].GetSampleList(new Integer[]{60, 50, 40, 30, 20, 10});
		
		
		for(int i = 0; i < lists.length; i++){
			lists[i] = DeleteRightOnGreater(lists[i]);
			lists[i].PrintList();
			System.out.println();
		}
	}
	
}

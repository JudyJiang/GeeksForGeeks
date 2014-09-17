package linkedlist;

import java.util.HashMap;

public class CopyRandomLink {
	
	static class WildListNode{
		int value;
		WildListNode next;
		WildListNode random;
		
		WildListNode(){
			super();
		}
		
		WildListNode(int value){
			this();
			this.value = value;
		}
	}
	
	
    // 1 -> 2 -> 3 -> 4 -> 5 -> 6
	public static WildListNode GetSampleWildList(){
		WildListNode list = new WildListNode(1);
		WildListNode head = list;
		for(int i = 0; i < 5; i++){
			WildListNode temp = new WildListNode(i + 2);
			list.next = temp;
			list = temp;
		}
		
		head.random = head.next.next;
		head.next.random = head.next.next.next;
		head.next.next.next.random = head.next;
		head.next.next.next.next.random = head.next.next;
		
		return head;
		/*
		 *       1  3
		 *       2  4
		 *       4  2
		 *       5  3
		 */
	}
	
	//This one is support by HashMap
	public static WildListNode CopyWildLinkI(WildListNode head){
		if(head == null)
			return null;
		
		WildListNode newHead = new WildListNode(head.value);
		
		WildListNode p = head;
		WildListNode q = newHead;
		
		HashMap<WildListNode, WildListNode> map = new HashMap<WildListNode, WildListNode>();
		p = p.next;
		
		while(p != null){
			WildListNode temp = new WildListNode(p.value);
			map.put(p, temp);
			q.next = temp;
			q = q.next;
			p = p.next;
		}
		
		p = head;
		q = newHead;
		
		while(p != null){
			if(p.random != null)
				q.random = map.get(p.random);
			else
				q.random = null;
			
			p = p.next;
			q = q.next;
		}
		
		return newHead;
	}
	
	
	/*
	 * Copy each node and insert it between the original node and the next node
	 */
	public static WildListNode CopyWildLinkII(WildListNode head){
		if(head == null)
			return null;
		
		WildListNode p = head;
		
		while(p != null){
			WildListNode temp = new WildListNode(p.value);
			temp.next = p.next;
			p.next = temp;
			p = temp.next;
		}
		
		p = head;
		while(p != null){
			if(p.random != null)
				//p.next.random = p.random;
				//It's not a copy, but a point operation!
				p.next.random = p.random.next;//Cause each node has its "mirror copy" right after itself. So
			//p.random.next it a copy of p.random
			//It's also the reason why this step is not doble in the first "while" loop
			p = p.next.next;
		}
		
		p = head;
		WildListNode newHead = head.next;
		
		while(p != null){
			WildListNode temp = p.next;
			p.next = temp.next;
			temp.next = temp.next == null? null : temp.next.next;
			p = p.next;
		}
		return newHead;
	}
	
	public static void PrintWildList(WildListNode head){
		WildListNode p = head;
		while(p != null){
			System.out.println("Node value " + p.value + " " + (p.random == null ? "Null Value" : p.random.value));
			p = p.next;
		}
	}
	
	public static void main(String[] args){
		WildListNode head1 = CopyWildLinkI(GetSampleWildList());
		WildListNode head2 = CopyWildLinkII(GetSampleWildList());
		//PrintWildList(GetSampleWildList());
		//PrintWildList(head1);
		PrintWildList(head2);
	}
}

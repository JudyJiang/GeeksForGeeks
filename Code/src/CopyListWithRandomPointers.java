
import java.util.*;

/*
 * This is to create a "mirror" between original and copy list
 * node in original list corresponds to node in copy list
 * map contains two lists
 */
public class CopyListWithRandomPointers {
	static class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x){
			this.label = x;
		}
	}
	
	
	public RandomListNode copyRandomList(RandomListNode head) {
		if(head == null)
			return head;
		
		HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode p = head;
		
		while(p != null){
			RandomListNode n = new RandomListNode(p.label);
			map.put(p, n);
			p = p.next;
		}
		
		p = head;
		while(p != null){
			RandomListNode n = map.get(p);
			n.next = p.next == null? null : map.get(p.next);
			n.random = p.random == null ? null : map.get(p.random);
			p = p.next;
		}
		return map.get(head);
	}
	
	//Second solution, create duplicate node for each node's next node and random point
	//this is harder....
	public RandomListNode copyRandomListII(RandomListNode head){
		if(head == null)
			return head;
		RandomListNode p = head;
		while(p != null){
			RandomListNode copy = new RandomListNode(p.label);
			copy.next = p.next;
			p.next = copy;
			p = copy.next;
		}
		
		p = head;
		//attention: here there're already duplicate nodes in the list
		while(p != null){
			if(p.random != null)
				p.next.random = p.random.next; //this is to connect the duplicate of p node's random nodes
			//1->1->2->2->3->3 p at 1, p.next is 1, p.random if 3. then p.random.next also 3. p.next.random is the duplicate
			//1's random connection
			p = p.next.next;
		}
		p = head;
		RandomListNode copy = head.next;//duplicate
		while(p != null){
			RandomListNode tmp = p.next;
			p.next = tmp.next;
			if(tmp.next != null)
				tmp.next = tmp.next.next;
			p = p.next;
		}
		return copy;
	}
	
	public static void main(String[] args){
		
	}
}

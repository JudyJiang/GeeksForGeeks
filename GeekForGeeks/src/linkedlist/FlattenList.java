package linkedlist;


/**
 * http://www.geeksforgeeks.org/flattening-a-linked-list/
 * We'll see
 * My thought is a little different from solution's. 
 * I was thinking keeping all the "heads" with an ArrayList and do the merge.\
 * It's my implementation problem!!!
 * 
 * The solution is recursively merge one and its next list
 * 
 * I guess for this question the most obvious one is: Construct the full list and merge the long list
 * @author FengjiaoJiang
 *
 */
public class FlattenList {
	
	public static class DownList<T extends Comparable<T>>{
		public T value;
		public DownList<T> next;
		public DownList<T> down;
		
		public DownList(){
			super();
			this.next = this.down = null;
		}
		
		public DownList(T value){
			this();
			this.value = value;
		}
		
		//This means, ListNode really should be a parent type
		//that i don't have to rewrite this multiple times
		public void AddNode(T value){
			if(this == null || this.value == null){
				this.value = value;//.value = value;
				this.next = null;
				this.down = null;
				return;
			}
			
			else{
				DownList p = this;
				while(p.next != null)
					p = p.next;
				
				DownList node = new DownList(value);
				p.next = node;
			}
		}
		
		public void GetList(T[] arr){
			for(int i = 0; i < arr.length; i++){
				this.AddNode(arr[i]);
			}
		}
		
		public void PrintDownList(boolean printDown){
			PrintDownList(this, printDown);
		}
		
		public void PrintDownList(DownList<T> head, boolean printDown){
			if(head == null){
				System.out.println("It's a empty list.");
			}
			
			DownList p = head;
			
			while(p != null){
				System.out.print(p.value + " ");
				if(printDown){
					DownList q = p.down;
					while(q != null){
						System.out.print(q.value + " ");
						q = q.next;
					}
				}
				
				System.out.println();
				p = p.next;
			}
		}
	}
	
	public static DownList<Integer> ConstructList(){
		DownList<Integer> head = new DownList<Integer>();
		head.GetList(new Integer[]{5, 10, 19, 28});
		head.down = new DownList();
		head.down.GetList(new Integer[]{7, 8, 30});
		head.next.down = new DownList();
		head.next.down.GetList(new Integer[]{20});
		head.next.next.down = new DownList();
		head.next.next.down.GetList(new Integer[]{22, 50});
		head.next.next.next.down = new DownList();
		head.next.next.next.down.GetList(new Integer[]{35, 40, 45});
		return head;
	}
	
	public static ListNode<Integer> FlatListI(){
		return null;
	}
	
	public static DownList<Integer> FlatListII(DownList<Integer> head){
		if(head == null || head.next == null){
			return head;
		}
		
		//System.out.println(head.value);
		DownList node = FlatListII(head.next);
		//System.out.println(node.value);
		return MergeDownList(head, node);
	}
	
	public static DownList<Integer> MergeDownList(DownList<Integer> d1, DownList<Integer> d2){
		if(d1 == null)
			return d2;
		
		if(d2 == null)
			return d1;
		
		DownList head = new DownList(), p = head;
		boolean turn1 = false, turn2 = d2.down.value == null ? true : false;
		System.out.println("Here d2 " + d2.down.value);
		while(d1 != null && d2 != null){
			if(d1.value <= d2.value){
				p.next = d1;
				d1 = turn1 == false? d1.down : d1.next;//This is due to your implementation. Cause 
				//even though the head is linked with other nodes, the "down" pointer still points to the original one
				turn1 = turn1 == false? true : true;
			}
			
			else{
				p.next = d2;
				d2 = turn2 == false ? d2.down : d2.next;
				turn2 = turn2 == false ? true : true;
			}
			p = p.next;
		}
		
		p.next = d1 == null ? d2 : d1;
		//head.next.PrintDownList(false);
		System.out.println("head down vaue " + head.next.down.value);
		return head.next;//head.next;
	}
	
	public static void main(String[] args){
		DownList head = ConstructList();
		//head.PrintDownList(true);
		head = FlatListII(head);
		head.PrintDownList(false);
		//Don't want to do it, just remember "down" node just "down" node not "down" and "next" mixed together.
	}
}

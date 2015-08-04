package utility;

public class DoubleListNode {
	public int val;
	public DoubleListNode prev;
	public DoubleListNode next;
	
	public DoubleListNode(){
		
	}
	
	public DoubleListNode(int x){
		this.val = x;
		this.prev = this.next = null;
	}
	
	public DoubleListNode(int[] x){
		this.val = x[0];
		DoubleListNode tmp = this;
		for(int i = 1; i < x.length; i++){
			tmp.add(x[i]);
			tmp = tmp.next;
		}
	}
	
	public void add(int x){
		DoubleListNode node = new DoubleListNode(x);
		if(this != null){
			this.next = node;
			node.prev = this;
		}
	}
	
	public int getLength(){
		if(this == null)
			return 0;
		
		DoubleListNode p = this;
		int count = 0;
		while(p != null){
			count++;
			p = p.next;
		}
		return count;
	}
}

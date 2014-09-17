package linkedlist;

public class DoubleListNode <T extends Comparable<T>>extends ListNode{
	public DoubleListNode<T> previous;
	public DoubleListNode<T> next;
	
	public DoubleListNode(){
		super();
	}
	
	public DoubleListNode(T value){
		this.value = value;
	}
	
	public void AddNode(int value){
		if(this == null || this.value == null){
			this.value = value;
			this.previous = this.next = null;
			return ;
		}
		
		DoubleListNode temp = this;
		
		while(temp.next != null){
			temp = temp.next;
		}
		
		DoubleListNode node = new DoubleListNode(value);
		temp.next = node;
		node.previous = temp;
	}
	
	public void PrintList(){
		DoubleListNode head = this;
		while(head != null){
			System.out.print(head.value + " ");
			head = head.next;
		}
	}
	
	public void GetSampleDoubleList(int[] arr){
		for(int i = 0; i < arr.length; i++)
			this.AddNode(arr[i]);
	}
}

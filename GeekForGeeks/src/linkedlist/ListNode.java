package linkedlist;

public class ListNode <T extends Comparable<T>> implements Utility<T>{
	/*The implements Utility<T>, 
	 *the additional "T" is
	 *so important!!! */
	public T value;
	public ListNode<T> next;
	
	public ListNode(){
		super();
		this.next = null;
	}
	
	public ListNode(T value){
		this();
		this.value = value;
		this.next = null;
	}
	
	public void AddNode(T value){
		ListNode node = new ListNode(value);
		node.next = null;
		AddNode(node);
	}
	
	public void AddNode(ListNode node){
		if(this == null || this.value == null){
			this.value = (T)node.value;
			this.next = null;
			return;
		}
		ListNode tempNode = this;
		while(tempNode.next != null){
			tempNode = tempNode.next;
		}
		tempNode.next = node;
		//node.next = null;
	}
	
	
	public ListNode<T> GetTail(){
		if(this.next == null)
			return new ListNode(this.value);
		
		ListNode<T> cursor = this.next;
		while(cursor.next != null){
			cursor = cursor.next;
		}
		return cursor;
	}

	@Override
	public void PrintList() {
		if(this == null){
			System.out.println("Null List");
			return;
		}
		
		ListNode tempNode = this;
		while(tempNode != null){
			System.out.print(tempNode.value + " ");
			tempNode = tempNode.next;
		}
		System.out.println();
	}
	
	public void PrintCircularList(){
		if(this == null){
			System.out.println("Null List");
			return;
		}
		
		ListNode p = this;
		while(p.next != this){
			System.out.print(p.value + " ");
			p = p.next;
		}
		
		System.out.print(p.value);
	}

	@Override
	public void GetSampleList(T[] arr) {
	
		for(int i = 0; i < arr.length; i++){
			this.AddNode((T)arr[i]);
		}
	}
}

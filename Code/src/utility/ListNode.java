package utility;

public class ListNode {
	public int val;
	public ListNode next;
	
	public ListNode(){
		
	}
	
	public ListNode(int x){
		this.val = x;
		this.next = null;
	}
	
	public ListNode(int[] array){
		if(array == null || array.length == 0)
			return ;
		this.val = array[0];
		ListNode head = this;
		for(int i = 1; i < array.length; i++){
			ListNode node = new ListNode(array[i]);
			head.next = node;
			head = head.next;
		}
		head.next = null;
	}
	
	public void add(int x){
		ListNode node = new ListNode(x);
		
		//iterate to tail then add
		//LinkedListNode node = new LinkedListNode(x);
		//this.next = node;
	}
	
	public void printList(){
		ListNode head = this;
		while(head != null){
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
	
	public static void main(String[] args){
		ListNode head = new ListNode(new int[]{1, 2, 3});
		head.printList();
	}
}

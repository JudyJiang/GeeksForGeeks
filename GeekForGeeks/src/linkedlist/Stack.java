package linkedlist;

/**
 * http://www.geeksforgeeks.org/design-a-stack-with-find-middle-operation/
 * Somehow I just feel very happy. Figure out this solution by myeself...
 * Not bad for starter.
 * @author FengjiaoJiang
 * 
 */
public class Stack {
	public int size;
	public int capacity;
	public DoubleListNode<Integer> head;
	public DoubleListNode<Integer> end;
	public DoubleListNode<Integer> middle;

	public Stack() {
		super();
		this.head = this.end = this.middle = null;
		this.size = this.capacity = 0;
	}

	public Stack(int capacity) {
		this();
		this.capacity = capacity;
	}

	public boolean IsEmpty() {
		return this.size == 0;
	}

	public boolean IsFull() {
		return this.size == this.capacity;
	}

	public void Push(int value) throws Exception {
		if (this.IsFull()) {
			throw new Exception("Full Stack");
		}

		if (this.head == null && this.end == null) {
			this.head = this.end = new DoubleListNode<Integer>(value);
			this.head.previous = null;
			this.end.next = null;
			this.head.next = this.end;
			this.end.previous = this.head;
			this.middle = this.head;
			this.size++;
		}

		else {
			DoubleListNode<Integer> node = new DoubleListNode<Integer>(value);
			this.end.next = node;
			node.previous = this.end;
			this.end = this.end.next;
			this.size++;
			if (this.size % 2 != 0) {
				this.middle = this.middle.next;
			}
		}
	}

	public DoubleListNode pop() throws Exception {
		if (IsEmpty()) {
			throw new Exception("Empty Stack");
		}

		DoubleListNode<Integer> node = this.end;
		this.end = this.end.previous;
		if (this.end != null)
			this.end.next = null;
		node.previous = null;
		this.size--;
		if(this.size % 2 == 0)
			this.middle = this.middle.previous;
		return node;
	}

	public DoubleListNode FindMiddle() {
		return this.middle;
	}

	public void DeleteMiddle() throws Exception {
		if (IsEmpty()) {
			throw new Exception("Empty Stack");
		}

		if (this.middle == this.head) {

		}

		DoubleListNode node = this.middle, next = node.next, previous = node.previous;

		if (this.size % 2 == 0)
			this.middle = next;

		else
			this.middle = previous;
		if (previous != null)
			previous.next = next;
		if (next != null)
			next.previous = previous;
		this.size--;
	}

	public static void main(String[] args) throws Exception {
		Stack s = new Stack(5);
		for(int i = 0; i < s.capacity; i++)
			s.Push(i+ 1);
		
		s.DeleteMiddle();
		System.out.println(s.FindMiddle().value);
		
	}
}

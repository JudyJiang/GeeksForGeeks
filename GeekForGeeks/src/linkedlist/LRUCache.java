package linkedlist;


/**
 * http://www.geeksforgeeks.org/implement-lru-cache/
 * We'll see.
 * Pay attention HashMap contains the double list nodes!!! Don't forget to link and de-link them
 * @author FengjiaoJiang
 *
 */
import java.util.HashMap;;

public class LRUCache {
	
	public static class Queue<T extends Comparable<T>>{
		public int size;
		public int capacity;
		DoubleListNode<T> front, rear;
		
		public Queue(int capacity){
			super();
			this.capacity = capacity;
			this.size = 0;
			this.front = this.rear = null;
		}
		
		public boolean IsQueueEmpty(){
			return size == 0;
		}
		
		public boolean IsQueueFull(){
			return size == capacity;
		}
	}
	
	public static HashMap<Integer, DoubleListNode> CreateHash(int size){
		HashMap<Integer, DoubleListNode> map = new HashMap<Integer, DoubleListNode>(size);
		for(int i = 0; i < size; i++)
			map.put(i,  null);
		
		return map;
	}
	
	public static void DeQueue(Queue queue){
		if(queue.IsQueueEmpty())
			return ;
		 /* Remove the rear node
		  * Just from Queue, not from map, cause such thing is still in memory.
		  */
		DoubleListNode deletePage = queue.rear;
		if(queue.front == deletePage)
			queue.front = null;
		
		queue.rear = queue.rear.previous;//deletePage.previous;
		if(queue.rear != null)
			queue.rear.next = null;
		
		queue.size--;
	}
	
	public static void Enqueue(Queue queue, HashMap map, int pageNum){
		if(queue.IsQueueFull()){
			//queue is full, remove the rear
			map.remove(queue.rear.value);
			DeQueue(queue);//making space
		}
		
		DoubleListNode referencePage = new DoubleListNode(pageNum);
		if(queue.IsQueueEmpty())
			queue.front = queue.rear = referencePage;
		
		referencePage.next = queue.front;
		queue.front.previous = referencePage;
		queue.front = referencePage;
		
		queue.size++;
		map.put(pageNum, referencePage);
	}
	
	public static void Reference(Queue queue, HashMap map, int pageNum){
		DoubleListNode reqPage = (DoubleListNode)map.get(pageNum);
		
		if(reqPage == null){
			Enqueue(queue, map, pageNum);
			//the page is not in memory. Add it to memory in both the cash and main memory.
			 //should also add to the hashmap I guess. 
		}
		
		else{
			if(queue.front != reqPage){
				
				reqPage.previous.next = reqPage.next;
				if(reqPage.next != null)
					reqPage.next.previous = reqPage.previous;
				
				if(queue.rear == reqPage){
					queue.rear = reqPage.previous;
					queue.rear.next = null;
				}
				
				reqPage.next = queue.front;
				queue.front.previous = reqPage;
				reqPage.previous = null;
				
				queue.front = reqPage;
			}
		}
		
	}
	
	public static void LRUCacheUtilty(){
		Queue queue = new Queue(4); //Queue serves as the cache
		HashMap map = CreateHash(10);//Hash serves as the staff in memory.
		
		
		Reference(queue, map, 1);
		Reference(queue, map, 2);
		Reference(queue, map, 3);
		Reference(queue, map, 1);
		Reference(queue, map, 4);
		Reference(queue, map, 5);
		/*
		 * Different reference entries
		 */
		
		System.out.println(queue.front.value);
		System.out.println(queue.front.next.value);
		System.out.println(queue.front.next.next.value);
		System.out.println(queue.front.next.next.next.value);
	}
	
	public static void main(String[] args){
		LRUCacheUtilty();
	}
}

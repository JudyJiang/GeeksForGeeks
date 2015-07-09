package careercup;

import java.util.*;

/**
 * So happy, combined iterator!
 * @author FengjiaoJiang
 *
 */
public class CombineIterator {
	
	private LinkedList<Iterator<Integer>> queue;
	
	public CombineIterator(){
		queue = new LinkedList<Iterator<Integer>>();
	}
	
	public CombineIterator(List<List<Integer>> lists){
		this();
		for(List<Integer> list : lists){
			Iterator<Integer> it = list.iterator();
			queue.add(it);
		}
		queue.add(null);
	}
	
	public boolean hasNext(){
		return queue.size() > 1;//queue.size() ==
	}
	
	public List<Integer> next(){
		List<Integer> curr = new LinkedList<Integer>();
		Iterator<Integer> top = queue.removeFirst();
		while(top != null){
			curr.add(top.next());
			if(top.hasNext())
				queue.add(top);
			top = queue.removeFirst();
		}
		queue.add(null);
		return curr;
	}
	
	
	public static void main(String[] args){
		List<Integer> a = new LinkedList<Integer>(Arrays.asList(1, 2, 3));
		List<Integer> b = new LinkedList<Integer>(Arrays.asList(4, 5, 6));
		List<Integer> c = new LinkedList<Integer>(Arrays.asList(7, 8, 9, 10));

		List<List<Integer>> lists = new LinkedList<List<Integer>>();
		lists.add(a);
		lists.add(b);
		lists.add(c);
		CombineIterator combineIterator = new CombineIterator(lists);
		while(combineIterator.hasNext()){
			System.out.println(combineIterator.next().toString());
		}
	}
}

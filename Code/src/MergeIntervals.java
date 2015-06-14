import java.util.*;

/**
 * So happy, one time thing and I think better than before
 * @author FengjiaoJiang
 *
 */
public class MergeIntervals {
	static public class Interval {
		int start;
		int end;
		public Interval(){
			
		}
		
		public Interval(int s, int e){
			start = s;
			end = e;
		}
	}
	
	public static List<Interval> merge(List<Interval> intervals){
		List<Interval> res = new LinkedList<Interval>();
		if(intervals == null || intervals.size() == 0)
			return res;
		
		//good, I still remember to sort the intervals!
		Collections.sort(intervals, new Comparator<Interval>(){
			public int compare(Interval i1, Interval i2){
				if(i1.start < i2.start)
					return -1;
				
				else if(i1.start == i2.start)
					return 0;
				else
					return 1;
			}
		});
		Stack<Interval> stack = new Stack<Interval>();
		int size = intervals.size();
		
		for(int i = 0; i < size; i++){
			Interval curr = intervals.get(i);
			if(stack.isEmpty()){
				stack.push(curr);
			}
			else{
				Interval top = stack.peek();
				if(top.end < curr.start)
					stack.push(curr);
				else if(curr.start >= top.start && curr.end <= top.end)
					continue;
				
				else{
					//System.out.println(curr.start + " " + curr.end);
					Interval newInterval = new Interval(Math.min(curr.start, top.start), Math.max(curr.end, top.end));
					stack.pop();
					stack.push(newInterval);
				}
			}
		}
		res.addAll(stack);
		return res;
	}
	
	public static void main(String[] args){
		List<Interval> list = new LinkedList<Interval>();
		list.add(new Interval(1, 3));
		list.add(new Interval(2, 6));
		list.add(new Interval(8, 10));
		list.add(new Interval(15, 18));
		
		List<Interval> res = merge(list);
		System.out.println(res.size());
		for(Interval inv : res){
			System.out.println(inv.start + " " + inv.end);
		}
	}
}

import java.util.*;

public class InsertInterval {
	static class Interval{
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new LinkedList<Interval>();
//        if(intervals == null || intervals.size() == 0){
//            return res;
//        }
//        
        for(int i = 0; i < intervals.size(); i++){
            Interval inv = intervals.get(i);
            if(inv.end < newInterval.start){
                res.add(inv);
            }
            else if(inv.start > newInterval.end){
                res.add(newInterval);
                newInterval = inv;
            }
            else{
                int newStart = Math.min(inv.start, newInterval.start);
                int newEnd = Math.max(inv.end, newInterval.end);
                newInterval = new Interval(newStart, newEnd);
            }
        }
        System.out.println("here");
        res.add(newInterval);
        return res;
    }
	
	public static void main(String[] args){
		List<Interval> intervals = new LinkedList<Interval>();
		List<Interval> res = insert(intervals, new Interval(5, 7));
		for(Interval i : res){
			System.out.println(i.start + " " + i.end);
		}
	}
}

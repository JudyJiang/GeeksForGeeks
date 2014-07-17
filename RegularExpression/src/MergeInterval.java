import java.util.*;

public class MergeInterval {
	public static ArrayList<InsertInterval.Interval> 
	mergeIntervals(ArrayList<InsertInterval.Interval> interval){
		
		ArrayList<InsertInterval.Interval> res = new ArrayList<InsertInterval.Interval>();
		
		if(interval == null || interval.size() == 0)
			return res;
		
		Comparator<InsertInterval.Interval> compare = new Comparator<InsertInterval.Interval>(){
			public int compare(InsertInterval.Interval a, InsertInterval.Interval b){
				if(a.start == b.start && a.end == b.end)
					return 0;
				
				else if(a.start < b.start)
					return -1;
				
				else 
					return 1;
			}
		};
		
		Collections.sort(interval, compare);
		mergeInterval(interval, res);
		InsertInterval.printInterval(res);
		return res;
	}
	
	public static void mergeInterval(
			ArrayList<InsertInterval.Interval> interval, ArrayList<InsertInterval.Interval> res){
		res.add(interval.get(0));
		
		for(int i = 1; i < interval.size(); i++){
			InsertInterval.Interval temp = res.get(res.size() - 1);
			InsertInterval.Interval compare = interval.get(i);
			
			if(temp.end < compare.start){
				res.add(compare);
			}
			
			else{
				int newStart = Math.min(temp.start, compare.start);
				int newEnd = Math.max(temp.end, compare.end);
				
				InsertInterval.Interval newInterval = new InsertInterval.Interval(newStart, newEnd);
				res.remove(res.size() - 1);
				res.add(newInterval);
			}
		}
	}
	
	public static void main(String[] args){
		int[][] range = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
		ArrayList<InsertInterval.Interval> interval = InsertInterval.getInterval(range);
		mergeIntervals(interval);
	}
	
}

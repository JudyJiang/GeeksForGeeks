import java.util.*;

/**
 * TODO:
 * 1. Interval within random range;
 * 2. Sort Interval;
 * 3. Shrink / Increase Array size;
 * @author FengjiaoJiang
 *
 */
public class InsertInterval {
	static class Interval{
		public int start;
		public int end;
		
		public Interval(){
			this.start = Integer.MIN_VALUE;
			this.end = Integer.MAX_VALUE;
		}
		
		public Interval(int start, int end){
			this.start = start;
			this.end = end;
		}
		
		
		/*
		 * TODO: Write function to generate intervals within different ranges.
		 */
		public static ArrayList<Interval> getRandomInterval(int size){
			
			return null;
		}
		
		
		/*
		 * TODO: Write function to sort intervals
		 */
		public static void sortInterval(Interval[] interval){
			
		}
	}//end of sub class
	
	
	public static ArrayList<Interval> getInterval(int[][] ranges){
		ArrayList<Interval> interval = new ArrayList<Interval>();
		for(int i = 0; i < ranges.length; i++){
			interval.add(new Interval(ranges[i][0], ranges[i][1]));
		}
		
		return interval;
	}
	
	public static void printInterval(ArrayList<Interval> interval){
		for(int i = 0; i < interval.size(); i++)
			System.out.print(interval.get(i).start + " " + interval.get(i).end + "\n");
	}
	
	
	public static ArrayList<Interval> mergeIntervals(ArrayList<Interval> interval, Interval newInterval){
		if(newInterval == null)
			return interval;
		
		if(interval == null || interval.size() == 0)
			//I LIKE THIS LINE!
			return new ArrayList<Interval>(Arrays.asList(newInterval));
		
		ArrayList<Interval> mergedInterval = new ArrayList<Interval>();
		
		for(int i = 0; i < interval.size(); i++){
			if(newInterval.end < interval.get(i).start){
				mergedInterval.add(newInterval);
				for(int j = i; j < interval.size(); j++){
					mergedInterval.add(interval.get(j));
				}
				//System.out.println("Should be here: " + interval.get(i).start + " " + interval.get(i).end);
				return mergedInterval;
			}
			
			else if(newInterval.start > interval.get(i).end){
				mergedInterval.add(interval.get(i));
				if(i == interval.size() - 1)
					mergedInterval.add(newInterval);
			}
			
			else{
				newInterval.start = Math.min(interval.get(i).start, newInterval.start);
				newInterval.end = Math.max(interval.get(i).end, newInterval.end);
			}
		}
		
		return mergedInterval;
	}
	
	
	public static void mergeInterval(){
		int[][] ranges = {{0, 1}, {3, 6}, {7, 8}, {11, 19}, {24, 56}};
		ArrayList<Interval> interval = getInterval(ranges);
		Interval newInterval = new Interval(72, 78);
		ArrayList<Interval> mergedInterval = mergeIntervals(interval, newInterval);
		printInterval(mergedInterval);
		
	}
	
	
	
	public static void main(String[] args){
		mergeInterval();
	}
}

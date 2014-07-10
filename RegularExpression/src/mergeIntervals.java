//import java.util.*;

public class mergeIntervals {
	
	public static class Interval{
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
		
		public static Interval[] constructRandomIntervals(int size){
			Interval[] intervals = new Interval[size];
			int number1, number2, count = 0;
			
			while(count < size){
				number1 = (int)(Math.random() * 1000 % 23);
				number2 = (int)(Math.random() * 1000 % 17);
				if(number1 == number2)
					continue;
				
				else{
					intervals[count] = number1 > number2 ? new Interval(number2, number1) : new Interval(number1, number2);
					count++;
				}
			}
			return intervals;
		}
	}
	
	public static Interval[] getIntervals(){
		Interval[] intervals = Interval.constructRandomIntervals(7);
		System.out.println(intervals.length);
		return intervals;
	}
	
	public static void printIntervals(Interval[] intervals){
		for(int i = 0; i < intervals.length; i++){
			System.out.print(intervals[i].start + " " + intervals[i].end + "\n");
		}
	}
	
	public static void mergeIntervals(Interval[] intervals, Interval val){
		if(intervals == null || intervals.length == 0){
			intervals = new Interval[]{val};
			return ;
		}
		
		if(val == null)
			return ;
		//Interval[] result = 
		for(int i = 0; i < intervals.length; i++){
			//1. val.end < i.start
			//2. val.start > i.end;
			//3. intervene
		}
	}
	
	public static void mergeIntervals(int size, int start, int end){
		Interval[] intervals = Interval.constructRandomIntervals(size);
		Interval newInterval = new Interval(start, end);
		
		mergeIntervals(intervals, newInterval);
	}
	
	public static void main(String[] args){
		getIntervals();
		//System.out.println((int)(Math.random() * 1000 % 23));
	}
	
}

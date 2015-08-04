package careercup;
import java.util.*;

public class NumberFrequency {
	static class ValueComparator implements Comparator{
		Map map;
		
		public ValueComparator(Map map){
			this.map = map;
		}
		@Override
		public int compare(Object o1, Object o2) {
			Comparable value1 = (Comparable)map.get(o1);
			Comparable value2 = (Comparable)map.get(o2);
			if(value1.compareTo(value2) >= 0)
				return -1;
			else
				return 1;
		}
	}
	
	public static void numberFreqI(int[] nums, int n){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++){
			if(!map.containsKey(nums[i]))
				map.put(nums[i], 1);
			else
				map.put(nums[i], map.get(nums[i]) + 1);
		}
		
		
		Map sortedMap = new TreeMap(new ValueComparator(map));
		sortedMap.putAll(map);
		Iterator it = sortedMap.entrySet().iterator();
		while(it.hasNext() && n != 0){
			System.out.println(it.next());
			n--;
		}
	}
	
	public static void numberFreqII(int[] nums, int n){
		Arrays.sort(nums);
		//Go through the sorted 
	}
	
	public static void numberFreqIII(int[] nums, int n){
		//Binary Search Tree node value and freq field
	}
	
	static class FreqNode{
		int value;
		int freq;
		
		public FreqNode(int v, int f){
			this.value = v;
			this.freq = f;
		}
	}
	public static void numberFreqIV(int[] nums, int n){
		//Good about the tree and heap solution is
		//They don't require to read all the whole data into memory
		//the data inside the array can come as a stream of data.
		PriorityQueue<FreqNode> q = new PriorityQueue<FreqNode>(new Comparator<FreqNode>(){

			@Override
			public int compare(FreqNode o1, FreqNode o2) {
				if(o1.value >= o2.value)
					return -1;
				else
					return 1;
			//	return 0;return 0 will merge the key
			}
			
		});
		
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++){
			if(!map.containsKey(nums[i]))
				map.put(nums[i], 1);
			else
				map.put(nums[i], map.get(nums[i]) + 1);
		}
	}

	
	public static void main(String[] args){
		
	}	
}

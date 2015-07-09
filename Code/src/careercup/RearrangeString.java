package careercup;

import java.util.*;

public class RearrangeString {
//http://stackoverflow.com/questions/1448369/how-to-sort-a-treemap-based-on-its-values
	static class ValueComparator implements Comparator {
		Map map;
		
		public ValueComparator(Map map){
			this.map = map;
		}
		
		@Override
		public int compare(Object o1, Object o2) {
			Comparable valueA = (Comparable) map.get(o1);
			Comparable valueB = (Comparable) map.get(o2);
			return -valueA.compareTo(valueB);
		}
		
	}
	public static String rearrange(String s){
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(Character c : s.toCharArray()){
			if(map.containsKey(c))
				map.put(c, map.get(c) + 1);
			else
				map.put(c,  1);
		}
		
		TreeMap<Character,Integer> sortedMap = new TreeMap<Character, Integer>(new ValueComparator(map));
		sortedMap.putAll(map);
		Iterator it = sortedMap.entrySet().iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		return "";
	}
	 
	
	public static void main(String[] args){
		String s = "AAAAAAAAABBBBCCDDDDDEFFFF";
		rearrange(s);
	}
}

package careercup;

import java.util.*;
import java.util.Map.Entry;


public class RearrangeString {
//http://stackoverflow.com/questions/1448369/how-to-sort-a-treemap-based-on-its-values
	static class ValueComparator implements Comparator {
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
	public static String rearrange(String s){
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(char c : s.toCharArray()){
			if(!map.containsKey(c))
				map.put(c, 1);
			else
				map.put(c, map.get(c) + 1);
		}
		
		Map sortedMap = null;// new TreeMap(new ValueCompare(map));
		sortedMap.putAll(map);
		int count = 0;
		StringBuilder sb = new StringBuilder();
		while(sortedMap.size() != 0){

			Iterator it = sortedMap.entrySet().iterator();
			while(it.hasNext()){
				Entry<Character, Integer> curr = (Entry<Character, Integer>) it.next();
				char key = curr.getKey();
				int value = curr.getValue();
				sb.append(key);
				if(value - 1 == 0)
					it.remove();
				curr.setValue(value - 1);
			}
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
	 
}

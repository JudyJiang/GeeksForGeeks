package utility;

import java.util.*;

public class Test {
	public static int RomanToInteger(String s){
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I',  1);
		map.put('V', 5);
		map.put('X',  10);
		map.put('L',  50);
		map.put('C',  100);
		map.put('D', 500);
		map.put('M',  1000);
		
		char[] tmp = s.toCharArray();
		int res = 0;
		for(int i = 0; i < s.length() - 1; i++){
			if(map.containsKey(tmp[i + 1]) && map.containsKey(tmp[i]) &&
					map.get(tmp[i + 1]) <=  map.get(tmp[i])){
				res += map.get(tmp[i]);
			}
			
			else{
				res -= map.get(tmp[i]);
			}
		}
		
		res += map.get(tmp[s.length() - 1]);
		return res;
	}

	
	public static void main(String[] args){
		int res = RomanToInteger("DCXXI");
		Queue q = new PriorityQueue<Integer>();
		q.add(1);
		q.add(2);
		
		System.out.println(res);
	}
}

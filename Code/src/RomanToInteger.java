import java.util.*;

public class RomanToInteger {
	public static int romanToInt(String s){
		if(s == null || s.length() == 0)
			return 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
		char[] sChar = s.toCharArray();
		int value =map.get(sChar[sChar.length - 1]);
		int last = value;
		for(int i = sChar.length - 2; i >= 0; i--){
			char curr = sChar[i];
			int currValue = map.get(curr);
			
			if(currValue >= last){
				value += currValue;
			}
			else{
				value -= currValue;
			}
			last = currValue;
		}
		return value;
	}
	
	public static void main(String[] args){
		String s = "MMMCMLXXXVII";
		System.out.println(romanToInt(s));
	}
}

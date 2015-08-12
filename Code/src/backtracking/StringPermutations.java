package backtracking;


import java.util.*;

public class StringPermutations {
	
	public static List<String> allPermutations(String s){
		if(s.length() == 1){
			List<String> res = new LinkedList<String>();
			res.add(s);
			return res;
		}
		
		char first = s.charAt(0);
		List<String> prev = allPermutations(s.substring(1));
		List<String> res = new LinkedList<String>();
		
		for(String substr : prev){
			for(int i = 0; i <= substr.length(); i++){
				String tmpStr = insert(first, substr, i);
				res.add(tmpStr);
			}
		}
		return res;
	}
	
	public static String insert(char c, String s, int index){
		String first = s.substring(0,index);
		String second = s.substring(index);
		return first + String.valueOf(c) + second;
	}
	
	public static void main(String[] args){
		String s = "ABC";
		List<String> res = allPermutations(s);
		System.out.println(res.size());
		for(String str : res)
			System.out.println(str);
	}
}

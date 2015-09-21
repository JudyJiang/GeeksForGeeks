package careercup;


import java.util.*;

public class AllStrings {
	public static List<String> allStrings(String pattern){
		List<String> res = new LinkedList<String>();
		allStrings(pattern, res, 0, "");
		return res;
	}
	
	public static void allStrings(String pattern, List<String> res, int index, String tmpStr){
		if(index >= pattern.length()){
			String copy = new String(tmpStr);
			res.add(copy);
			return;
		}
		
		char c = pattern.charAt(index);
		if(c != '?'){
			tmpStr += String.valueOf(c);
			allStrings(pattern, res, index + 1, tmpStr);
		}
		else{
			allStrings(pattern, res, index + 1, tmpStr + "1");
			allStrings(pattern, res, index + 1, tmpStr + "0");
		}
	}
	
	public static void main(String[] args){
		String pattern = "1?00?101";
		List<String> res = allStrings(pattern);
		System.out.println(res.size());
		for(String s : res)
			System.out.println(s);
		StringBuilder sb = new StringBuilder();
		
	}
}

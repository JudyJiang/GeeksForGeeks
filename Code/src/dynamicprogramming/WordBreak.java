package dynamicprogramming;

import java.util.*;

public class WordBreak {
	public static boolean breakWords(Set<String> dict, String s){
		return canBreak(dict, s, 0);
	}
	
	public static boolean canBreak(Set<String> dict, String s, int index){
		if(index >= s.length())
			return true;
		
		for(int i = index; i < s.length(); i++){
			String subStr = s.substring(index, i + 1);
			if(dict.contains(subStr))
				if(canBreak(dict, s, i + 1))
					return true;
		}
		return false;
	}//worse case, if the dictionary contains many similar cases and
	//for each character it has to go down
	public static boolean dpBreakWords(Set<String> dict, String s){
		if(dict == null || dict.size() == 0){
			return false;
		}
		
		if(s == null || s.length() == 0)
			return false;
		
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for(int i = 1; i <= s.length(); i++){
			if(dict.contains(s.substring(0, i)))
				dp[i] = true;
			else{
				for(int j = 0; j < i; j++)
					if(dp[j] && dict.contains(s.substring(j, i)))
						dp[i] = true;
			}
		}
		return dp[s.length()];
	}
	
	public static List<String> breakWordsII(Set<String> dict, String s){
		List<String> res = new LinkedList<String>();
		if(dict == null || dict.size() == 0 || s == null || s.length() == 0)
			return res;
		if(!breakWords(dict, s))
			return res;
		breakWordsII(dict, s, "", 0, res);
		return res;
	}
	
	public static void breakWordsII(Set<String> dict, String s, String tmp, int index, List<String> res){
		if(index >= s.length()){ //tmp.length() will be larger than s.length() cause the " " 
			String copy = tmp;
			res.add(copy);
			return;
		}
		
		if(!tmp.equals(""))
			tmp += " ";
		for(int i = index; i < s.length(); i++){
			String subStr = s.substring(index, i + 1);
			if(dict.contains(subStr)){
				breakWordsII(dict, s, tmp+subStr, i + 1, res);
			}
		}
	}
	
	public static void main(String[] args){
		String s= "catsanddog";
		Set<String> set = new HashSet<String>();
		set.add("cat");
		set.add("cats");
		set.add("and");
		set.add("sand");
		set.add("dog");
		List<String> res = breakWordsII(set, s);
		System.out.println(res.size());
		for(String str : res)
			System.out.println(str);
	}
}

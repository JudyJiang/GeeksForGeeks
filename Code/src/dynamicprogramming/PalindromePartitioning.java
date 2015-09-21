package dynamicprogramming;

import java.util.*;

public class PalindromePartitioning {
	public static List<List<String>> partition(String s){
		List<List<String>> res = new LinkedList<List<String>>();
		if(s == null || s.length() == 0)
			return res;
		List<String> list = new LinkedList<String>();
		partition(s, res, list, 0);
		return res;
	}
	
	public static void partition(String s, List<List<String>> res, List<String> list, int index){
		if(index >= s.length()){
			List<String> copy = new LinkedList<String>();
			copy.addAll(list);
			res.add(copy);
			return;
		}
		for(int i = index; i < s.length(); i++){
			String sub = s.substring(index,  i + 1);
			if(isPalindrome(sub)){
				list.add(sub);
				partition(s, res, list, index + 1);
				list.remove(sub);
			}
		}
	}
	
	public static boolean isPalindrome(String s){
		int i = 0, j = s.length() - 1;
		while(i <= j){
			if(s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
	
	
	public static List<String> dpPartition(String s){
		List<String> res = new LinkedList<String>();
		int[][] dp = new int[s.length()][s.length()];
		
		for(int len = 1; len <= s.length(); len++){
			for(int i = 0; i < s.length(); i++){
				int j = i + len - 1;
				if(s.charAt(i) == s.charAt(j)){
					if(len == 1 || len == 2)//single word or continuous two same word 
						dp[i][j] = 1;
					else
						dp[i][j] = dp[i+1][j-1]; //if feel unsafe, can assign dp[i][i] = 1 and dp[i][i+1] = 1
					//if s[i] == s[i+1];
					if(dp[i][j] == 1)
						res.add(s.substring(i, j + 1));
				}
				else
					dp[i][j] = 0;
			}
		}
		return res;//since its palindrome, it's better to set length instead of using a "j=0, j < .."
		//palindrom is bettern to start from the left and right end in parallel.
	}
	
	
	public static int minCutPalindrome(String s){
		int n = s.length();
		boolean[][] dp = new boolean[n][n];
		int[] cut = new int[n];
		
		for(int i = 0; i < n; i++){
			cut[i] = i;//set largest cut for palindrome;
			for(int j = 0; j <= i; j++){
				if(s.charAt(i) == s.charAt(j) && (j - 1 <= 1 || dp[i+1][j-1])){
					//substring i ~ j is 
					dp[i][j] = true;
					if(i > 0)
						cut[j] = Math.min(cut[j], cut[i-1] + 1);
					else
						cut[j] = 0;// 0 ~ i is palindrome, not cut needed.
					//This is important
				}
			}
		}
		return cut[n - 1];//if use the previously len.
		//it's not "cut[j]" but cut[i+len-1]..well, stil cut j
	}
}

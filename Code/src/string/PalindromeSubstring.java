package string;

import java.util.*;

/**
 * Love myself again...
 * @author FengjiaoJiang
 *
 */
public class PalindromeSubstring {
	public static List<String> palindromeSubstrings(String s){
		List<String> res = new LinkedList<String>();
		Set<String> set = new HashSet<String>();
		int n = s.length();
		boolean[][] dp = new boolean[n][n];
		for(int i = 0; i < n; i++){
			dp[i][i] = true;
			set.add(String.valueOf(s.charAt(i)));
		}
		for(int L = 2; L <= n; L++){
			for(int i = 0; i <= n - L; i++){
				int j = i + L - 1;
				if(L == 2)
					dp[i][j] = s.charAt(i) == s.charAt(j);
				else{
					dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i+1][j-1];
				}
				
				if(dp[i][j]){
					set.add(s.substring(i, j + 1));
				}
			}
		}
		
		res.addAll(set);
		return res;
	}
	
	public static void main(String[] args){
		String s = "geek";
		List<String> res = palindromeSubstrings(s);
		System.out.println(res.size());
		for(String str : res)
			System.out.println(str);
	}
}

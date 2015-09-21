package dynamicprogramming;


import java.util.HashSet;

public class AllPossiblePalindromes {
	public static void allPalindrome(String s){
		if(s == null || s.length() == 0){
			return;
		}
		
		int n = s.length();
		
		boolean[][] dp = new boolean[n][n];
		for(int i = 0; i < n; i++){
			dp[i][i] = true;
			System.out.println(s.charAt(i));
		}
		
		for(int len = 2; len <= n; len++){
			for(int i = 0; i < n - len + 1; i++){
				int j = i + len - 1;
				if(s.charAt(i) == s.charAt(j) && (len == 2 || dp[i + 1][j-1])){
					dp[i][j] = true;
					System.out.println(s.substring(i, j + 1));
				}
			}
		}
	}
	
	public static void main(String[] args){
		String s = "nitin";
		allPalindrome(s);
	}
}

package dynamicprogramming;

public class LongestRepeatingSubsequence {
	public static int longestRepeatingSubsequence(String s){
		if(s == null || s.length() == 0){
			return 0;
		}
		
		int n = s.length();
		int[][] dp = new int[n + 1][n + 1];
		
		for(int i = 0; i <= n; i++){
			for(int j = 0; j <= n; j++){
				if(i == j){
					dp[i][j] = 0;
				}
				
				else{
					if(s.charAt(i) == s.charAt(j)){
						dp[i][j] = 1 + dp[i-1][j-1];
					}
					else
						dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[n][n];
	}
}

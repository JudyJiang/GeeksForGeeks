package string;

public class LongestEvenSum {
	public static int longestEvenSum(String s){
		int max = 0;
		int n = s.length();
		int[][] dp = new int[n][n];
		for(int i = 0; i < n; i++)
			dp[i][i] = Integer.valueOf(s.charAt(i));
		
		for(int L = 2; L <= n; L++){
			for(int i = 0; i < n - L; i++){
				int j = i + L - 1;
				int k = L / 2;
				dp[i][j] = dp[i][j-k] + dp[j-k+1][j];
				if(L % 2 == 0 && dp[i][j-k] == dp[j-k+1][j] && dp[i][j] > max)
					max = dp[i][j];
			}
		}
		return max;
	}
}

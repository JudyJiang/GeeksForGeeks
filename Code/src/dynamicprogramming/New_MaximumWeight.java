package dynamicprogramming;

import java.util.Arrays;

/**
 * This is good. not too hard but also requires both recursive and dp;
 * @author FengjiaoJiang
 *
 */
public class New_MaximumWeight {
	
	public static int getMaxWeight(String s){
		if(s == null || s.length() == 0){
			return 0;
		}
		
		int[] dp = new int[s.length()];
		Arrays.fill(dp, -1);
		getMaxWeight(s, dp, 0, s.length());
		return dp[s.length() - 1];
	}
	
	public static int getMaxWeight(String s, int[] dp, int index, int n){
		if(index >= n){
			return 0;
		}
		
		if(dp[index] != -1)
			return dp[index];
		
		//no pair
		int res = 1 + getMaxWeight(s, dp, index + 1, n);
		
		if(index + 1 < n){
			if(s.charAt(index) != s.charAt(index + 1)){
				res = Math.max(res, 4 + getMaxWeight(s, dp, index + 2, n));
			}
			else{
				res = Math.max(res, 3 + getMaxWeight(s, dp, index + 2, n));
			}
		}
		
		dp[index] = res;
		return res;
	}
}

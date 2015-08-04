package tree;

public class DigitsDecode {
	public static int countWays(int[] arr){
		return countWays(arr, arr.length);
	}
	
	public static int countWays(int[] arr, int n){
		if(n == 0 || n == 1)
			return 1;
		
		int count = 0;
		if(arr[n - 1] > 0)
			count += countWays(arr, n - 1);
		
		if(arr[n-2] < 2 || (arr[n-2] == 2 && arr[n-1] < 7))
			count += countWays(arr, n - 2);
		
		return count;
	}
	
	public static int countWaysDP(int[] arr){
		int n = arr.length;
		int[] dp = new int[n + 1];
		dp[0] = dp[1] = 1;
		for(int i = 2; i <= n; i++){
			if(arr[i-1] > 0)
				dp[i] = dp[i-1];
			if(arr[i-2] < 2 || (arr[i-2] == 2 && arr[i-1] < 7))
				dp[i] += dp[i-2];
		}
		return dp[n];
	}
}

/**
 * This is easy and I only have one problem left for tomorrow.
 * @author FengjiaoJiang
 *
 */
public class MinimumPathSum {
	public static int minPathSum(int[][] grid){
		if(grid == null || grid.length == 0 || grid[0].length == 0)
			return Integer.MAX_VALUE;
		
		int m = grid.length, n = grid[0].length;
		int[][] dp = new int[m][n];
		dp[0][0] = grid[0][0];
		for(int i = 1; i < m; i++){
			dp[i][0] = dp[i-1][0] + grid[i][0];
		}
		
		for(int j = 1; j < n; j++){
			dp[0][j] = dp[0][j-1] + grid[0][j];
		}
		
		for(int i = 1; i < m; i++){
			for(int j = 1; j < n; j++){
				dp[i][j] = Math.min(dp[i-1][j],  dp[i][j-1]) + grid[i][j];
			}
		}
		return dp[m-1][n-1];
	}
}

package PayAttention;

/*
 * http://zwzbill8.blogspot.com.br/2015/05/leetcode-house-robber-ii.html
 */
public class HouseRobberII {
	//Similar to house robber I but consider the "first house, not last house
	//or not first house but last house.
	public static int rob(int[] nums){
		if(nums == null || nums.length == 0)
			return 0;
		
		int n = nums.length;
		if(n == 1)
			return nums[0];
		
		if(n == 2)
			return Math.max(nums[0], nums[1]);
		//first house is included.
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = nums[0]; 
		/*consider house 1 can't consider house n. 
		 *this is sub-case of "House Robber I" from 1 ~ n - 1
		 *house 1 is considered, then can't <= 'n'. thus it's computed largest value until 'n'.
		 *Also in "house robber I" there's <= n because house n can be computed. 
		 */
		for(int i = 2;i < n; i++){
			dp[i] = Math.max(dp[i - 1],  dp[i - 2] + nums[i - 1]);
		}//this actually computes the maximum value before 'i'
		//cause there's dp[1] = nums[0] .... dp[index] is 1 larger than actual nums[index]..?
		
		//first house not included
		int[] dr = new int[n + 1];
		dr[0] = 0;
		dr[1] = nums[1]; //from 2 ~ n
	
		for(int i = 2; i < n; i++){//this actually compute the 'n-1'. largest value at 'n-1'.so.. one house not included. can'be <= n
			dr[i] = Math.max(dr[i - 1], dr[i - 1] + nums[i]);
		}
		return Math.max(dp[n - 1], dr[n - 1]);
	}
	public static void main(String[] args){
		
	}
}

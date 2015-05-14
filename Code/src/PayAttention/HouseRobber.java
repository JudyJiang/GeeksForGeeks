package PayAttention;
//Not Solved By Myself....
/*
 * The formula
 * dp[i] = Max(dp[i-1], dp[i-2]+arr[i-1])
 * Meaning, when at house "i", the maximum amount of money has been collected so far is either by
 * 1. (take previous money "arr[i-1]") dp[i-1]+arr[i-1]
 * 2. not taken but just dp[i-1]
 */

public class HouseRobber {
	
	public static int houseRobberI(int[] arr){
		if(arr.length <= 1){
			return arr.length == 0? 0 : arr[0];
		}
		
		int[] res = new int[arr.length + 1];
		
		res[0] = res[1] = 0; //the 0th house no money, also whey res.length = arr.length + 1
		for(int i = 2; i <= arr.length; i++){
			res[i] = Math.max(res[i-1], res[i-2]+arr[i-1]);
		}
		return res[arr.length];
	}
	
	
	public static int houseRobberII(int[] nums){
		//hard to think of, but easy to understand
		if(nums.length <= 1){
			return nums.length == 0? 0 : nums[0];
		}
		
		int even = 0, odd = 0;
		for(int i = 0; i < nums.length; i++){
			if(i % 2 == 0){
				even += nums[i];
				even = even > odd? even : odd;
			}
			else{
				odd += nums[i];
				odd = odd > even? odd : even;
			}
		}
		return Math.max(odd, even);
	}
	
	public static void main(String[] args){
		int[] arr = {1, 4, 3, 7, 2, 5, 6};
		int res = houseRobberII(arr);
		System.out.println(res);
	}
}

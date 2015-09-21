package dynamicprogramming;

public class FindPartition {
	public static boolean partition(int[] nums){
		int sum = 0, size = nums.length;
		for(int i = 0; i < size; i++){
			sum += nums[i];
		}
		
		if(sum % 2 != 0)
			return false;
		
		boolean[][] sums = new boolean[sum/2+1][size+1];
		for(int i = 0; i <= size; i++)
			sums[0][i] = true;
		for(int i = 1; i <= sum/2; i++)
			sums[i][0] = false;
		
		for(int i = 0; i <= sum/2; i++){
			for(int j = 0; j <= size; j++){
				sums[i][j] = sums[i][j-1];
				if(i >= nums[j - 1]){
					//the sum[i-nums[j-1]][j-1] is:
					/*
					 * current number is: nums[j-1];
					 * previous sum i - nums[j-1] but add to current number that eauals to i
					 * 
					 */
					sums[i][j] = sums[i][j] || sums[i-nums[j - 1]][j - 1];
				}
			}
		}
		
		return sums[sum/2][size];
	}
}

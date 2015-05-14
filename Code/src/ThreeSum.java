import java.util.*;

public class ThreeSum {
	public static List<List<Integer>> threeSum(int[] nums){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums == null || nums.length == 0)
			return res;
		
		Arrays.sort(nums);
		for(int i = 0; i < nums.length; i++){
			if(i == 0 || nums[i] != nums[i-1]){
				int j = i+1, k = nums.length - 1;
				while(j<k){
					int tmp = nums[i] + nums[j] + nums[k];
					if(tmp > 0)
						k--;
					else if(tmp < 0)
						j++;
					else{
						List<Integer> list = new ArrayList<Integer>();
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[k]);
						res.add(list);
						j++;
						k--;
						while(j<k && nums[j] == nums[j-1])
							j++;
						while(j<k && nums[k] == nums[k+1])
							k--;
					}
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args){
		
	}
}

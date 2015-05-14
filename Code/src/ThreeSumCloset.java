import java.util.Arrays;

//Pay attention to the "target negative, if set res to MAX_INTEGER there's overflow problem"
public class ThreeSumCloset {
	public static int threeSumClosest(int[] nums, int target){
		if(nums == null || nums.length == 0)
			return Integer.MAX_VALUE;
		Arrays.sort(nums);
		int res = Integer.MAX_VALUE, left, right, size = nums.length;
		for(int i = 0; i <= size - 3; i++){
			left = i+1;
			right = size - 1;
			while(left < right){
				int tmpSum = nums[i] + nums[left] + nums[right];
				if(res == Integer.MAX_VALUE){
					res = tmpSum;
					continue;
				}
				if(tmpSum == target)
					return target;
				if(Math.abs(tmpSum - target) < Math.abs(res - target))
					res = tmpSum;
				if(tmpSum > target)
					right--;
				if(tmpSum < target)
					left++;
			}
		}
		return res;
	}
	
	public static void main(String[] args){
		int[] nums = {-3, -2, -5, 3, -4};
		int target = -1;
		System.out.println(threeSumClosest(nums, target));
	}
}

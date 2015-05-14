import java.util.*;

public class MajorityElement {
	public static int majorityElement(int[] nums){
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}
	public static void main(String[] args){
		int[] num = {3, 1, 3, 5, 67, 1, 2};
		Arrays.sort(num);
		for(int i = 0; i < num.length; i++)
			System.out.print(num[i] + " ");
	}
}

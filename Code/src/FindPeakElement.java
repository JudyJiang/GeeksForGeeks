
public class FindPeakElement {
	public static int findPeakElement(int[] nums){
		int len = nums.length, prev, last;
		for(int i = 0; i < len; i++){
			if(i == 0)
				prev = Integer.MIN_VALUE;
			else
				prev = nums[i - 1];
			if(i == len - 1)
				last = Integer.MIN_VALUE;
			else
				last = nums[i + 1];
			int curr = nums[i];
			if(curr >= prev && curr >= last)
				return i;			
		}
		return -1;
	}
	
	public static void main(String[] args){
		int[] nums = {1, 2, 3, 1};
		int[] numsI = {-2147483648};
		System.out.println(findPeakElement(numsI));
	}
}

//LOL, so happy, pass the tests immediately~
public class SearchForRange {
	public static int[] searchRange(int[] nums, int target, int left, int right, int[] res){
		if(left > right)
			return res;
		
		int mid = (left + right) / 2;
		if(nums[mid] == target){
			if(mid > res[1])
				res[1] = mid;
			if(mid < res[0])
				res[0] = mid;
		}
		
		res = searchRange(nums, target, left, mid -1, res);
		res = searchRange(nums, target, mid + 1, right, res);
		return res;
	}
	
	public static int[] searchRange(int[] nums, int target){
		int[] res = {Integer.MAX_VALUE, Integer.MIN_VALUE};
		res = searchRange(nums, target, 0, nums.length - 1, res);
		if(res[0] == Integer.MAX_VALUE || res[1] == Integer.MIN_VALUE){
			res[0] = res[1] = -1;
		}
		return res;
	}
	
	public static void main(String[] args){
		int[] nums = {5, 7, 7, 8, 8, 10};
		int[] res = searchRange(nums, 15);
		System.out.println(res[0] + " " + res[1]);
	}
}

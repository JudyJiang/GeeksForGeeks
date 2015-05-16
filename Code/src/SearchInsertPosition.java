
public class SearchInsertPosition {
	public static int searchInsert(int[] nums, int target){
		if(target > nums[nums.length - 1])
			return nums.length;
		int pos = 0;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] == target){
				return i;
			}
			else if(nums[i] < target)
				continue;
			else{
				pos = i;
				break;
			}
		}
		if(pos < 0)
			return 0;
		return pos;
	}
	
	public static void main(String[] args){
		int[] nums = {1, 3, 5, 6};
		int target = 0;
		System.out.println(searchInsert(nums, target));
	}
}

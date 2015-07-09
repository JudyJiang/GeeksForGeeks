/**
 * I'm... so awesome! today
 * @author fengjiaojiang
 *
 */
public class FindMinimumInRotatedSortedArrayII {
	public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        return findMin(nums, 0, nums.length - 1);
    }
    
    public int findMin(int[] nums, int left, int right){
        if(left == right){
            return nums[left];
        }
        
        if(left + 1 == right){
            return Math.min(nums[left], nums[right]);
        }
        
        int mid = left + (right - left) / 2;
        if(nums[left] < nums[right]){
            return nums[left];
        }
        
        if(left <= right && nums[left] == nums[right]){
            int tmp = nums[left];
            left++;
            right--;//this is important, to make sure current left, right equals smaller thant
            //later return
            return Math.min(tmp, findMin(nums, left, right));
        }
        else{
            if(nums[left] > nums[mid]){
                return findMin(nums, left, mid);
            }
            else{
                return findMin(nums, mid, right);
            }
        }
    }
    
    public static void main(String[] args){
    	int[] arr = {1, 1, 1};
    	//findMin(arr);
    }
}

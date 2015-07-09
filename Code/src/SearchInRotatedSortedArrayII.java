/**
 * I really love myself. Passed and in a different way!
 * @author fengjiaojiang
 *
 */
public class SearchInRotatedSortedArrayII {
	public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return true;
            }
            
            if(nums[left] != nums[right]){
                if(nums[left] <= nums[mid]){
                    if(nums[left] <= target && target <= nums[mid]){
                        right = mid - 1;
                    }
                    else{
                        left = mid + 1;
                    }
                }
                
                else{
                    if(target <= nums[right] && target >= nums[mid]){
                        left = mid + 1;
                    }
                    else{
                        right = mid - 1;
                    }
                }
            }
            
            else{
                while(left <= right && nums[left] == nums[right]){
                    if(nums[left] == target){
                        return true;
                    }
                    left++;
                    right--;
                }
            }
        }
        return false;
    }
}

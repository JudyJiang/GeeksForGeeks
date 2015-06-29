
public class RemoveDuplicatesSortedArray {
	public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i - 1]){
                //count += 1;
                nums[count] = nums[i];
                count += 1;
            }
        }
        return count;
    }
}

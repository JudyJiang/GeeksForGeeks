
public class RomoveDuplicatesSortedArrayII {
	public static int removeDuplicates(int[] nums){
		if(nums == null || nums.length == 0)
			return 0;
		int count = 1, len = nums.length;
		int value = nums[0], realLen = 1;
		
		for(int i = 1; i < len; i++){
			if(nums[i] == nums[i-1]){
				if(count < 2){
					count++;
					nums[realLen] = nums[i];
					realLen++;
				}
			}
			else{
				nums[realLen] = nums[i];
				count = 1;
				realLen++;
			}
		}
		for(int i = realLen; i < len; i++){
			nums[i] = 0;
		}
		for(int i =0 ; i < len; i++){
			System.out.print(nums[i] + " ");
		}
		System.out.println();
		return realLen;
	}
	
	public static void main(String[] args){
		int[][] test = {{1, 2, 3, 4, 5}, 
				        {1, 1, 1, 2, 2, 3}, 
				        {1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4}, 
				        {1, 2, 2, 2, 2, 5, 5, 5}};
		//System.out.println(removeDuplicatesSortedArrayII(test[1]));
		System.out.println(removeDuplicates(test[2]));
	}
}

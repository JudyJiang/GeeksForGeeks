
public class RemoveElement {
	public static int removeElement(int[] nums, int val){
		int len = 0;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] != val){
				nums[len++] = nums[i];
			}
		}
		return len;
	}
	
	public static void main(String[] args){
		
	}
}

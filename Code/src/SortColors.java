
public class SortColors {
	public static void sortColors(int[] nums){
		if(nums == null || nums.length == 0){
            return ;
        }
        
        int[] counts = new int[3];
        for(int i = 0; i < nums.length; i++){
            counts[nums[i]]++;
        }
        
        int start = 0;
        
        for(int i = 0; i < counts.length; i++){
            while(counts[i] > 0){
                nums[start++] = i;
                counts[i] -= 1;
            }
        }
	}
	
	public static void sortColorsII(int[] nums){
		if(nums == null || nums.length == 0){
			return ;
		}
		
		int zero = -1, two = nums.length, i = 0;
		while(i < two){
			switch(nums[i]){
			case 0:
				swap(nums, i, ++zero);
				i++;
				break;
			case 1:
				i++;
				break;
			case 2:
				swap(nums, i, --two);
				//i++;
				break;
			}
		}
	}
	
	public static void swap(int[] nums, int a, int b){
		int t = nums[a];
		nums[a] = nums[b];
		nums[b] = t;
	}
	
	public static void main(String[] args){
		int[] nums = {1, 0};//{0, 0, 1, 2, 0, 1, 1, 0, 2, 0, 1, 2, 2, 1, 1, 0};
		sortColorsII(nums);
		for(int i = 0; i < nums.length; i++){
			System.out.print(nums[i] + " ");
		}
	}
}

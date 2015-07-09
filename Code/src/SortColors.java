import java.util.*;

public class SortColors {
	public static int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0) {
			return 0;
		}

		int pathSum = 0;
		List<int[]> res = new ArrayList<int[]>();
		for (int i = 0; i < triangle.size(); i++) {
			List<Integer> tmp = triangle.get(i);
			if (i == 0) {
				int[] arr = { tmp.get(0) };
				res.add(arr);
			} else {
				int[] arr = new int[tmp.size()];
				int[] prev = res.get(i - 1);
				for (int j = 0; j < arr.length; j++) {
					if (j == 0) {
						arr[j] = tmp.get(j) + prev[j];
					} else if (j == arr.length - 1) {
						arr[j] = tmp.get(j) + prev[prev.length - 1];
					} else {
						arr[j] = Math.min(tmp.get(j) + prev[j - 1], tmp.get(j)
								+ prev[j]);
					}
				}
				res.add(arr);
			}
		}
		int[] array = res.get(res.size() - 1);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < array.length; i++) {
			min = Math.min(min, array[i]);
		}

		return min;
	}

	public static void main(String[] args) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		triangle.add(Arrays.asList(2));
		triangle.add(Arrays.asList(3, 4));
		triangle.add(Arrays.asList(6, 5, 7));
		triangle.add(Arrays.asList(4, 1, 8, 3));
		int res = minimumTotal(triangle);
		System.out.println(res);
	}
}

// public class SortColors {
// public static void sortColors(int[] nums){
// if(nums == null || nums.length == 0){
// return ;
// }
//
// int[] counts = new int[3];
// for(int i = 0; i < nums.length; i++){
// counts[nums[i]]++;
// }
//
// int start = 0;
//
// for(int i = 0; i < counts.length; i++){
// while(counts[i] > 0){
// nums[start++] = i;
// counts[i] -= 1;
// }
// }
// }
//
// public static void sortColorsII(int[] nums){
// if(nums == null || nums.length == 0){
// return ;
// }
//
// int zero = -1, two = nums.length, i = 0;
// while(i < two){
// switch(nums[i]){
// case 0:
// swap(nums, i, ++zero);
// i++;
// break;
// case 1:
// i++;
// break;
// case 2:
// swap(nums, i, --two);
// //i++;
// break;
// }
// }
// }
//
// public static void swap(int[] nums, int a, int b){
// int t = nums[a];
// nums[a] = nums[b];
// nums[b] = t;
// }
//
// public static void main(String[] args){
// int[] nums = {1, 0};//{0, 0, 1, 2, 0, 1, 1, 0, 2, 0, 1, 2, 2, 1, 1, 0};
// sortColorsII(nums);
// for(int i = 0; i < nums.length; i++){
// System.out.print(nums[i] + " ");
// }
// >>>>>>> cd462dd042a79088893d58a5bbb18a885368ffde
// }
// }

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class ThreeSum {
	/*Write a function to find all the combinations of three numbers that sum to zero 
	Sample input: 
	[2, 3, 1, -2, -1, 0, 2, -3, 0] 
	Sample output: 
	2, -2, 0 
	1, -1, 0 
	3, -2, -1 
	3, 0, -3 
	3, 0, -3*/
	
	public static List<List<Integer>> AllSumToZero(int[] array){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(array == null || array.length < 3)
			return result;
		
		Arrays.sort(array);
		
		for(int i = 0; i < array.length - 3; i++){
			if(i == 0 || array[i] > array[i - 1]){
				int j = i + 1;
				int k = array.length - 1;
				
				while(j < k){
					int twoSum = array[i] + array[j];
					if(twoSum + array[k] < 0)
						j++;
					else if(twoSum + array[k] > 0)
						k--;
					else{
						List<Integer> subList = new ArrayList<Integer>();
						subList.add(array[i]);
						subList.add(array[j]);
						subList.add(array[k]);
						result.add(subList);
						j++;
						k--;
						while(k > j && array[k] == array[k + 1])
							k--;
						while(j < k && array[j] == array[j - 1])
							j++;
					}
				}
			}
		}
		return result;
	}
	
	
	public static void main(String[] args){
		int[] array = {2, 3, 1, -2, -1, 0, 2, -3, 0};
		List<List<Integer>> res = AllSumToZero(array);
		
		System.out.println(res.size());
		for(int i = 0; i < res.size(); i++){
			System.out.print("[");
			for(int j = 0;j < res.get(i).size(); j++){
				System.out.print(res.get(i).get(j) + " ");
			}
			System.out.print("]" + "\n");
		}
	}
}

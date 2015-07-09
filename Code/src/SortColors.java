import java.util.*;

public class SortColors {
	public static int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0){
            return 0;
        }
        
        int pathSum = 0;
        List<int[]> res = new ArrayList<int[]>();
        for(int i = 0; i < triangle.size(); i++){
            List<Integer> tmp = triangle.get(i);
            if(i == 0){
                int[] arr = {tmp.get(0)};
                res.add(arr);
            }
            else{
                int[] arr = new int[tmp.size()];
                int[] prev = res.get(i - 1);
                for(int j = 0; j < arr.length; j++){
                    if(j == 0){
                        arr[j] = tmp.get(j) + prev[j];
                    }
                    else if(j == arr.length - 1){
                        arr[j] = tmp.get(j) + prev[prev.length - 1];
                    }
                    else{
                        arr[j] = Math.min(tmp.get(j) + prev[j - 1], tmp.get(j) + prev[j]);
                    }
                }
                res.add(arr);
            }
        }
        int[] array = res.get(res.size() - 1);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < array.length; i++){
        	min = Math.min(min,  array[i]);
        }
        
        return min;
    }
	
	
	
	
	public static void main(String[] args){
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		triangle.add(Arrays.asList(2));
		triangle.add(Arrays.asList(3, 4));
		triangle.add(Arrays.asList(6, 5, 7));
		triangle.add(Arrays.asList(4, 1, 8, 3));
		int res = minimumTotal(triangle);
		System.out.println(res);
	}
}

package careercup;

public class FindDuplicate {
	public static int findDuplicate(int[] arr){
		int n = arr.length;
		for(int i = 0; i < n; i++){
			int index = i;
			if(arr[i] == index)
				continue;
			//System.out.println(i);
			while(true){
				//System.out.println(index);
				int tmp = arr[arr[index]];
				arr[arr[index]] = arr[index];
				index = tmp;
				if(arr[index] == i)
					break;
				if(index == arr[index])
					return index;
				
			}
		}
		return -1;
	}
	
	public static void main(String[] args){
		int[] arr = {5, 6, 4, 0, 4, 3, 2};
		System.out.println(findDuplicate(arr));
	}
}

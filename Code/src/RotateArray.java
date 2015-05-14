
public class RotateArray {
	public static int[] rotateArray(int[] num, int k){
		if(k == 0 || k == num.length)
			return num;
		
		if(k >= num.length)
			k = k - num.length;
		
		int[] newArray = new int[num.length];
		for(int i = num.length - k, j = 0; i < num.length; i++, j++)
			newArray[j] = num[i];
		for(int i = 0, j = k; i <= k && j <num.length; i++, j++)
			newArray[j] = num[i];
		return newArray;
	}
	public static void printString(int[] arr){
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
	public static void swap(int[] arr, int a, int b){
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	
	public static void rotateArrayI(int[] num, int k){
		if(k==0 || k == num.length)
			return;
		if(k > num.length)
			k = k - num.length;
		
		int left = 0, right = num.length - 1;
		while(left < right)
			swap(num, left++, right--);
		
		left = 0;
		right = k - 1;
		while(left < right){
			swap(num, left++, right--);
		}
		left = k;
		right = num.length - 1;
		while(left < right){
			System.out.println(left + " " + right);
			swap(num, left++, right--);
		}
	}
	
	public static void main(String[] args){
		int[] num = {1, 2, 3, 4, 5, 6, 7};
		rotateArrayI(num, 3);
		printString(num);
	}
}

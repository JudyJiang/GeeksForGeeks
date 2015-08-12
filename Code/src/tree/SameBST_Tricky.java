package tree;

/*
 * This has to follow certain conditions.
 * Nope, no certain condition. Just to find the "root" in both arrays and use remember its index
 * in each array.
 * 
 * has to remember the "min" and "max" as the left and right subarray
 * See the following implementation
 */
public class SameBST_Tricky {
	public static boolean isSameTree(int[] a, int[] b){
		if(a.length != b.length)
			return false;
		
		return isSameTree(a, b, a.length, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static boolean isSameTree(int[] a, int[] b, int len, int pa, int pb, int min, int max){
		int i, j;

		
		for(i = pa; i < len; i++){
			if(a[i] < max && a[i] > min)
				break;
		}
		
		for(j = pb; j < len; j++){
			if(b[j] < max && b[j] > min)
				break;
		}
		
		if(i == len && j == len)
			return true;
		
		if((i==len ^ j == len) || a[i] != b[j])
			return false;
		
		return isSameTree(a, b, len, pa + 1, pb + 1, min, a[i]) && 
				isSameTree(a, b, len, pa + 1, pb + 1, a[i], max);
	}
	
	public static void main(String[] args){
		int[] a = {2, 4, 3, 1}, b = {2, 1, 4, 3};
		System.out.println(isSameTree(a, b));
	}
}

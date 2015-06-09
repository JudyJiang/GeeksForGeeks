package PayAttention;
/*
 * Such problem which involves the "a total number", "the i-th fraction", "the j-th index"
 * normally will use "/" and "%"
 */
public class PermutationSequence {
	public String getPermutation(int n, int k){
		if(n == 0 || k == 0)
			return "";
		
		int total = 1;
		String tmp = "", res = "";
		for(int i = 1; i <= n; i++){
			total *= i;
			tmp += String.valueOf(i);
		}
		
		k--; //cause string index from 0 but 
		while(n != 0){
			total = total / n; 
			// this actually equals to (n-1)!. which means "without this index number, how many left fractorial 
			//for the remaining n - 1. (take n = 4, k = 11 for example and draw will be clear)o
			int index = k/total;//this to find which index to start with
			k = k % total; 
			//k should also change cause the previous combination already picked
			res += String.valueOf(tmp.charAt(index));
			//now reconstruct the substring of tmp string.
			if(index == 0)
				tmp = tmp.substring(1);
			else
				tmp = tmp.substring(0, index) + tmp.substring(index + 1);
			n--;
		}
		
		return res;
	}
	
	
	public static int[] factorial(int n){
		int[] res = new int[n + 1];
		res[0] = 1;
		for(int i = 1; i <= n; i++){
			int tmp = res[i-1];
			res[i] = tmp * i;
		}
		return res;
	}
	public static void main(String[] args){
		int[] res = factorial(4);
		System.out.println(res[4]);
	}
}

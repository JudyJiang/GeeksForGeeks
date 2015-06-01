
public class UniqueBinarySearchTrees {
	//http://fisherlei.blogspot.com/2013/03/leetcode-unique-binary-search-trees.html
	/*
	 * Used to work, but now time limit exceeded.. 
	 */
	public static int numTrees(int n) {
		if(n==0 || n == 1)
			return 1;
		int res = 0;
		for(int i = 1; i <= n; i++){
			res += numTrees(i-1)*numTrees(n-i);//It's a function!! not just an array but a function!
			//so when dynamic programming, function->storage array usually have(i, j..to i)
		}
		return res;
	}
	
	public static int numTreesII(int n){
		int[] arr = new int[n+1];
		arr[0] = arr[1] = 1;
		for(int i = 2; i <= n; i++){
			for(int j = 0; j < i; j++){
				arr[i] += arr[j]*arr[i-1-j];
			}
		}
		return arr[n];
	}
	
	public static void main(String[] args){
		System.out.println(numTrees(4));
		System.out.println(numTreesII(4));
	}
}

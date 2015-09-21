package dynamicprogramming;

public class JumpGame {
	/*
	 * feel so happy, don't so often got a chance to solve a dp problem all
	 * by myself.
	 */
	public static boolean canJump(int[] arr){
		if(arr.length <= 1)
			return true;
		
		boolean[] dp = new boolean[arr.length];
		dp[0] = true;
		for(int i = 1; i < arr.length; i++){
			for(int j = 0; j < i; j++){
				if(dp[j] && j + arr[j] >= i)
					dp[i] = true;
			}
		}
		return dp[arr.length - 1];
	}
	
	public static boolean canJumpII(int[] arr){
		if(arr.length <= 1){
			return true;
		}
		
		int max = arr[0];
		for(int i = 0; i < arr.length; i++){
			if(max <= i && arr[i] == 0)
				return false;
			max = Math.max(max,  i + arr[i]);
			if(max >= arr.length - 1)
				return true;
		}
		return false;
	}
	
	public static int jumpSteps(int[] arr){
		int steps = 0;
		int canReach = 0;
		int lastReach = 0;
		for(int i = 0; i < arr.length; i++){
			if(lastReach < i){
				lastReach = canReach;
				steps++;
			}
			canReach = Math.max(canReach, arr[i] + i);
		}
		if(canReach < arr.length - 1)
			return 0;
		return steps;
	}
	
	public static void main(String[] args){
		int[] arr = {3, 2, 1, 0, 4};//{2, 3, 1, 1, 4};
		System.out.println(canJump(arr));
	}
}

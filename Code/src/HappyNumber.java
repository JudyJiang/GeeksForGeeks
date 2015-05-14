import java.util.HashSet;;

public class HappyNumber {
	
	public static char[] numberToArray(int n){
		String strNum = String.valueOf(n);
		char[] strArr = strNum.toCharArray();
		return strArr;
	}
	
	/*
	 * Test this string staff transformation staff and 
	 * general array staff which one requires more time
	 */
	
	public static int sumDigits(String arr){
		if(arr == null || arr.length() == 0){
			return 0;
		}
		
		char[] array = arr.toCharArray();
		int res = 0;
		for(int i = 0; i < array.length; i++){
			res += Math.pow(array[i] - '0', 2);
		}
		return res;
	}

	
	public static boolean happyNumber(int n){
		//loop appears if any current equals to previous ..
		HashSet<String> loopSet = new HashSet<String>();
		String numberStr;
		numberStr = String.valueOf(n);
		int sums = sumDigits(numberStr);
		while(!loopSet.contains(numberStr)){
			loopSet.add(numberStr);
			if(sums == 1){
				return true;
			}
			numberStr = String.valueOf(sums);
			sums = sumDigits(numberStr);
		}
		
		return false;
	}
	
	public static void main(String[] args){
		int test = 13;
		System.out.println(happyNumber(test));
	}
}

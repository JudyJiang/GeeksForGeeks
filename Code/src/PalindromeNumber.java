public class PalindromeNumber {
	/*
	 * With extra space
	 */
	public static boolean isPalindrome(int x) {
		char[] xChar = String.valueOf(x).toCharArray();
		int i = 0, j = xChar.length - 1;
		while(i <= j){
			if(xChar[i] != xChar[j])
				return false;
			i++;
			j++;
		}
		return true;
	}
	
	public static boolean isPalindromeNonExtraSpace(int x){
		int sign = 1;
		if(x < 0)
			sign = -1;
		x = x*sign;
		int newX = 0, value = x;
		while(x != 0){
			int last = x % 10;
			newX = newX * 10 + last;
			x /= 10;
		}
		
		//System.out.println(value + " " + newX);
		newX *= sign;
		return newX == value;
	}
	
	public static void main(String[] args){
		int x = 22;
		System.out.println(isPalindromeNonExtraSpace(x));
	}
}
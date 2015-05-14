public class ReverseInteger {
	
	
	public static int reverse(int x) {
		int sign = x >= 0? 1 : -1;
		long res = 0;
		int digit;
		x = x*sign;
	
		
		while(x!=0){
			digit = x%10;
			res = res*10+digit;
			x/=10;
		}
	
		if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
			return 0;
		return (int)res;
	}
	
	public static int reverseI(int x){
		char[] charX = String.valueOf(x).toCharArray();
		for(int i = charX.length - 1; i >= 0; i--){
			
		}
		return 0;
	}
	
	public static void main(String[] args){
		int x = 123;
		System.out.println(Math.pow(2, 31)-1);
	//	2147483647
		System.out.println(Integer.MAX_VALUE);

		int res = reverse(x);
		System.out.println(res);
	}
}



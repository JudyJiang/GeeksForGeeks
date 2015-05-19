
public class FactorialTrailingZeros {
	//continuous zeros: http://bookshadow.com/weblog/2014/12/30/leetcode-factorial-trailing-zeroes/
	public static int trailingZeros(int n){
		if(n < 0)
			return -1;
		int count = 0;
		for(long i = 5; n / i >= 1; i *= 5){
			count += n / i;
		}
		return count;
	}
	
	public static int power(int n){
		if(n == 0 || n == 1)
			return 1;
		return n * power(n - 1);
	}
	
	public static void main(String[] args){
		int[] test = {5, 8, 9, 10, 13, 15, 17, 20, 21, 22, 25, 40, 42};
		for(int i = 0; i <= 15; i++){
			System.out.println(i + " " + power(i));
		}
	}
}

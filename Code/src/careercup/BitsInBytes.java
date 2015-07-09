package careercup;

public class BitsInBytes {
	public static boolean contain3Bits(int n){
		int res = 0;
		while(n != 0){
			n = n & (n - 1);
			res++;
		}
		return res == 3;
	}
	
	public static void countBits(int n){
		int tmp = n, res = 0;
		while(tmp != 0){
			if((tmp & 1) != 0)
				res++;
			tmp = tmp >> 1;
		}
		System.out.println(res);
	}//can be used
	
	public static void main(String[] args){
//		int a = 3, b = 1;
//		System.out.println(Integer.toBinaryString(a));
//		System.out.println(Integer.toBinaryString(a & b));
		countBits(15);
	}
}

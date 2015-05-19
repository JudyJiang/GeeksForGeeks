
public class Number1Bits {
	public static int hammingWeight(int n){
		int count = 0;
		for(int i = 1; i <= 32; i++){
			if(getBit(n, i))
				count++;
		}
		return count;
	}
	
	public static boolean getBit(int n, int i){
		return (n & (1 << i)) != 0;
	}
}

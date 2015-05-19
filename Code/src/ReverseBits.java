
public class ReverseBits {
	public static boolean getBit(long n, int i){
	//	System.out.println(i + " " + (1 << i));
		return (n & (1 << i)) != 0;
	}
	
	public static int reverseBits(long n){
		int res = 0;
		for(int i = 0; i < 32; i++){
			if(getBit(n, i)){
				System.out.println(i);
				res += Math.pow(2,  32- i -1);
			}
			
		}
		if(getBit(n, 32))
			res += 1;
		return res;
	}
	/*
	 * This solution only works for signed int...
	 * full solution here: http://www.programcreek.com/2014/03/leetcode-reverse-bits-java/
	 */
	
	public int reverseBits(int n) {
        for(int i = 0; i < 16; i++){
            n = swapBits(n, i, 32 - i - 1);
        }
        return n;
    }
    
    public int swapBits(int n, int i, int j){
        int a = (n >> i) & 1; //get the i-th bit 
        int b = (n >> j) & 1;
        if((a ^ b) != 0){ //a and b are different.
            return n ^= (1 << i) | (1 << j); // to get the different 
        }
        /*
         * if a == b (both 1 and both 0) then return n
         * if a != b, suppose a = 1 and b = 0
         * then (1 << i) | (1 << j) now both i and j are 1s.
         * n ^= (1 << i) | (1 << j)
         * at a position, 1 meets (1 << i) turns to 0 (because ^)
         * at b position, 0 meets (1 << j) turns to 1.
         */
        return n;
    }
	
	
	public static void main(String[] args){
		int n = 1900;
		System.out.println(Integer.toBinaryString(n));
		System.out.println(((n >> 1) & 1) + " " + ((n >> 8)&1));
		System.out.println(Integer.toBinaryString(((1<<1)|(1 << 8))));
	}
}

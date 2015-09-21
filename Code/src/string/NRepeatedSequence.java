package string;

/**
 * I love myself again
 * Maybe a little troublesome but still made it.`
 * @author fengjiaojiang
 *
 */
public class NRepeatedSequence {
	public static boolean nReaptedString(String s){
		int start = 0, end = 0;
		int subStart = 1, subEnd = 0;
		int i, j = 0;
		
		while(subStart < s.length() && j <= s.length()){
			if(s.charAt(start) != s.charAt(subStart)){
				//System.out.println(subStart);
				while(subStart < s.length() && s.charAt(start) != s.charAt(subStart)){
					end++;
					subStart++;
				}
				
			}
			else{
				i = start;
				j = subStart;
			//	System.out.println("end: " + end + " " + subStart);
				while(i <= end && j < s.length()){
					if(s.charAt(i) != s.charAt(j)){
						break;
					}
					i++;
					j++;
				}
				
				
				if(j == s.length() && i < end)
					return false;
				if(i > end){
					subStart = j;
				}
				else{
					subStart += 1;
					end = subStart - 1;
				}
			}
		}
		
		if(end == s.length() - 1)
			return false;
		System.out.println(s.substring(start,  end +1));
		return true;
	}
	
	//find the longest common prefix.....
	//more like dynamic programming
	//abcabcabc
	//abadabad
	/*
	 * another method. use "start", "len" 
	 * s.substring(start, start+len).equals(i, i+len)
	 */
	public static int longestPrefix(String s){
		int n = s.length();
		int[] dp = new int[n];
		dp[0] = 0;
		int len = 0, i = 1;
		while(i < n){
			if(s.charAt(len) == s.charAt(i)){
				//len is as the "start" in previous solution
				len++;
				dp[i] = len;
				i++;
			}
			else{
				if(len != 0){
					len = dp[len - 1];
				}
				else{
					//len == 0
					dp[i] = 0;
					i++;
				}
			}
		}
		return dp[n-1];
	}
	
	public static void main(String[] args){
		String str = "abcabcabc";
		str = "abadabad";
		str = "aabaabaabaab";
		str = "abcdabc";
		str = "abcabcdabcabcd";
		System.out.println(nReaptedString(str));
	}
}

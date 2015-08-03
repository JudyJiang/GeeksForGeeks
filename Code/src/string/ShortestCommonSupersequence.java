package string;

/*
 * Input:   str1 = "geek",  
 			str2 = "eke"
   Output:  "geeke"

   Input:   str1 = "AGGTAB",  
   			str2 = "GXTXAYB"
   Output:  "AGXGTXAYB"
 */
public class ShortestCommonSupersequence {
	public static String longesetCommonSubstring(String s1, String s2){
		int m = s1.length(), n = s2.length();
		StringBuilder sb = new StringBuilder();
		int[][] dp = new int[m+1][n+1];
		int max = 0;
		
		int index = 0;
		for(int i = 0; i <= m; i++){
			for(int j = 0; j <= n; j++){
				if(s1.charAt(i) == s2.charAt(j)){
					if(i == 0 || j == 0)
						dp[i][j] = 1;
					else
						dp[i][j] = dp[i-1][j-1] + 1;
				}
				if(dp[i][j] > max){
					max = dp[i][j];
					int curr = i - dp[i][j] + 1;
					if(curr == index)
						sb.append(s1.charAt(i));
					else{
						index = curr;
						sb = new StringBuilder();
						sb.append(s1.substring(index, i + 1));
					}
				}
			}
		}
		
		int i = m, j = n;
		while(i > 0 && j > 0){
			if(dp[i][j] == dp[i-1][j])
				i--;
			else if(dp[i][j] == dp[i][j-1])
				j--;
			else{
				assert(s1.charAt(i-1)== s2.charAt(j-1));
				sb.append(s1.charAt(i-1));
				i--;
				j--;
			}
		}
		return sb.toString();
	}
	
	//http://www.geeksforgeeks.org/shortest-common-supersequence/
	/*
	 * s1 = AGGTAB, s2 = GXTXAYB
	 * common: GTAB
	 * un-used in s1: AG -> {0, 1}
	 * un-used in s2: XXY -> {1, 3, 5}
	 * insert the un-used parts into GTAB in order, in a merge way
	 */
}

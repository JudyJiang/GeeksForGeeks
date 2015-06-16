/**
 * This is actually a fully  understood dp problem (ever)
 * https://web.stanford.edu/class/cs124/lec/med.pdf
 * @author FengjiaoJiang
 *
 */
public class EditDistance {
	public static int minDistance(String word1, String word2){
		int m = word1.length(), n = word2.length();
		int[][] dp = new int[m + 1][n + 1];
		
		
		/*
		 * This initialization of the first vertical and horizontal line of the 
		 * matrix means any word from "" to a word1 or word2 needs to add
		 * m or n characters
		 */
		for(int i = 0; i <= m; i++){
			dp[i][0] = i;
		}
		for(int j = 0; j <= n; j++){
			dp[0][j] = j;
		}
		
		/*
		 * D(i,j) means the now at the i-th position of word1 and j-th position of word2
		 * three operations:  from word1 to word2
		 * delete(add): D(i - 1, j) + 1 (j delete i position character
		 * insert: D(i, j - 1) + 1 just insert one character
		 * Substitute: D(i - 1, j - 1) ignore both last character and change it to another one
		 * if word1[i] == word2[i] then this step has to cost, otherwise cost is 2
		 */
		for(int i = 1; i <= m; i++){
			char c1 = word1.charAt(i - 1);
			for(int j = 1; j <= n; j++){
				char c2 = word2.charAt(j - 1);
				if(c1 == c2){
					dp[i][j] = dp[i - 1][j - 1];
				}
				else{
					int replace = dp[i - 1][j - 1] + 1;
					int insert = dp[i][j - 1] + 1;
					int delete = dp[i - 1][j] + 1;
					int min = Math.min(replace, insert);
					min = Math.min(min, delete);
					dp[i][j] = min;
				}
			}
		}
		return dp[m][n];
	}
	
	public static void main(String[] args){
		String word1 = "ab", word2 = "bc";
		int res = minDistance(word1, word2);
		System.out.println(res);
	}
}

package linkedin;

public class LongestPalidromeSubsequence {
	public static void LongestPalidronmeSub(String str){
		char[] charStr = str.toCharArray();
		int len = LongestPalidronmeSub(charStr, 0, charStr.length - 1);
		System.out.println(len);
	}
	
	public static int LongestPalidronmeSub(char[] str, int i, int j){
		if(j <= i)
			return (j - i + 1);
		
		if(str[i] == str[j]){
			return 2 + LongestPalidronmeSub(str, i + 1, j - 1);
		}
		
		else{
			return Math.max(LongestPalidronmeSub(str, i + 1, j), LongestPalidronmeSub(str, i, j - 1));
		}
	}
	
	public static void DPLongest(String str){
		char[] charStr = str.toCharArray();
		int n = charStr.length;
		int[][] met = new int[n + 1][n + 1];
		for(int i = 0; i <= n; i++)
			met[i][i] = 1;
		
		for(int i = 0; i <= n; i++){
			for(int j = 0; j <= n; j++){
				
			}
		}
	}
	
	public static void main(String[] args){
		String str = "41234565434444444";
		LongestPalidronmeSub(str);
	}
}

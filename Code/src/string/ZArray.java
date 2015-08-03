package string;

//application: 
//1. Find the pattern within a string
//2. longest common substring that can be the prefix
public class ZArray {
	public static void constructZArray(String string, String pattern){
		//P = "aab", T = "baabaa"
		//final = "aab$baabaa"
		String str = pattern + "$" + string;
		int n = str.length();
		int[] zArr = new int[n];
		int L = 0, R = 0, k = 0;
		for(int i = 1; i < n; i++){
			if(i > R){
				L = R = i;
				while(R < n && string.charAt(R - L) == string.charAt(L))
					R++;
				zArr[i] = R - L;
				R--;
			}
			else{
				//internal
				k = i - L;
				if(zArr[k] < R - i + 1)
					zArr[i] = zArr[k];
				else{
					L = i;
					while(R < n && string.charAt(R - L) == string.charAt(R))
						R++;
					zArr[i] = R - L;
					R--;
				}
			}
		}
	}
}

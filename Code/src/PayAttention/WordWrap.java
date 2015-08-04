package PayAttention;

import java.util.*;

public class WordWrap {
	public static String[] getWords(String s){
		return s.split("\\s+");
	}
	
	public static void wordWrap(String[] words, int M){
		int n = words.length;
		//1. calculate extra space for each word i ~ j
		int[][] extra = new int[n+1][n+1];
		for(int i = 1; i <= n; i++){
			extra[i][i] = M - words[i-1].length();
			for(int j = i + 1; j <= n; j++){
				extra[i][j] = extra[i][j-1] - words[j-1].length() - 1; 
				//"-1" means one extra space
			}
		}
		//2. calculate extra cost for each
		int[][] cost = new int[n+1][n+1];
		for(int i = 1; i <= n; i++){
			for(int j = i; j <= n; j++){
				if(extra[i][j] < 0)
					cost[i][j] = Integer.MAX_VALUE;
				if(j == n && extra[i][j] > 0){
					cost[i][j] = 0;
				}
				else
					cost[i][j] = extra[i][j] * extra[i][j];
			}
		}
		//3. find the optimal cost
		int[] totalCost = new int[n+1];
		int[] lines = new int[n+1];
		totalCost[0] = 0;
		
		for(int j = 1; j <= n; j++){
			totalCost[j] = Integer.MAX_VALUE;
			for(int i = 1; i <= j; i++){
				if(totalCost[i - 1] != Integer.MAX_VALUE && cost[i][j] != Integer.MAX_VALUE &&
						totalCost[i-1] + cost[i][j] < totalCost[j]){
					totalCost[j] = totalCost[i-1] + cost[i][j];
					lines[j] = i;
				}
			}
		}
		//print lines solution line i from word ~ to word ~
	}
	
	
	public static void wordWrap(String s){
		String[] words = getWords(s);
	}
}

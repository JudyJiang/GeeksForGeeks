/*
 * Pay Attention!!!
 */
public class BestTimeToBuyAndSellIII {
	//http://www.programcreek.com/2014/02/leetcode-best-time-to-buy-and-sell-stock-iii-java/
	public static int maxProfix(int[] prices){
		if(prices == null || prices.length < 2)
			return 0;
		
		int size = prices.length;
		int[] left = new int[size], right = new int[size];
		
		int min = prices[0];
		left[0] = right[size - 1] = 0;
		for(int i = 1; i < size; i++){
			min = Math.min(min, prices[i]);
			left[i] = Math.max(left[i - 1], prices[i] - min);
		}
		
		int max = prices[size - 1];
		for(int i = size - 2; i >= 0 ; i--){
			max = Math.max(max, prices[i]);
			right[i] = Math.max(right[i+1],  max - prices[i]);
 		}
		
		int profit = 0;
		for(int i = 0; i < size; i++){
			profit = Math.max(profit, left[i] + right[i]);
		}
		return profit;
	}
	
	
}

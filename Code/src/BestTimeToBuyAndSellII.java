/*
 * hmmm, interesting....
 */
public class BestTimeToBuyAndSellII {
	public static int maxProfit(int[] prices){
		int maxProfix = 0;
		for(int i = 1; i < prices.length; i++){
			if(prices[i] > prices[i - 1])
				maxProfix += prices[i] - prices[i - 1];
		}
		return maxProfix;
	}
}

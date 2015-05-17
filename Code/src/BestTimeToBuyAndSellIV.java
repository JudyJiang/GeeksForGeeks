
//http://www.programcreek.com/2014/03/leetcode-best-time-to-buy-and-sell-stock-iv-java/
//http://liangjiabin.com/blog/2015/04/leetcode-best-time-to-buy-and-sell-stock.html

public class BestTimeToBuyAndSellIV {
	public int maxProfit(int k, int[] prices){
		int len = prices.length;
		if(len < 2 || k <= 0)
			return 0;
		
		int[][] local = new int[len][k + 1];
		int[][] global = new int[len][k + 1];
		
		for(int i = 1; i < len; i++){
			int diff = prices[i] - prices[i - 1];
			/* local[i][j] is the maximum of j transactions and the last transaction is on i-th day
			 * global[i][j] is maximum profit of the j transactions by day i.
			 *                         partA                     partB
			 * local[i][j] = max(global[i-1][j-1]+max(diff, 0), local[i-1][j]+diff)
			 * partA means 
			 */
			for(int j = 1; j <= k; j++){
				local[i][j] = Math.max(global[i-1][j-1] + Math.max(diff,  0),  local[i-1][j] + diff);
				global[i][j] = Math.max(global[i-1][j], local[i][j]);
			}
		}
		
		return global[prices.length - 1][k];
	}
}

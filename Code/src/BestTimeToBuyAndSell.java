public class BestTimeToBuyAndSell {
	public static int maxProfit(int[] pieces) {
		int minDay = 0, maxProfix = 0;
		for (int i = 1; i < pieces.length; i++) {
			maxProfix = Math.max(maxProfix, pieces[i] - pieces[minDay]);
			// minDay = Math.min(pieces[i], pieces[minDay]);//this I think ok
			// since if pieces[i]<pieces[minDay].
			// pieces[j] > pieces[i] then pieces[j]-pieces[i] >
			// pieces[j]-pieces[minDay]
			minDay = pieces[i] > pieces[minDay] ? minDay : i;
		}
		return maxProfix;
	}

	public static void main(String[] args) {
		int[] pieces = { 3, 2, 6, 5, 0, 3 };
		int res = maxProfit(pieces);
		System.out.println(res);
	}

	/*
	 * I: only buy once and sell once, so find the minDay while at the same time
	 * maintain the max value; 
	 * 
	 * II: can buy and sell as many times as possible
	 * but can't sell one stock twice. so before buying another one must sell
	 * the current one
	 * 
	 * III: can only buy and sell twice...
	 */
}

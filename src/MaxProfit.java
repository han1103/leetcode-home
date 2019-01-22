
public class MaxProfit {
	public static void main(String[] args) {
		MaxProfit max = new MaxProfit();
		System.out.println(max.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
		System.out.println(max.maxProfitQuick(new int[] { 7, 1, 5, 3, 6, 4 }));
		System.out.println(max.maxProfitSelf(new int[] { 7, 1, 5, 3, 6, 4 }));
	}

	public int maxProfit(int[] prices) {
		int max = 0;
		if (prices != null && prices.length > 1)
			for (int i = 0; i < prices.length; i++)
				for (int j = i + 1; j < prices.length; j++)
					if (prices[j] > prices[i] && prices[j] - prices[i] > max)
						max = prices[j] - prices[i];

		return max;
	}

	public int maxProfitQuick(int[] prices) {
		int max = 0;
		if (prices != null && prices.length > 0) {
			int minPrice = prices[0];

			for (int i = 1; i < prices.length; i++) {
				if (prices[i] < minPrice)
					minPrice = prices[i];
				else {
					int profit = prices[i] - minPrice;
					if (profit > max)
						max = profit;
				}
			}
		}
		return max;
	}
	
	public int maxProfitSelf(int[] prices) {
		if (prices==null || prices.length==0)
			return 0;
		
		int min = prices[0];
		int profit = 0;
		
		for(int i=1; i<prices.length; i++)
			if (prices[i]>min) {
				if ((prices[i]-min)>profit)
					profit = prices[i]-min;
			}
			else if (prices[i]<min) {
				min = prices[i];
			}
										
		return profit;
		
	}
	
}

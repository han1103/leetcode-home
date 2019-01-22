
public class MaxProfit2 {
	public static void main(String[] args) {
		System.out.println(new MaxProfit2().maxProfit(new int[]{1,2,3,4,5}));
	}
	
	public int maxProfit(int[] prices) {
		int maxProfit = 0;
				
		int i=1;
		int buyIndex = -1;
		
		while(i<prices.length) {
			if(buyIndex==-1 && prices[i]>prices[i-1]) {
				buyIndex = i-1;
			}
			else if(buyIndex!=-1 && prices[i]<prices[i-1]) {
				maxProfit+=(prices[i-1]-prices[buyIndex]);
				buyIndex = -1;
			}
			
			if (buyIndex!=-1 && i==prices.length-1)
				maxProfit+=(prices[i]-prices[buyIndex]);
			i++;
		}
		
		return maxProfit;
	}
}

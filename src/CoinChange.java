import java.util.HashMap;
import java.util.Map;

public class CoinChange {
    private int[] coins;
    
    private Map<Integer, Integer> cachedResult = new HashMap<>();
    
    private int[] cachedResultArr;
    
	public int coinChangeRec(int amount) {
/*		if (cachedResult.containsKey(amount))
			return cachedResult.get(amount); 
*/		
		if(amount>=0&&cachedResultArr[amount]!=Integer.MAX_VALUE)
			return cachedResultArr[amount];
		if (amount==0)
			return 0;
		if (amount<0)
			return -1;
		int minChangePre = Integer.MAX_VALUE;
		for(int coin : coins) {
			int numChange = coinChangeRec(amount-coin);
			if ( numChange != -1) {
				minChangePre = Math.min(minChangePre, numChange);
			}
		}
		if (minChangePre == Integer.MAX_VALUE) {
			//cachedResult.put(amount, -1);
			cachedResultArr[amount]=-1;
			return -1;
		}
		else {
			//cachedResult.put(amount, minChangePre+1);
			cachedResultArr[amount]=minChangePre+1;
			return minChangePre+1;
		}
	}
	
	public int coinChange(int[] coins, int amount) {
		if (coins==null || coins.length==0 || amount<0)
			return -1;
        if (amount == 0)
            return 0;
		
		this.coins = coins;
		this.cachedResultArr = new int[amount+1];
		
		for(int i=1; i<=amount; i++)
			cachedResultArr[i]=Integer.MAX_VALUE;
		cachedResultArr[0]=0;
		
		return coinChangeRec(amount); 
	}
	
	public int coinChangeItr(int amount) {
		int[] numCoins = new int[amount+1];
		
		numCoins[0]=0;
		boolean foundOne = false;
		for (int coin:coins) {
			if (coin==1)
				foundOne = true; 				
		}
		if (foundOne)
			numCoins[1]=1;
		else
			numCoins[1]=-1;
		
		for(int i=2; i<=amount; i++) {
			int min = Integer.MAX_VALUE;
			for(int coin:coins) {
				int newAmt = i-coin;
				if (newAmt>=0)
					if(numCoins[newAmt]!=-1)
						min = Math.min(min,  numCoins[newAmt]);
			}
			if(min==Integer.MAX_VALUE)
				numCoins[i]=-1;
			else
				numCoins[i]=1+min;
		}
		
		return numCoins[amount];
	}
	
	public static void main(String[] args) {
		System.out.println(new CoinChange().coinChange(new int[]{1, 2,5}, 100));
	}
}

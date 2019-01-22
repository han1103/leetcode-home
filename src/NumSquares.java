
public class NumSquares {
	public int numSquares(int n) {
		int[] dp = new int[n+1];
		if(n<4) {
			return n;
		}
		
		for(int i=0; i<4; i++)
			dp[i]=i;
		
		for(int i=4; i<=n; i++) {
			int min = Integer.MAX_VALUE;
			int maxK = (int)Math.sqrt(i);
			for(int k=1; k<=maxK; k++)
				min = Math.min(min, dp[i-k*k]+1);
			dp[i] = min;
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		System.out.println(new NumSquares().numSquares(16));
	}
}

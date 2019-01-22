package easy;

public class HammingDistance {
	public int hammingDistance(int x, int y) {
		boolean[] xbit = new boolean[31];
		boolean[] ybit = new boolean[31];
				
		for(int i=30; i>=0; i--) {
			int div = x / (int)Math.pow(2, i);
			if(div==1)
				xbit[i]=true;
			x-=div*(int)Math.pow(2, i);
		}
		for(int i=30; i>=0; i--) {
			int div = y / (int)Math.pow(2, i);
			if(div==1)
				ybit[i]=true;
			y-=div*(int)Math.pow(2, i);
		}
		
		int distance = 0;
		
		for(int i=0; i<=30; i++)
			if(xbit[i]!=ybit[i])
				distance++;
		
		return distance;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new HammingDistance().hammingDistance(1, 5));
		
	}

}

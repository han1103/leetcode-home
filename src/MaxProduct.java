
public class MaxProduct {
	public int maxProduct(int[] nums) {
		if(nums==null ||nums.length==0)
			return 0;
		if(nums.length==1)
			return nums[0];
		
		int maxSoFar = nums[0];
		int maxPostitiveThisSequence = -1;
		int maxNegativeThisSequence = 1;
		if (nums[0]>0)
			maxPostitiveThisSequence = nums[0];
		else if (nums[0]<0)
			maxNegativeThisSequence = nums[0];
		
		
		for(int i=1; i<nums.length; i++) {
			if(nums[i]>0) {
				if (maxPostitiveThisSequence > 0 )
					maxPostitiveThisSequence *= nums[i];
				else
					maxPostitiveThisSequence = nums[i];
					
				if (maxNegativeThisSequence < 0 )
					maxNegativeThisSequence *= nums[i];
			}
			else if (nums[i]<0) {
				int preMaxNegativeThisSequence = maxNegativeThisSequence;
				int preMaxPostitiveThisSequence = maxPostitiveThisSequence;
				if (maxNegativeThisSequence < 0 ) {
					maxPostitiveThisSequence = maxNegativeThisSequence*nums[i];
					maxNegativeThisSequence = nums[i];
				}				
				if (preMaxPostitiveThisSequence > 0 ) { 
					maxNegativeThisSequence = preMaxPostitiveThisSequence*nums[i];
					if ( preMaxNegativeThisSequence > 0 )
						maxPostitiveThisSequence = -1;
				}
				if(preMaxNegativeThisSequence>0 && preMaxPostitiveThisSequence<0) {
					maxNegativeThisSequence = nums[i];
				}
				
			}
			else {// if (nums[i]==0) {
				if (maxSoFar < 0)
					maxSoFar = 0;
				maxPostitiveThisSequence=-1;
				maxNegativeThisSequence=1;
			}
			
			if (maxPostitiveThisSequence > 0)
				maxSoFar = Math.max(maxSoFar, maxPostitiveThisSequence);
		}
		
		return maxSoFar;
	}
	
	public static void main(String[] args) {
		System.out.println(new MaxProduct().maxProduct(new int[]{0,-2,-3}));
	}
}


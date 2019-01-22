
public class MaxSubArray {
	private static class LeftRight {
		int left;
		int right;
	}
	
	public static void main(String[] args) {
		MaxSubArray maxArray = new MaxSubArray();
		LeftRight lr = new LeftRight();
		int max = maxArray.maxSubArray(new int[]{2,-2,1,-3,4,-1,2,1,-5,4,7}, lr);
		
		System.out.println("max="+max+" left="+lr.left+" right="+lr.right);
	}
	
	private int maxSubArrayHelper(int[] nums, int firstPosIndex, int lastPosIndex, LeftRight lr) {
		int left = firstPosIndex;
		int right = lastPosIndex;
		int currMax = nums[left];
		int maxSoFar = nums[left];
		int maxLeft = left;
		
		for(int i=firstPosIndex+1; i<=lastPosIndex; i++) {
			if (currMax<=0) {
				left = i;
				currMax = nums[i];
			}
			else {
				currMax += nums[i];
			}
			if(currMax>maxSoFar) {
				maxSoFar = currMax;
				right = i;
				maxLeft = left;
			}
		}
		lr.left=maxLeft;
		lr.right = right;
		return maxSoFar;
	}
	
    public int maxSubArray(int[] nums, LeftRight lr) {
    	if (nums.length==1) {
    		return nums[0];
    	}
    	else {
    		int firstPosIndex = -1;
    		for(int i=0; i<nums.length; i++) {
    			if (nums[i]>0) {
    				firstPosIndex=i;
    				break;
    			}
    		}
    		//all non-positive
    		if (firstPosIndex==-1) {
    			int max = Integer.MIN_VALUE;
    			for(int num : nums)
    				if (num>max)
    					max = num;
    			return max;
    		}
    		if (firstPosIndex==nums.length-1)
    			return nums[firstPosIndex];
    		int lastPosIndex = -1;
    		for(int i=nums.length-1; i>=0; i--) {
    			if (nums[i]>0) {
    				lastPosIndex=i;
    				break;
    			}
    		}
    		if ( firstPosIndex == lastPosIndex )
    			return nums[firstPosIndex];
    		
    		return maxSubArrayHelper(nums, firstPosIndex, lastPosIndex, lr);
    	}
    }
}

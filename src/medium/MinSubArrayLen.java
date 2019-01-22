package medium;

public class MinSubArrayLen {
	public int minSubArrayLen(int s, int[] nums) {
		if(nums==null || nums.length==0)
			return 0;
		int start = 0;
		int end = 0;
		int sum = nums[0];
		int len=nums.length;
		int minLen = Integer.MAX_VALUE;
		
		while(start<len) {			
			while(sum<s && ++end<len) {				
				sum+=nums[end];
			} 
			if(sum>=s) {
				if(end==start)
					return 1;
				minLen = Math.min(end-start+1, minLen);
			}
			else
				break;
			sum-=nums[start];
			start++;
		}
		
		if(minLen==Integer.MAX_VALUE)
			minLen = 0;
		
		return minLen;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new MinSubArrayLen().minSubArrayLen(7,  new int[]{2,3,8,2,4,2}));
	}

}

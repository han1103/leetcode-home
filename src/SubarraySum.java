
public class SubarraySum {
	int sumCacheSingle;
	int subarraySumRec(int[] nums, int k, int index) {				
		if(index==0) {
			sumCacheSingle = nums[0];
			if(nums[0]==k)
				return 1;
			else
				return 0;			
		}
		
		int count = subarraySumRec(nums, k, index-1);

		sumCacheSingle+=nums[index];
		int totalSum = sumCacheSingle;
		if(totalSum==k)
			count++;
		
		for(int i=0; i<index; i++) {
			totalSum-=nums[i];
			if(totalSum==k)
				count++;
		}
		
		return count;
	}
	
	public int subarraySum(int[] nums, int k) {
		if(nums==null || nums.length==0)
			return 0;
			
		return subarraySumRec(nums, k, nums.length-1);
	}

	public static void main(String[] args) {
		System.out.println(new SubarraySum().subarraySum(
				new int[]{1,1,1,2,3}, 
				4));

	}

}

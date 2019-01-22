
public class SubarraySum2 {
	int[][] sumCache;
	int subarraySumRec(int[] nums, int k, int index) {				
		if(index==0) {
			sumCache[0][0] = nums[0];
			if(nums[0]==k)
				return 1;
			else
				return 0;
		}
		
		int count = subarraySumRec(nums, k, index-1);
		
		for(int i=index; i>=0; i--) {
			int sum=nums[index];
			if(i!=index)
				sum += sumCache[i][index-1];				
			sumCache[i][index] = sum;
			if(sum==k)
				count++;
		}
		
		return count;
	}
	
	public int subarraySum(int[] nums, int k) {
		if(nums==null || nums.length==0)
			return 0;
		int len = nums.length;
		len=20000;
		sumCache = new int[len][len];
		
		return subarraySumRec(nums, k, nums.length-1);
	}

	public static void main(String[] args) {
		System.out.println(new SubarraySum2().subarraySum(
				new int[]{1,1,1,1}, 
				2));

	}

}

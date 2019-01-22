
public class HouseRobber {
	public static void main(String[] args) {
		System.out.println(new HouseRobber().rob(new int[] { 1,2,3,1 }));
	}

	Integer[] cacheMax;
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		else if (nums.length==1)
			return nums[0];
		cacheMax = new Integer[nums.length];
				
		return robHelperDynaRec(nums, nums.length - 1);
	}

	public int robHelper(int[] nums, int end) {
		if (end == 0)
			return nums[0];
		else if (end == 1)
			return Math.max(nums[0], nums[1]);
		else {
			int maxPrev = robHelper(nums, end - 1);
			int maxPrevPrev = robHelper(nums, end - 2);
			return Math.max(maxPrev, maxPrevPrev + nums[end]);
		}
	}

	public int robHelperDynamic(int[] nums, int end) {
		int[] cache = new int[end + 1];
		cache[0] = nums[0];
		cache[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i <= end; i++) {
			int maxPrev = cache[i - 1];
			int maxPrevPrev = cache[i - 2];
			cache[i] = Math.max(maxPrev, maxPrevPrev + nums[i]);
		}

		return cache[end];
	}
	
	public int robHelperDynaRec(int[] nums, int end) {		
		if (end == 0) {
			cacheMax[0] = nums[0];
		}
		else if (end == 1) {
			cacheMax[1] = Math.max(nums[0], nums[1]); 
		}
		else {
			if(cacheMax[end-1]==null)
				cacheMax[end-1] = robHelper(nums, end - 1);
			if(cacheMax[end-2]==null)
				cacheMax[end-2] = robHelper(nums, end - 2);
			cacheMax[end] = Math.max(cacheMax[end-1], cacheMax[end-2] + nums[end]);
		}
		
		return cacheMax[end];
	}

}

import java.util.Arrays;

public class TwoSum {
	public static void main(String[] args) {
		int[] res = new TwoSum().twoSum(new int[]{3,3}, 6);
		for(int i : res)
			System.out.print(i+",");
	}
	
	public int[] twoSum(int[] nums, int target) {
		if (nums == null || nums.length < 2)
			return null;

		int[] cloneNums = nums.clone();
		Arrays.sort(nums);

		int i = 0, j = nums.length - 1;
		while (i < j) {
			if (nums[i] + nums[j] == target) {
				int indexI = -1;
				int indexJ = -1;
/*				for (int k = 0; k < nums.length; k++) {
					if (cloneNums[k] == nums[i]) {
						indexI=k;
						break;
					}
				}
				for (int k = 0; k < nums.length; k++) {
					if (cloneNums[k] == nums[j] && k!=indexI) {
						indexJ=k;
						break;
					}
				}
*/
				for (int k = 0; k < nums.length; k++) {
					if (cloneNums[k] == nums[i] && indexI==-1 && k!=indexJ) {
						indexI=k;
					}
					if (cloneNums[k] == nums[j] && indexJ==-1 && k!=indexI) {
						indexJ=k;				
					}
					if (indexI!=-1 && indexJ!=-1)
						break;
					
				}
				int[] result = new int[2];
				if (indexI < indexJ) {
					result[0] = indexI;
					result[1] = indexJ;
				} else {
					result[0] = indexJ;
					result[1] = indexI;
				}
				return result;
			} else if (nums[i] + nums[j] > target)
				j--;
			else if (nums[i] + nums[j] < target)
				i++;
		}
		return null;
	}
}


public class ProductExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		if (nums == null || nums.length == 0)
			return nums;

		int[] result = new int[nums.length];

		boolean twoZero = false;
		int indexZero = -1;
		result[0] = 1;
		if (nums[0] == 0)
			indexZero = 0;
		for (int i = 1; i < nums.length; i++) {
			result[0] *= nums[i];
			if (nums[i] == 0)
				if (indexZero != -1) {
					twoZero = true;
					break;
				} else
					indexZero = i;
		}

		if (twoZero)
			for (int i = 0; i < nums.length; i++)
				result[i] = 0;
		else if (indexZero != -1) {
			result[indexZero] = 1;
			for (int i = 0; i < nums.length; i++)
				if (indexZero != i) {
					result[i] = 0;
					result[indexZero] *= nums[i];
				}
		} else
			for (int i = 1; i < nums.length; i++) {
				result[i] = result[0] / nums[i] * nums[0];
			}

		return result;
	}

	public static void main(String[] args) {
		int[] result = new ProductExceptSelf().productExceptSelf(new int[] { 1, 0 });

		for (int i : result)
			System.out.print(i + ",");

		System.out.println();
	}

}

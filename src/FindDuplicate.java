import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindDuplicate {
	void sort(int[] nums) {
		int n = nums.length;
		for(int i=n-1; i>=1; i--)
			for(int j=0; j<i; j++) {
				if(nums[j]>nums[j+1]) {
					int temp = nums[j];
					nums[j]=nums[j+1];
					nums[j+1]=temp;
				}
			}
	}
	
	public int findDuplicate(int[] nums) {
		if(nums==null || nums.length==0 || nums.length==1)
			return Integer.MAX_VALUE;
		//sort(nums);
		Arrays.sort(nums);
		int prev = Integer.MAX_VALUE;
		for(int num : nums) {
			if (num==prev)
				return num;
			prev = num;
		}
		
		return Integer.MAX_VALUE;
	}

	public int findDuplicateSet(int[] nums) {
		Set<Integer> set = new HashSet<>();
		
		for(Integer num : nums) {
			if(set.contains(num))
				return num;
			else
				set.add(num);
		}
		
		return Integer.MAX_VALUE;
	}
	
	public static void main(String[] args) {
		System.out.println(new FindDuplicate().findDuplicateSet(
				new int[]{4,3,4,2,2}
				));

	}

}

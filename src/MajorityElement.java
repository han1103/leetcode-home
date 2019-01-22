import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
	public int majorityElement(int[] nums) {
		if (nums==null || nums.length==0)
			return -1;
		if(nums.length<=2)
			return nums[0];
		
		Map<Integer, Integer> map = new HashMap<>();
		int threshold = nums.length/2;
		
		for(int num : nums) {
			Integer count = map.get(num);
			if (count==null)
				count = 0;
			if (++count > threshold)
				return num;
			map.put(num, count);
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(new MajorityElement().majorityElement(new int[]{2,2,1,1,1,2,2}));
	}
}

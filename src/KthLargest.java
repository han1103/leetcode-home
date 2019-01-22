import java.util.HashSet;
import java.util.Set;

public class KthLargest {
	public int findKthLargest(int[] nums, int k) {
		int kthLargest = Integer.MIN_VALUE;
		Set<Integer> indexSet = new HashSet<>();
		
		for(int i=0; i<k; i++) {
			int max = Integer.MIN_VALUE;
			int maxIndex = -1;
			for(int j=0; j<nums.length; j++)
				if(!indexSet.contains(j) && nums[j]>max) {
					max = nums[j];
					maxIndex = j;
				}
			if (i==k-1)
				kthLargest = max;
			indexSet.add(maxIndex);
		}
		
		return kthLargest;
	}
	
	public static void main(String[] args) {
		System.out.println(new KthLargest().findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
	}
}


public class PeakElement {
	int findPeakElementItr(int[] nums) {
		int start = 0, end = nums.length-1;
		
/*		while(start<end) {
			if(end-start==1) {
				if(nums[end]>nums[start])
					return end;
				else
					return start;				
			}
			
			int mid = (start+end)/2;
			if(nums[mid-1]<nums[mid])
				start = mid;
			else
				end = mid-1;
		}
*/
		while(start<end) {
			int mid = (start+end)/2;
			if(nums[mid]<nums[mid+1])
				start = mid+1;
			else
				end = mid;
		}

		return start;
	}

	public int findPeakElement(int[] nums) {
		if (nums == null || nums.length == 0)
			return -1;
		if (nums.length == 1)
			return 0;
		return findPeakElementItr(nums);
	}
	
	public static void main(String[] args) {
		System.out.println(new PeakElement().findPeakElement(new int[]{1,2,1,3,5,6,4}));
	}
}

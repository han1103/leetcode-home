
public class RotatedSortedArraySearch {
	public int searchBinary(int[] nums, int target) {
		if ( nums==null || nums.length==0)
			return -1;
		
		int start=0, end=nums.length-1;
		
		while(start<end) {
			int mid = (start+end)/2;
			
			if ( nums[start] <= nums[mid]) {				
				if ( nums[start] == target)
					return start;
				if ( nums[mid] == target)
					return mid;
				if (nums[start] > target || nums[mid] < target) {
					start = mid+1;
					continue;
				}
				else {
					end = mid-1;
					continue;
				}
			}
			else { // in this case, it must be nums[mid] <= nums[end]
				if ( nums[end] == target)
					return end;
				if ( nums[mid] == target)
					return mid;
				if (nums[mid] > target || nums[end] < target) {
					end = mid-1;
					continue;					
				}
				else {
					start = mid+1;
					continue;
				}
			}
		}
		
		if (nums[start] == target)
			return start;
		else
			return -1;
	}
	
	public int search(int[] nums, int target) {
		return searchBinary(nums, target);
	}
	
	public static void main(String[] args) {
		System.out.println(new RotatedSortedArraySearch().search(new int[]{5,1,3}, 1));
	}
}

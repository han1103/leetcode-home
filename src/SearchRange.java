
public class SearchRange {
	public int[] findRange(int[] nums, int target, int index) {
/*		int start = index;
		int end = index;
		
		while(start-1>=0 && nums[start-1]==target)
			start--;
		while(end+1<=nums.length-1 && nums[end+1]==target)
			end++;
*/		

		int start = findRangeBinary(nums, target, index, true);
		int end = findRangeBinary(nums, target, index, false);
		
		return new int[]{start, end};
	}

	public int findRangeBinary(int[] nums, int target, int index, boolean left) {
		int start;
		int end;
		
		if (left) {
			start = 0;
			end = index;
		}
		else {
			start = index;
			end = nums.length-1;
		}
		
		while(end>start) {
			if(start-end==-1) {
				if (left) {
					if (nums[start]==target)
						return start;
					else if (nums[end]==target)
						return end;
					else
						throw new RuntimeException("no match, Impossible");
				}
				else {
					if (nums[end]==target)
						return end;
					else if (nums[start]==target)
						return start;
					else
						throw new RuntimeException("no match, Impossible"); 
				}
			}
			
			int mid = (start+end)/2;
			if (nums[mid]!=target) {
				if(left)
					start = mid;
				else
					end = mid;
			}
			else {
				if(left)
					end = mid;
				else
					start = mid;
			}					
		}
		
		return start;
	}

	public int[] search(int[] nums, int target, int start, int end) {
		if (start==end) {
			if (nums[start]==target)
				return findRange(nums, target, start);
			else				
				return new int[]{-1, -1};				
		}
		else if (start==end-1) {
			if (nums[start]==target)
				return findRange(nums, target, start);
			else if (nums[end]==target)
				return findRange(nums, target, end);
			else
				return new int[]{-1, -1};

		}
		else {
			int middle = (start+end)/2;
			if (nums[middle]==target) {
				return findRange(nums, target, middle);
			}
			else if (nums[middle]>target)
				return search(nums, target, start, middle);
			else
				return search(nums, target, middle, end);
		}
	}
	
	public int searchFast(int[] nums, int target, boolean left) {
		int start=0, end=nums.length-1;
		
		while(start<end) {
			if (end-start==1) {
				if (left) {
					if (nums[start]==target)
						return start;
					else if (nums[end]==target)
						return end;
					else
						return -1;
				}
				else {
					if (nums[end]==target)
						return end;
					else if (nums[start]==target)
						return start;
					else
						return -1;					
				}							
			}
			
			if (nums[start] > target || nums[end] < target)
				return -1;
			
			int mid = (start+end)/2;
			if (nums[mid]>target) {
				end = mid-1;
			}
			else if (nums[mid]<target) {
				start = mid+1;
			}
			else {
				if (left)
					end = mid;
				else
					start = mid;				
			}
		}
		
		if ( nums[start]==target)
			return start;
		else
			return -1;
	}
	
    public int[] searchRange(int[] nums, int target) {
    	if (nums==null || nums.length==0 || nums[0] > target || nums[nums.length-1]<target) {
    		return new int[]{-1, -1};
    	}
    	
    	//return search(nums, target, 0, nums.length-1);
    	int start = searchFast(nums, target, true);
    	if (start==-1)
    		return new int[]{-1,-1};
    	
    	int end = searchFast(nums, target, false);
    	
    	return new int[]{start, end};
    }
    
    public static void main(String[] args) {
    	int[] range = new SearchRange().searchRange(new int[]{0,0,1,1,1,4,5,5}, 0);
    	System.out.println("["+range[0]+","+range[1]+"]");
    }
}

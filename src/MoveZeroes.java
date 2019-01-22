
public class MoveZeroes {
	public static void main(String[] args) {
		int[] nums = new int[]{1,2,33,3,4,5};
		new MoveZeroes().moveZeroesGood(nums);
		
		for(int num: nums) 
			System.out.print(num+",");				
	}
	
	private void shift(int[] nums, int numZeros, int i, int currentLen) {
		for(int j=i; j<currentLen; j++)
			nums[j-numZeros] = nums[j];
		for(int j=0; j<numZeros; j++)
			nums[currentLen-1-j]=0;
	}
	
	public void moveZeroes(int[] nums) {
		if (nums==null || nums.length==1)
			return;
		int i = 0;		
		int currentLen = nums.length; 
		while(i < currentLen) {
			int numZeros = 0;
			int endI=i;
			while(nums[endI]==0) {				
				if (endI+1 < currentLen) {
					endI++;
					numZeros++;
				}
				else {
					return;
					//break;
				}
			}
			shift(nums, numZeros, endI, currentLen);
			currentLen-=numZeros;
			i++;
		}
	}
	
	public void moveZeroesGood(int[] nums) {
		int index = 0;
		
		for(int i=0; i<nums.length; i++) {
			if (nums[i]!=0) {
				nums[index] = nums[i];
				index++;
			}
		}
		
		for(int i=index; i<nums.length; i++)
			nums[i]=0;
	}
}

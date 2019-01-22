
public class MissingNumber {
    public int missingNumber(int[] nums) {
    	int completeSum = (nums.length+1)*nums.length/2;
    	
    	int actualSum = 0;
    	for(int num : nums)
    		actualSum+=num;
    	
    	return completeSum-actualSum;        
    }
    
    public static void main(String[] args) {
    	System.out.println(new MissingNumber().missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }
    
}

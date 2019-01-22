
public class RemoveDuplicate {
	public static void main(String[] args) {
		int[] nums = {0,0,1,1,1,2,2,3,3,4};
		
		int len = removeDuplicatesFast3(nums);
		System.out.println("len:"+len);
		
		for(int num:nums)
			System.out.print(num + " ");
	}
	
    public static int removeDuplicates1(int[] nums) {
        int len = nums.length;
        int index = 1;
        
        while(index<len) {
       	 if (nums[index-1]==nums[index]) {
       		 for(int i=index; i<len-1; i++)
       			 nums[i]=nums[i+1];
       		 len--;
       	 }
       	 else 
       		 index++;
        }
        
        return len;
        
    }
    
    public static int removeDuplicatesFast1(int[] nums) {
    	if ( nums==null || nums.length==0) 
    		return 0;
    	int i=0;
    	for(int num:nums) {
    		if ( num!=nums[i] ) {
    			i++;
    			nums[i]=num;
    		}
    	}
    	
    	return i+1;
    }

    public static int removeDuplicatesFast2(int[] nums) {
    	if ( nums==null || nums.length==0) 
    		return 0;
    	int numDup=0;
    	int len=1;
    	int val = nums[0];
    	for(int i=1; i<nums.length; i++) {
    		if ( nums[i]==val) 
    			numDup++;
    		else {
    			nums[i-numDup] = nums[i];
    			val = nums[i];
    			len++;
    		}
    	}
    	return len;
    }

    public static int removeDuplicatesFast3(int[] nums) {
    	if ( nums==null || nums.length==0) 
    		return 0;
    	int len=1;
    	for(int i=1; i<nums.length; i++) {
    		if(nums[i] != nums[i-1]) {
    			nums[len] = nums[i];
    			len++;
    		}
    		
    	}
    	return len;
    }

    public static int removeDuplicates(int[] nums) {
     int len = nums.length;
     int index = 1;
     
     while(index<len) {
    	 if (nums[index-1]==nums[index]) {
    		 int lap=1;
    		 while(index+lap<len && nums[index+lap]==nums[index-1]) {
    			 lap++;    			 
    		 }
    		 for(int i=index+lap; i<len; i++)
    			 nums[i-lap]=nums[i];
    		 len-=lap;
    	 }
    	 index++;
     }
     
     return len;
    }
}

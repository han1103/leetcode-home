
public class Rotate {
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7};
		int k=3;
		
/*		int[] nums = {-1,-100,3,99};
		int k=2;
*/		rotate3(nums, k);
				
		for(int num:nums)
			System.out.print(num+ " ");
	}
	
	public static void rotate2(int[] nums, int k) {
		/*
		 * prev = a[n-1]
		 * 
		 * tmp = a[0];
		 * a[0] = prev;
		 * prev = tmp;
		 * 
		 * tmp = a[1];
		 * a[1] = prev;
		 * prev = tmp;
		 * 
		 */
		for(int i=0; i<k; i++) {
			int prev = nums[nums.length-1];
			for(int j=0; j<nums.length; j++) {
				int tmp = nums[j];
				nums[j] = prev;
				prev = tmp;
			}
		}
	}
	

	public static void rotate3(int[] nums, int k) {
		/*
		 * 1 2 3 4 5 6 7 k =3
		 * Reverse the whole array
		 * 7 6 5 4 3 2 1
		 * Reverse the 1st k=3
		 * 5 6 7 4 3 2 1
		 * Reverse the 1ast n-k=4
		 * 5 6 7 1 2 3 4
		 */
		// Reverse the whole array
		for(int i=0; i<nums.length/2 ; i++) {
			int temp = nums[i];
			nums[i]=nums[nums.length-1-i];
			nums[nums.length-1-i]=temp;
		}
		
		// Reverse the 1st k=3
		for(int i=0; i<k/2; i++) {
			int temp = nums[i];
			nums[i]=nums[k-1-i];
			nums[k-1-i]=temp;
		}

		// Reverse the 1ast n-k=4
		for(int i=k; i<(nums.length-k)/2; i++) {
			int temp = nums[i];
			nums[i]=nums[nums.length-1-(i-k)];
			nums[nums.length-1-(i-k)]=temp;
		}
	}
	
	public static void rotate1(int[] nums, int k) {
		int len = nums.length;
		for (int i = 0; i < k; i++) {
			int tmp1 = nums[0];
			int tmp2 = Integer.MAX_VALUE;
			boolean isOne=true;

			/*
			 * t1=a0
			 * 
			 * t2=a1
			 * a1=t1
			 * 
			 * t1=a2
			 * a2=t2
			 * 
			 * t2=a3
			 * a3=t1
			 *...
			 */
			for (int j = 1; j <= len; j++) {
				if ( isOne) {
					tmp2 = nums[j%len];
					nums[j%len] = tmp1;
					isOne = false;
				}
				else {
					tmp1 = nums[j%len];
					nums[j%len] = tmp2;
					isOne = true;					
				}
			}
		}
	}

	public static void rotate(int[] nums, int k) {
		int len = nums.length;
		for (int i = 0; i < k; i++) {
			int tmp1;
			int tmp2 = nums[0];

			/*
			 * t2=a0
			 * 
			 * t1=a1
			 * a1=t2
			 * t2=a2
			 * a2=t1
			 * 
			 * t1=a3
			 * a3=t2
			 * t2=a4
			 * a4=t1
			 */
			for (int j = 1; j <= len; j += 2) {
				tmp1 = nums[j % len];
				nums[j % len] = tmp2;
				if (j != len) {
					tmp2 = nums[(j + 1) % len];
					nums[(j + 1) % len] = tmp1;
				}
			}
		}
	}
}

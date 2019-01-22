
public class MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int index = 0;
		for(int i=0; i<n; i++) {
			boolean found = false;
			for(int j=index; j<m+i; j++) {
				if(nums1[j]>=nums2[i]) {
					index = j;
					found = true;
					break;
				}				
			}
			if(!found)
				index = m+i;
			for(int k=m+i; k>index; k--) {
				nums1[k]=nums1[k-1];
			}
			nums1[index]=nums2[i];			
		}
	}

	public void mergeFast(int[] nums1, int m, int[] nums2, int n) {
		int index = m+n-1;
		int i1 = m-1;
		int i2 = n-1;
		
		while(i1>=0 && i2>=0) {
			if ( nums1[i1] > nums2[i2]) {
				nums1[index] = nums1[i1];
				i1--;				
				index--;
			}
			else {
				nums1[index] = nums2[i2];
				i2--;				
				index--;				
			}
		}
		
		if(i1<0)
			for(int i=0; i<=i2; i++)
				nums1[i] = nums2[i];
	}

	public static void main(String[] args) {
		int[] nums1 = new int[]{1,2,3,0,0,0};
		new MergeSortedArray().mergeFast(nums1, 3, new int[]{2,5,6}, 3);
		
		for(int num : nums1)
			System.out.print(num+",");
		System.out.println();
	}
}

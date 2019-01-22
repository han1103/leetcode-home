import java.util.LinkedList;
import java.util.List;

public class Intersect {

	public int[] intersect(int[] nums1, int[] nums2) {
		List<Integer> list = new LinkedList<>();

		List<Integer> nums2List = new LinkedList<>();
		for (int num2 : nums2)
			nums2List.add(num2);

		for (int num1 : nums1)
			for (int i = 0; i < nums2List.size(); i++)
				if (num1 == nums2List.get(i)) {
					list.add(num1);
					nums2List.remove(i);
					break;
				}

		int[] result = new int[list.size()];
		for (int i = 0; i < list.size(); i++)
			result[i] = list.get(i);

		return result;
	}
}

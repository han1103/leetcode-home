import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> setNums = new HashSet<>();
		for(int num : nums) {
			if(setNums.contains(num))
				return true;
			else
				setNums.add(num);
		}
		
		return false;
	}
}

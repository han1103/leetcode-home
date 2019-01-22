import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        Set<Integer> setNums = new HashSet<>();
        
        for(int num:nums) {
        	if(setNums.contains(num)) {
        		setNums.remove(num);
        	}
        	else {
        		setNums.add(num);
        	}
        }
        
        return setNums.iterator().next();
    }
}

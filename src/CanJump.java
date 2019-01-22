import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CanJump {
	private static enum Status{
		UNKNOWN,
		BAD,
		GOOD
	};
	
	public static void main(String[] args) {
		// System.out.println(new CanJump().canJump(new
		// int[]{2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6}));
		System.out.println(new CanJump().canJumpDyna(new int[] { 5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0 }));
		//System.out.println(new CanJump().canJump1(new int[] { 5, 9, 0 }));
	}

	private boolean canArrive(int[] nums, int currIndex, int targetIndex) {
		int maxSteps = nums[currIndex];
		if (currIndex + maxSteps >= targetIndex)
			return true;
		else
			return false;
	}

	public boolean canJump(int[] nums) {
		if (nums == null || nums.length == 0)
			return false;
		if (nums.length == 1)
			return true;

		List<Integer> reachableNodes = new LinkedList<>();
		reachableNodes.add(nums.length - 1);

		while (!reachableNodes.isEmpty()) {
			int targetIndex = reachableNodes.remove(0);
			for (int i = 0; i < targetIndex; i++) {
				// if (canArrive(nums, i, targetIndex))
				if (i + nums[i] >= targetIndex)
					if (i == 0)
						return true;
					else
						reachableNodes.add(0, i);
			}
		}

		return false;
	}

	private Map<Integer, Boolean> mapPosition = new HashMap<>();

	public boolean canJumpFromPosition(int position, int[] nums) {
		int maxPosition = Math.min(position + nums[position], nums.length - 1);

		if (maxPosition == nums.length - 1)
			return true;
		for (int i = position + 1; i <= maxPosition; i++) {
			Boolean canReach = mapPosition.get(i);
			if (canReach == null) {
				canReach = canJumpFromPosition(i, nums);
				mapPosition.put(i, canReach);
			}
			if (canReach) {
				mapPosition.put(position, true);
				return true;
			}
		}

		mapPosition.put(position, false);
		return false;
	}

	public Status[] buildPosition(int[] nums) {
		Status[] statuses = new Status[nums.length];
		for(Status status : statuses)
			status = Status.UNKNOWN;

		statuses[nums.length-1] = Status.GOOD;
		

		for(int i = nums.length-2; i>=0; i--) {
			boolean foundGood = false;
			for(int j = i+1; j<=Math.min(i+nums[i], nums.length-1) && !foundGood; j++)
				if(statuses[j]==Status.GOOD)
					foundGood = true;
			if (foundGood)
				statuses[i] = Status.GOOD;
			else
				statuses[i] = Status.BAD;					
		}
        return statuses;
	}

	public boolean canJumpDyna(int[] nums) {		
		Status[] statuses = buildPosition(nums);
		return statuses[0]==Status.GOOD;
	}

	public boolean canJumpRec(int[] nums) {
		mapPosition.put(nums.length - 1, true);
		return canJumpFromPosition(0, nums);
	}
	
    public boolean canJumpFromPosition1(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition1(nextPosition, nums)) {
                return true;
            }
        }

        return false;
    }

    public boolean canJump1(int[] nums) {
        return canJumpFromPosition1(0, nums);
    }	
}

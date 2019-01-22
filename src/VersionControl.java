public class VersionControl {
	public static void main(String[] args) {
		System.out.println(firstBadVersion1(10));
	}

	private static boolean isBadVersion(int n) {
		switch (n) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
			return false;
		case 7:
		case 8:
		case 9:
		case 10:
		case 11:
		case 12:
			return true;
		default:
			return true;
		}

	}

	public static int firstBadVersion1(int n) {
		for (int i = 1; i <= n; i++)
			if (isBadVersion(i))
				return i;
		return -1;
	}

	public static int firstBadVersion2(int n) {
		int left = 1;
		int right = n;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (isBadVersion(mid)) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	public static int firstBadVersion(int n) {
		int low = 1;
		int high = n;

		while (high - low > 1) {
			int center = (low + high) / 2;
			if (!isBadVersion(center)) {
				low = center;
			} else {
				high = center;
			}
		}

		if (high == low) {
			if (isBadVersion(high))
				return high;
			else
				return -1;
		} else {
			if (isBadVersion(low))
				return low;
			else if (isBadVersion(high))
				return high;
			else
				return -1;
		}
	}
}

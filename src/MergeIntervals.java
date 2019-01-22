import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

class ComparatorInterval implements Comparator<Interval> {

	@Override
	public int compare(Interval o1, Interval o2) {
		return o1.start - o2.start;
	}

}

public class MergeIntervals {

	public List<Interval> merge(List<Interval> intervals) {

		Collections.sort(intervals, new ComparatorInterval());

		for (int i = 0; i < intervals.size(); i++) {
			while(i+1<intervals.size() && intervals.get(i).end >= intervals.get(i+1).start) {
					intervals.get(i).end = Math.max(intervals.get(i).end, intervals.get(i+1).end);
					intervals.remove(i+1);
			}
		}

		return intervals;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Interval> intervals = new LinkedList<>();
		intervals.add(new Interval(1, 4));
		intervals.add(new Interval(0, 2));		
		intervals.add(new Interval(3, 5));

		new MergeIntervals().merge(intervals);

		for (Interval interval : intervals)
			System.out.println(interval.start + "," + interval.end);

	}

}

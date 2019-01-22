import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TopKFrequent {
	private Map<Integer, Integer> mapOcurr = new HashMap<>();

	private class Ocurr implements Comparable<Ocurr> {
		private int numOcurr;
		private int num;

		public Ocurr(int numOcurr, int num) {
			super();
			this.numOcurr = numOcurr;
			this.num = num;
		}

		@Override
		public int compareTo(Ocurr o) {
			// TODO Auto-generated method stub
			return -1 * new Integer(numOcurr).compareTo(o.numOcurr);
		}

	}

	public List<Integer> topKFrequent(int[] nums, int k) {
		for (int num : nums) {
			Integer ocurr = mapOcurr.get(num);
			if (ocurr == null)
				mapOcurr.put(num, 1);
			else
				mapOcurr.put(num, ocurr + 1);
		}

		List<Ocurr> ocurrs = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : mapOcurr.entrySet()) {
			ocurrs.add(new Ocurr(entry.getValue(), entry.getKey()));
		}
		Collections.sort(ocurrs);

		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			result.add(ocurrs.get(i).num);
		}

		return result;
	}

	public List<Integer> topKFrequentNew(int[] nums, int k) {
		for (int num : nums) {
			mapOcurr.put(num, mapOcurr.getOrDefault(num, 0)+1);
		}

		List<Map.Entry<Integer, Integer>> ocurrs = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : mapOcurr.entrySet()) {
			ocurrs.add(entry);
		}
		Collections.sort(ocurrs, new Comparator<Map.Entry<Integer, Integer>>() {
			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				// TODO Auto-generated method stub
				return o2.getValue().compareTo(o1.getValue());
			}		
		});

		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			result.add(ocurrs.get(i).getKey());
		}

		return result;
	}
	
	public List<Integer> topKFrequentPQ(int[] nums, int k) {
		for (int num : nums) {
			mapOcurr.put(num, mapOcurr.getOrDefault(num, 0)+1);
		}
		
		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {

			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				// TODO Auto-generated method stub
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		
		pq.addAll(mapOcurr.entrySet());

		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			result.add(pq.poll().getKey());
		}

		return result;
		
	}
	
	public static void main(String[] args) {
		List<Integer> list = new TopKFrequent().topKFrequentPQ(new int[] { 1, 1, 1, 2, 2, 3,3,3,4 }, 2);
		for (int num : list)
			System.out.print(num + " ");
		System.out.println();
	}
}

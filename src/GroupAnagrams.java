import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class GroupAnagrams {
	public static void main(String[] args) {
		List<List<String>> listOfList = new GroupAnagrams().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
		
		for(List<String> list:listOfList) {
			for(String str:list)
				System.out.print(str+",");
			System.out.println();
		}
	}
	
	private static class WordCount {
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((countMap == null) ? 0 : countMap.hashCode());
			return result;
		}

		static boolean equalsCountMap(Map<Character, Integer> countMap1, Map<Character, Integer> countMap2) {
			if ( countMap1.size()!=countMap2.size())
				return false;
			for(Entry<Character, Integer> entry : countMap1.entrySet()) {
				if(entry.getValue()!=countMap2.get(entry.getKey()))
					return false;
				
			}
			return true;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			WordCount other = (WordCount) obj;
			if (countMap == null) {
				if (other.countMap != null)
					return false;
			} else if (!WordCount.equalsCountMap(countMap,other.countMap))
				return false;
			return true;
		}

		public WordCount(Map<Character, Integer> countMap) {
			super();
			this.countMap = countMap;
		}

		private Map<Character, Integer> countMap;

	
		
	};
	
	private WordCount buildWordCount(String str) {
		Map<Character, Integer> countMap = new HashMap<>();
		for(int i=0; i<str.length(); i++) {
			Character c = str.charAt(i);
			Integer value = countMap.get(c);
			if(value!=null)
				countMap.put(c, ++value);
			else
				countMap.put(c, 0);
		}
		return new WordCount(countMap);
	}
	
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> retList = new ArrayList<>();  
		
		if (strs==null || strs.length==0)
			return retList;
			
		Map<WordCount, List<String>> map = new HashMap<>();
		for(String str : strs) {
			WordCount wc = buildWordCount(str);
			List<String> listValue = map.get(wc);
			if (listValue==null) {
				listValue = new LinkedList<>();
			}
			listValue.add(str);
			map.put(wc, listValue);
		}
		
		for(List<String> valueEntry : map.values())
			retList.add(valueEntry);
		
		return retList;
	}
}

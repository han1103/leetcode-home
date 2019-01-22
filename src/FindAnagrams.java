import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagrams {
	Map<Character, Integer> pMap = new HashMap<>();
	Map<Character, Integer> sMap = new HashMap<>();
	
	boolean isAnagram(String s, int index, int length) {
		if(index==0) {
			for(int i=index; i<index+length; i++) {
				char key = s.charAt(i);
				if(pMap.containsKey(key))
					pMap.put(key, pMap.get(key)-1);						
				else
					sMap.put(key, sMap.getOrDefault(key, 0)+1);
			}
		}
		else {
			char removeChar = s.charAt(index-1);
			char addChar = s.charAt(index-1+length);
			if(pMap.containsKey(removeChar))
				pMap.put(removeChar, pMap.get(removeChar)+1);
			else
				sMap.put(removeChar, sMap.get(removeChar)-1);
			if(pMap.containsKey(addChar))
				pMap.put(addChar, pMap.get(addChar)-1);
			else
				sMap.put(addChar, sMap.getOrDefault(addChar, 0)+1);
		}
		
		for(int value : pMap.values())
			if(value!=0)
				return false;
		for(int value : sMap.values())
			if(value!=0)
				return false;
		
		return true;
	}
	
	public List<Integer> findAnagrams(String s, String p) {
		if(s==null || s.length()==0 || p==null || p.length()==0)
			return new ArrayList<>();
		
		List<Integer> list = new ArrayList<>();

		int sLen = s.length();
		int pLen = p.length();

		for(int i=0; i<pLen; i++) {
			Character key = p.charAt(i);
			pMap.put(key, pMap.getOrDefault(key, 0)+1);
		}
				
		for(int i=0; i<=sLen-pLen; i++) {
			if(isAnagram(s, i, pLen))
				list.add(i);
		}
					
		return list;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new FindAnagrams().findAnagrams("cbaebabacd", "abc");

		for (int i : list)
			System.out.print(i + ",");
		System.out.println();
	}

}

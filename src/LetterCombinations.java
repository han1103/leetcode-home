import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
	private Map<Character, String> keyMap = new HashMap<>();
	
	private String[] keyArr = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	
	public LetterCombinations() {
		keyMap.put('2', "abc");
		keyMap.put('3', "def");
		keyMap.put('4', "ghi");
		keyMap.put('5', "jkl");
		keyMap.put('6', "mno");
		keyMap.put('7', "pqrs");
		keyMap.put('8', "tuv");
		keyMap.put('9', "wxyz");
	}
	
	public static void main(String[] args) {
		List<String> listStr = new LetterCombinations().letterCombinations("23");
		for(String str:listStr)
			System.out.println(str);
	}
	
	private List<String> letterCombinationsRec(String digits) {
		List<String> listStr = new LinkedList<>();
		
		if ( digits.length()==1 ) {
			//String str = keyMap.get(digits.charAt(0));
			String str = keyArr[digits.charAt(0)-'2'];
			for(int i=0; i<str.length(); i++) {
				listStr.add(str.substring(i, i+1));
			}
		}
		else {
			List<String> preListStr = letterCombinationsRec(digits.substring(0, digits.length()-1));
			//String lastStr = keyMap.get(digits.charAt(digits.length()-1));
			String lastStr = keyArr[digits.charAt(digits.length()-1)-'2'];
			for(String str : preListStr) {				
				for(int i=0; i<lastStr.length(); i++) {
					listStr.add(str+lastStr.substring(i, i+1));
				}
			}
		}
		return listStr;
	}
	
	public List<String> letterCombinations(String digits) {
		List<String> listStr = new LinkedList<>();
		
		if (digits!=null && digits.length()>0) {
			listStr = letterCombinationsItr(digits);
		}
		
		return listStr;
	}
	
	private List<String> letterCombinationsItr(String digits) {		
		List<String> listStr = new LinkedList<>();
		//String str = keyMap.get(digits.charAt(0));
		String str = keyArr[digits.charAt(0)-'2'];
		for(int i=0; i<str.length(); i++) {
			listStr.add(str.substring(i, i+1));
		}

		for(int i=1; i<digits.length(); i++) {
			//str = keyMap.get(digits.charAt(i));
			str = keyArr[digits.charAt(i)-'2'];
			List<String> preListStr = new LinkedList<>();
			for(String strItem: listStr)
				preListStr.add(strItem);		
			listStr = new LinkedList<>();
			for(String strItem : preListStr) {
				for(int j=0; j<str.length(); j++)
					listStr.add(strItem+str.substring(j, j+1));
			}
		}
		
		return listStr;
	}
}

package medium;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
	boolean isPalindrome(String s) {
		int len = (s.length()-1)/2;
		for(int i=0; i<=len; i++) {
			if(s.charAt(i)!=s.charAt(s.length()-1-i))
				return false;
		}
		
		return true;
	}
	void backtrack(List<List<String>> answer, String s, List<String> currList, int currIndex) {
		if(!currList.isEmpty() && !isPalindrome(currList.get(currList.size()-1)))
			return;
		if(currIndex==s.length())
			answer.add(new ArrayList<>(currList));
		for(int i=currIndex+1; i<=s.length(); i++) {
			currList.add(s.substring(currIndex, i));
			backtrack(answer, s, currList, i);
			currList.remove(currList.size()-1);
		}
				
	}
	
	public List<List<String>> partition(String s) {
		List<List<String>> answer = new ArrayList<>();
		backtrack(answer, s, new ArrayList<>(), 0);
		
		return answer;		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<String>> answer = new PalindromePartition().partition("aabacded");
		System.out.println("--------------");
		for (List<String> list : answer) {
			for (String num : list)
				System.out.print(num + ",");
			System.out.println();
		}			
	}

}


public class PalindromicSubstrings {
	boolean isPalindromic(String s) {
		int len = s.length();
		
		for(int i=0; i<len/2; i++) {
			if(s.charAt(i)!=s.charAt(len-1-i))
				return false;
		}
		return true;
	}
	public int countSubstrings(String s) {
		if(s==null || s.length()==0)
			return 0;
		
		if(s.length()==1)
			return 1;
		
		int count = countSubstrings(s.substring(0, s.length()-1));
		
		for(int i=0; i<=s.length()-2; i++)
			if(isPalindromic(s.substring(i)))
				count++;			
		count++;
		
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(new PalindromicSubstrings().countSubstrings("abc"));
	}

}

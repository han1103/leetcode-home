import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateParenthesis {
	List<String> generateRec(int n) {
		List<String> list = new ArrayList<>();
		if (n==0)
			list.add("");
		if (n==1)
			list.add("()");
		else {
			List<String> preList = generateRec(n-1);
			Set<String> set = new HashSet<>();
			for(String s : preList) {			
				for(int i=0; i<=s.length(); i++) {
					String newSI;
					if (i==0)
						newSI = "(" + s;
					else if (i==s.length())
						newSI = s+"(";
					else
						newSI = s.substring(0, i)+"("+s.substring(i);
					for(int j=i+1; j<=newSI.length(); j++) {
						String newSJ;
						if (j==newSI.length())
							newSJ = newSI+")";
						else
							newSJ = newSI.substring(0, j)+")"+newSI.substring(j);
						set.add(newSJ);
					}						
				}
			}
			list.addAll(set);		
		}
		
		
		return list;
	}

	List<String> generateRecNew(int n) {
		List<String> list = new ArrayList<>();
		if (n==0)
			list.add("");
		if (n==1)
			list.add("()");
		else {
			List<String> preList = generateRecNew(n-1);
			Set<String> set = new HashSet<>();
			for(String s : preList) {			
				for(int i=0; i<s.length(); i++) {
					String newSI = s.substring(0, i+1)+"()"+s.substring(i+1);
					set.add(newSI);
				}						
			}
			list.addAll(set);		
		}
		
		
		return list;
	}
	
	List<String> generateParenthesis(int n) {
		return generateRecNew(n);
	}
	
	public static void main(String[] args) {
		List<String> list = new GenerateParenthesis().generateParenthesis(2);
		for(String str : list)
			System.out.println(str);
	}
}

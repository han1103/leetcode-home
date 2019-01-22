import java.util.EmptyStackException;
import java.util.Stack;

public class ValidParentheses {
	boolean isOpenParen(char c) {
		switch (c) {
		case '(':
		case '[':
		case '{':
			return true;
		default:
			return false;
		}
	}
	
	boolean isMatchingParen(char c1, char c2) {
		if (c2=='[' && c1==']')
			return true;
		if (c2=='{' && c1=='}')
			return true;
		if (c2=='(' && c1==')')
			return true;
		if (c1=='[' && c2==']')
			return true;
		if (c1=='{' && c2=='}')
			return true;
		if (c1=='(' && c2==')')
			return true;
		
		return false;
	}

	public boolean isValid(String s) {
		Stack<Character> openParenStack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (isOpenParen(c)) {
				openParenStack.push(c);
			} else {
				try {
					char preOpenParen = openParenStack.pop();
					if (!isMatchingParen(c, preOpenParen))
						return false;

				} catch (EmptyStackException e) {
					return false;
				}
			}
		}
		if (!openParenStack.isEmpty())
			return false;
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new ValidParentheses().isValid("()"));
	}
}

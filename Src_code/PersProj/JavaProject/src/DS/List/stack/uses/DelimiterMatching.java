package DS.List.stack.uses;

/**
 * As the string is read, each opening delimiter is placed on the stack. Each closing
delimiter read from the input is matched with the opening delimiter popped from
the top of the stack. If they form a pair, all is well. Non-delimiter characters are not
inserted on the stack; they’re ignored.
 */

import DS.List.stack.GenericStack;

public class DelimiterMatching {
	public static void main(String args[]){
		String expression = "a{b(c[d]e)f}";	
		DelimiterMatching dm = new DelimiterMatching();
		if (dm.expressionCheck(expression)){
			System.out.println (" Expression " + expression +   " is a valid expression"); 
		}else {
			System.out.println (" Expression " + expression +   " is a invalid expression"); 
		}		
		
	}
	
	boolean expressionCheck (String expression) {
		char[] expr = expression.toCharArray(); 
		int size = expression.length();
		Character[] StackContainer = new Character[size];
		GenericStack<Character> myStack = new GenericStack<Character>(size, StackContainer);
		
		for (int i =0; i < expr.length; i++){
			Character chr = expr[i];
			
			if (expr[i] == '{' ||  expr[i] == '[' ||  expr[i] == '(' ) {
				myStack.push(expr[i]);
			}
			
			if (expr[i] == '}' ||  expr[i] == ']' ||  expr[i] == ')' ) {
				Character popped = myStack.pop();
				if (popped == null ) {
					return false;
				}
				boolean pairvalidated = pairChecking(popped,expr[i]);
				if (!pairvalidated){
					return false;
				}
			}			
		}
		
		Character more = myStack.peek();
		if (more == null){
			return true;
		}else {
			return false;
		}
		
	}
	
	boolean pairChecking(char char1, char char2 ) {
		
		if (char1 == '{') {
			if (char2 == '}') {
				return true;
			}else {
				return false;
			}
		}
		
		if (char1 == '[') {
			if (char2 == ']') {
				return true;
			}else {
				return false;
			}
		}
		
		if (char1 == '(') {
			if (char2 == ')') {
				return true;
			}else {
				return false;
			}
		}
		
		return false;
	}
		
}

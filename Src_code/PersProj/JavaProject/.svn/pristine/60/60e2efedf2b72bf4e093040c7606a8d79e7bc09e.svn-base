package Interview.GE;

import java.util.Stack;
import java.util.StringTokenizer;


public class countBracket {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count =  getCountOfOuterBrackets("(((a+b)*(c+d)))");
		
		System.out.println("OuterBracket " + count);
	}

	
	 static int getCountOfOuterBrackets(String expression) {
	        Stack <String> stack = new Stack<String>();
	        
	        StringTokenizer tokens = new StringTokenizer(expression, "()*/+-", true);
	        int outerBracketCnt = 0;
	        while(tokens.hasMoreTokens()){
	            
	            String tkn = tokens.nextToken();
	            if(tkn.equals("(") || tkn.equals("*") || tkn.equals("/") || tkn.equals("+") || tkn.equals("-") || tkn.matches("[0-9]+")){
	                stack.push(tkn);
	                if(tkn.equals("(")) {
	                          	outerBracketCnt++;
	                    }
	                
	            } else if(tkn.equals(")")){
	            	outerBracketCnt--;
	                String firstOprnd = stack.pop();
	                int op1 = Integer.parseInt(firstOprnd);
	                String oprnd = stack.pop();
	                int op2;
	                if(stack.isEmpty()){
	                    break;
	                } else {
	                 String secondOprnd = stack.pop();
	                 op2 = Integer.parseInt(secondOprnd);
	                }
	                
	                if(!stack.isEmpty()){
	                    stack.pop();
	                }
	                int result =0;
	                if (oprnd.equals("*")) {
	                    result = op1 * op2;
	                } else if ( oprnd.equals("/")) {
	                    result = op1 / op2;
	                } else if (oprnd.equals("+")) {
	                    result = op1 + op2;
	                } else if (oprnd.equals("-")) {
	                    result = op1 - op2;
	                }
	                stack.push(result+"");
	                
	            }        
	            
	        }
	                                         
	         return outerBracketCnt;
	 
	    }
}

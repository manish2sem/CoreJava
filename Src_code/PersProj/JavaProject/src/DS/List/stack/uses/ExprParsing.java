package DS.List.stack.uses;
/**
Parsing Arithmetic Expressions
an important application parsing (that is, analyzing) arithmetic expressions such as  ((2+4)*7)+3*(9–5). 
The storage structure it uses is the stack. 
Stacks are used in a similar[delimiters Matching], although more complicated, way for parsing arithmetic expressions.
it’s fairly difficult, at least for a computer algorithm, to evaluate an
arithmetic expression directly. It’s easier for the algorithm to use a two-step process:
Transform the arithmetic expression into a different format, called postfix notation.
2. Evaluate the postfix expression.

Postfix Notation[also called Reverse Polish Notation, or RPN]
the operator follows the two operands.
A+B–C AB+C–
A*(B+C) ABC+*
A+B*(C–D/(E+F)) ABCDEF+/–*+

there’s also a prefix notation, in which the operator is
written before the operands: +AB instead of AB+. This notation is functionally
similar to postfix but seldom used.

Translating Infix to Postfix
read the infix from left to right, looking at each character in turn.
copy these operands and operators to the postfix output string.
The trick is knowing when to copy what.
If the character in the infix string is an operand, copy it immediately to the postfix string
Knowing when to copy an operator is more complicated
Whenever you could have used the operator to evaluate
part of the infix expression copy it to the postfix string.
A*(B+C) ABC+*
You can’t write an operator
to the output (postfix) string if it’s followed by a higher-precedence operator or a
left parenthesis. If it is, the higher-precedence operator or the operator in parentheses
must be written to the postfix before the lower-priority operator.

Saving Operators on a Stack
Algorithm :
Operand - Write it to postfix string
Open parenthesis ( - Push it on stack
Close parenthesis ) - While stack not empty;
			Pop an item,
			If item is not (, write it to postfix string
		     Quit loop if item is (
Operator - If stack empty, 
		Push oprtr
	   else	
		Pop an item
		If item is (, push it,
		If item is an operator(opThis), and 
			If opTop < opThis, push opTop, or
			If opTop >= opThis, output opTop
Quit loop if opTop < opThis or item is (
Push opThis

No more items -  While stack not empty, 
			Pop item, and write it to postfix string.
*/


public class ExprParsing {

}

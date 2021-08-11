package DessignPattern.Other.Behavioral.Template.A_Core.ImplCls;

import DessignPattern.Other.Behavioral.Template.A_Core.AbsCls.CrossCompiler;

public class AndroidCompiler extends CrossCompiler {
	protected void collectSource() {
		System.out.println("This is collectSource of AndroidCompiler");
	}
	protected void compileToTarget() {
		System.out.println("This is compileToTarget of AndroidCompiler");
	}
}
package DessignPattern.Other.Behavioral.Template.A_Core.AbsCls;


/**
 * The AbstractClass contains the templateMethod(), which should be made final so that it cannot be overridden. 
 * This template method makes use of other operations available in order to run the algorithm, 
 * but is decoupled for the actual implementation of these methods. 
 * 
 * All operations used by this template method are made abstract, so their implementation is deferred to subclasses.
 * @author Manish
 *
 */
public abstract class CrossCompiler {

	public final void crossCompile() {
		collectSource();
		compileToTarget();
	}
	//Template methods
	protected abstract void collectSource();
	protected abstract void compileToTarget();

}

/**
 * crossCompile() method being the glue for the whole algorithm to run.
 */
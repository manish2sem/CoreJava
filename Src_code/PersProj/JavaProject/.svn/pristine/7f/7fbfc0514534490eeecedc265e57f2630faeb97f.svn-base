package CoreJava.J_Essential.InnerClasses.Anonymous;

/**
 * 
 *
 */

public class AnonymousInArgument {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

			Bar bar = new Bar();
			bar.doStuff(new Foo(){
				public void foom(){
					System.out.println("Implementing foom as Anonymous");
				}
			});
			// Above is similar to following + class FooImplementer  see->#2
			FooImplementer foo = new FooImplementer();
			bar.doStuff(foo);
	}

}


interface Foo {
	public void foom();
}

class Bar {
	void doStuff(Foo f) {
		System.out.println("Inside bar - DoStuff");
		f.foom();
	}
}


class FooImplementer implements Foo {  //#2
	public void foom(){
		System.out.println("Implementing foom as class");
	}
}
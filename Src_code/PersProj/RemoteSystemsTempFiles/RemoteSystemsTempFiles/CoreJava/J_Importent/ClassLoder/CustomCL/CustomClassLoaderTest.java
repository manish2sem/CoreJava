package CoreJava.J_Importent.ClassLoder.CustomCL;

/**
 * http://www.javafundu.com/2010/01/simple-custom-classloader.html
 * http://kalanir.blogspot.in/2010/01/how-to-write-custom-class-loader-to.html
 * http://www.codeslices.net/snippets/simple-java-custom-class-loader-implementation
 * http://zeroturnaround.com/rebellabs/rebel-labs-tutorial-do-you-really-get-classloaders/8/
 * http://www.onjava.com/pub/a/onjava/2005/01/26/classloading.html
 * http://www.javaworld.com/article/2077260/learn-java/the-basics-of-java-class-loaders.html?page=2
 * http://k2java.blogspot.in/2011/04/writing-custom-class-loader-in-java.html
 * http://www.javalobby.org/java/forums/t18345.html
 * @author sinhama
 *
 */

public class CustomClassLoaderTest {
	 
    public static void main(String [] args) throws Exception{
       CustomClassLoader test = new CustomClassLoader();
       test.loadClass("CoreJava.J_Importent.ClassLoder.CustomCL.HelloWorld");
       System.out.println("No issue");
    /*   
       Class<HelloWorld> cls = test.loadClass("J_Importent.ClassLoder.CustomCL.HelloWorld");       
       HelloWorld myWorld = (HelloWorld) cls.newInstance();
       */
       
       HelloWorld myWorld = (HelloWorld)test.loadClass("CoreJava.J_Importent.ClassLoder.CustomCL.HelloWorld").newInstance();
       myWorld.clsMethod();
     }
}

class HelloWorld{
	
	public HelloWorld(){
		System.out.println("Inside constructor - Hello World Loaded");				
	}
	
	public void clsMethod(){
		System.out.println("This is HelloWorld class");
	}
}



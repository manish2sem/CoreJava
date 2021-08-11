package CoreJava.J_Importent.ClassLoder.A_Basics;

/**
 * Child ClassLoader can see class loaded by Parent ClassLoader but vice-versa is not true. 
 * Which mean if class Abc is loaded by Application class loader than trying to load class ABC explicitly using extension ClassLoader will 
 * throw either java.lang.ClassNotFoundException.
 * 
 * Source - Read more: http://javarevisited.blogspot.com/2012/12/how-classloader-works-in-java.html#ixzz2pCm6gbjg
 * http://www.javaworld.com/article/2077260/learn-java/the-basics-of-java-class-loaders.html?page=2
 * 
 * Why is this rule?
 */

public class E_VisibilityPrinciple {
	
	public static void main(String args[]) {
        try {         
            //printing ClassLoader of this class
            System.out.println("E_VisibilityPrinciple().getClassLoader() : "  + E_VisibilityPrinciple.class.getClassLoader());

         
            //trying to explicitly load this class again using Extension class loader
            Class.forName("J_Importent.ClassLoder.A_Basics.E_VisibilityPrinciple", true,   E_VisibilityPrinciple.class.getClassLoader().getParent());
        } catch (ClassNotFoundException ex) {
            System.out.print(ex);
        }
    }
}

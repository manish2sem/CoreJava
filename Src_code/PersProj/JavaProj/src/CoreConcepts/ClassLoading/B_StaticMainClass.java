package CoreConcepts.ClassLoading;

class StaticComponents
{
     static int staticVariable;
 
     static
     {
          System.out.println("StaticComponents SIB");
          staticVariable = 10;
     }
 
     static void staticMethod()
     {
          System.out.println("From StaticMethod");
          System.out.println(staticVariable);
     }
}
 
public class B_StaticMainClass
{
     static
     {
          System.out.println("MainClass SIB");
     }
 
     public static void main(String[] args)
     {
          System.out.println("From Static Main Method");
          StaticComponents.staticVariable = 20;
          StaticComponents.staticMethod();
     }
}
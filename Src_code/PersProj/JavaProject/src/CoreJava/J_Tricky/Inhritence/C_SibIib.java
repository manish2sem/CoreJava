package CoreJava.J_Tricky.Inhritence;

/**
 * 
 * first all SIB's are executed according to rule.
 * Then IIB's
 * @author Manish
 *
 */

public class C_SibIib {
	public static void main(String[] args) {
        B2 b = new B2();
    }
}

class A2
{
    static String s = "AAA";
 
    static
    {
        s = s + "BBB";
    	System.out.println("A2 SIB : "+s);

    }
 
    {
    	s = "AAABBB";
    	System.out.println("A2 IIB : "+s);

    }
}
 
class B2 extends A2
{
    static
    {
    	s = s + "BBBAAA";
    	System.out.println("B2 SIB : "+s);

    }
 
    {
    	System.out.println(s);
    	System.out.println("B2 IIB : "+s);
    }
}
 

package CoreJava.J_Tricky.Inhritence;

public class D_ParentRefVar extends ClassOne{

    static
    {
        i++;
    	System.out.println("child cls : "+i);

    }
 
    static
    {
        --j;
    	System.out.println("child cls : "+j);

    }
 
	public static void main(String[] args) {
		System.out.println(i);	 
	    System.out.println(j);
	}
	 
}

class ClassOne
{
//	 static int i,j =10 ;
     static int i ;
     static int j = i= 20;
 
     {
         --i;
     	System.out.println("Parent cls : "+i);

     }
 
     {
         j++;
     	System.out.println("Parent cls : "+j);

     }
}
 

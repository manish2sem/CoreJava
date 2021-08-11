package Interview.BT.SIB;
/**
 * Just check when main is called
 * @author Manish
 *
 */
public class ParentCls extends ChildCls{
	static {
        System.out.println("Parent Static");
    }
	public ParentCls(){
		System.out.println("Parent");
	}
	public static void main(String[] args) {
		System.out.println("Main");
		
	    ParentCls parentCls = new ParentCls();
		
	}

}

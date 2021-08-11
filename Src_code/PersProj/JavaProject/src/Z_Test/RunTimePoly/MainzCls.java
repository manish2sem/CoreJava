package Z_Test.RunTimePoly;

public class MainzCls {

	public static void main(String[] args) {
		
		ChildCls childCls = new ChildCls("This is childcls from main");
		
		ChildCls2 childCls2 = new ChildCls2("This is childcls from main");
		
		RootCls rootCls = new RootCls(childCls);
		System.out.println(  " Message is : " +rootCls.getMessage());
		
		
		RootCls rootCls2 = new RootCls(childCls2);
		System.out.println(  " Message is : " +rootCls2.getMessage());
		
		RootCls rootCls3 = new RootCls("This is rootCls from main");
		System.out.println(  " Message is : " +rootCls3.getMessage());

	}

}

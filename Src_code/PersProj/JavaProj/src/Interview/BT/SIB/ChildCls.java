package Interview.BT.SIB;

public class ChildCls {
	static{		
		System.out.println("Static1");
	}
	
    {
		System.out.println("Init");
		
	}

	public ChildCls(){	
		System.out.println("Child");
	}
	
	
	static{
		System.out.println("Static2");		
	}

}

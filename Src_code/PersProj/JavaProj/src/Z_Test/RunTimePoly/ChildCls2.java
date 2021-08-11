package Z_Test.RunTimePoly;

public class ChildCls2 extends RootCls{

	public ChildCls2(RootCls cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	public ChildCls2(String message) {
		super(message);
	}
	
	public String getLocalizedMessage() {
		return "This is from ChildCls2";
	}

}
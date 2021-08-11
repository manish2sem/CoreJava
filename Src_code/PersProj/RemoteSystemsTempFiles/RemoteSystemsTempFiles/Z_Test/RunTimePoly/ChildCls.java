package Z_Test.RunTimePoly;

public class ChildCls extends RootCls{

	public ChildCls(RootCls cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	public ChildCls(String message) {
		super(message);
	}
	
	public String getLocalizedMessage() {
		return "This is from ChildCls";
	}

}

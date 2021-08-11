package Z_Test.RunTimePoly;

public class RootCls {

	private String detailMessage;
	 private RootCls cause = this;

	public RootCls(String message) {
		detailMessage = message;
	}

	public RootCls(RootCls cause) {
		detailMessage = (cause==null ? null : cause.toString());
		this.cause = cause;
	}


	public String getMessage() {
		return detailMessage;
	}

	public String getLocalizedMessage() {
		return getMessage();
	}

	
	/**
	 * getLocalizedMessage() initializes object instance detailMessage.
	 * Note, getLocalizedMessage() is over-ridden by child class of this class.
	 * So which version of getLocalizedMessage is called (to initialize detailMessage)
	 * 		- Depending on object used for calling RootCls constructor.
	 * 
	 * This technique of "run time polymorphism" is used by Factory-Method. 
	 * 
	 */
	public String toString() {
		String s = getClass().getName();
		String message = getLocalizedMessage();
		return (message != null) ? (s + ": " + message) : s;
	}



}

package DessignPattern.HeadFirst.Singleton.B_OtherSingalton.srlztionSoln;



import java.io.ObjectStreamException;
import java.io.Serializable;

public class SerializedSingleton implements Serializable{
	private static final long serialVersionUID = -7604766932017737115L;

	private String str= "This is string";

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	private SerializedSingleton(){}

	private static class SingletonHelper{
		private static final SerializedSingleton instance = new SerializedSingleton();
	}

	public static SerializedSingleton getInstance(){
		return SingletonHelper.instance;
	}    

	private Object readResolve() throws ObjectStreamException {
		// instead of the object we're on, 
		// return the class variable instance
		return SingletonHelper.instance; 
	}

}

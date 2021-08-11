package DessignPattern.HeadFirst.Singleton.C_DestroySrlztion;

public class SingletonCls {

	private String str= "This is string";
	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	private static final SingletonCls instance = new SingletonCls();

	//private constructor to avoid client applications to use constructor
	private SingletonCls(){}

	public static SingletonCls getInstance(){
		return instance;
	}
}

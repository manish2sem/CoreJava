package CoreJava.J_Advance.Reflection.Concept;

public class MySingletonClass {
	private static volatile MySingletonClass instance;
	private String name;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private MySingletonClass(){   
		System.out.println("Constructor invoked");
		
		if (instance != null)
			throw new IllegalStateException();
			

	}

	public static final MySingletonClass getInstance(){
		if ( instance == null){
			synchronized(MySingletonClass.class){
				if ( instance == null){
					instance = new MySingletonClass();
				}
			}

		}
		return instance;

	}

}
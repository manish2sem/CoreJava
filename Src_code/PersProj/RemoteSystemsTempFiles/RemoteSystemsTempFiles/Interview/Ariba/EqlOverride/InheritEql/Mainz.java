package Interview.Ariba.EqlOverride.InheritEql;

public class Mainz {
	public static void main(String[] args) {
		inheritEqlCheck();
	}

	public static void inheritEqlCheck() {
		DogInherit labrador = new DogInherit("Bruno");
		DogInherit alsecian = new DogInherit("Tigerr");
		DogInherit germanShap = new DogInherit("Bruno");
		CatInherit rex = new CatInherit("Bruno");
		CatInherit nul = null;

		System.out.println("labrador.equals(alsecian) " +labrador.equals(alsecian));
		System.out.println(labrador.equals(germanShap));
		System.out.println(alsecian.equals(germanShap));
		System.out.println(germanShap.equals(rex));
		System.out.println("rex.equals(null)" + rex.equals(null));

	}
}

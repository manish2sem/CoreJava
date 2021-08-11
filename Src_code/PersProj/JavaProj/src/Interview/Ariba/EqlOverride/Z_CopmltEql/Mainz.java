package Interview.Ariba.EqlOverride.Z_CopmltEql;

public class Mainz {
	public static void main(String[] args) {
		compltEqlCheck();
	}

	public static void compltEqlCheck() {
		Dog labrador = new Dog("Bruno");
		Dog alsecian = new Dog("Tigerr");
		Dog germanShap = new Dog("Bruno");
		Cat rex = new Cat("Bruno");
		Cat nul = null;

		System.out.println(labrador.equals(alsecian));
		System.out.println(labrador.equals(germanShap));
		System.out.println(alsecian.equals(germanShap));
		System.out.println(germanShap.equals(rex));
		System.out.println(rex.equals(nul));

	}
}

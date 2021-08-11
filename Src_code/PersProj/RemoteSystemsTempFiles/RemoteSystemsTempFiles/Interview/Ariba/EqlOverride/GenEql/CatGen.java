package Interview.Ariba.EqlOverride.GenEql;

public class CatGen {
	String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CatGen(String name) {
		this.name = name;
	}

	public CatGen() {
		this.name = "Default";
	}

	@Override
	public boolean equals(Object obj){

		if(obj !=null && obj instanceof CatGen) {
			CatGen cat = (CatGen) obj; 
			if (cat.getName().equals(this.getName())) {
				return true;
			}
		}

		return false;
	}

}

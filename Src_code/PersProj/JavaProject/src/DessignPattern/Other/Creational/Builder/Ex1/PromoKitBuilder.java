package DessignPattern.Other.Builder;

public abstract class PromoKitBuilder {
	
	public abstract void buildVideoPart();
	public abstract void buildGarmentPart();
	public abstract void buildBookPart();
	public abstract PromoKit getPromoKit();

}


class MenPromoKitBuilder extends PromoKitBuilder {
	
	PromoKit promokit;
	
	public void buildVideoPart(){		
		System.out.println("Add Man Specific Video to promKit");		
	}
	public void buildGarmentPart(){
		System.out.println("Add Man Garment Video to promKit");		
	}
	public void buildBookPart(){
		System.out.println("Add Man Specific book to promKit");		
	}
	
	public PromoKit getPromoKit(){
		return promokit;
	}
}


class WomenPromoKitBuilder extends PromoKitBuilder {
	
	PromoKit promokit;
	public void buildVideoPart(){		
		System.out.println("Add Woman Specific Video to promKit");		
	}
	public void buildGarmentPart(){
		System.out.println("Add Woman Garment Video to promKit");		
	}
	public void buildBookPart(){
		System.out.println("Add Woman Specific book to promKit");		
	}
	public PromoKit getPromoKit(){
		return promokit;
	}
}

class PromoKit{} 
package DessignPattern.Other.Builder;


public class BuilderApplication {
	
public static void main(String [] args) {
		
		String gender = "M";
		PromoKitDirector director = new PromoKitDirector();
		PromoKitBuilder promoKitBuilder=null;
		
		if (gender.equals("M")){
			promoKitBuilder = new MenPromoKitBuilder();
		}else if (gender.equals("W")){
			promoKitBuilder = new MenPromoKitBuilder();
		}
		
		PromoKit result = director.createPromoKit(promoKitBuilder);
	}

}

package Interview.SoftwareAG;


/**
 * 
 * At any particular day you can do one of following
 * 	- Either buy 1 lot
 *  - Do nothing
 *  - Sell all
 *  
 *  Now you need to optimize the profit
 *  
 *  For EX:
 *  		8 10 23 20 12 7 9
 *  
 * @author Manish
 *
 */
public class MaximizeStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int stockPrice[] = {8, 10, 23, 20, 12, 7, 9};
		int max = 0;
		int count = 0;
		
		for (int i=0; i<stockPrice.length; i++){
			if (max > stockPrice[i]) {
				max = stockPrice[i];
			}
		}
		
		for (int i=0; i<stockPrice.length; i++){
			if (max == stockPrice[i]){
				count++;
			}
		}
		
		ProfitForOnePass(stockPrice, max, count,0);

	}
	
	public static void ProfitForOnePass(int price[], int max, int count, int index){
		
		if (count==0 || index == price.length){
			return;
		}
		for (int i=index; i<price.length; i++){
			if (price[i] < max){
				//buy
			}else {
				 
			}
		}
		
	}

}

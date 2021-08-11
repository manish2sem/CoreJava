package DS.Array.Basic.FindMax;

public class B_FindSecondMax {
	public static void main(String[] args) {

		int myArray[] = {1, 2, 4, 7, 8, 4, 3, 9, 10, 2, 32, 6, 2, 8, 5, 41};
		int resultArray[] = findSecondMax(myArray);
		System.out.println("Max of array is : "+resultArray[0]);
		System.out.println("Second Max of array is : "+resultArray[1]);		

	}

	public static int[] findSecondMax(int myArray[]) {	
		int maxTwo[] = new int[2];
		
		if(myArray[0] > myArray[1]) {
			maxTwo[0] = myArray[0];
			maxTwo[1] = myArray[1];
		}else {
			maxTwo[0] = myArray[1];
			maxTwo[1] = myArray[0];
		}
		
		
		int count = 0;
		
		

		for(int i =1; i< myArray.length; i++) {			
			if(maxTwo[1] < myArray[i]) {
				count++;
				if(maxTwo[1] < myArray[i]) {
					maxTwo[1] = maxTwo[0];
					maxTwo[0] = myArray[i];
					
				}else{
					maxTwo[1] = myArray[i];
				}
			
			}			
		}

		System.out.println("No. Of time max altered = "+count);
		return maxTwo;
	}

}
